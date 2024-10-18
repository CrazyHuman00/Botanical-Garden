ANT	= env LC_ALL=ja_JP.UTF-8 ant
ARCHIVE	= $(shell basename `pwd`)
SOURCES	= $(shell find . -name "*.java")

all:
	$(ANT) all

clean:
	$(ANT) clean

test:
	$(ANT) test

unittest:
	${ANT} unittest

assert:
	${ANT} assert

install:
	$(ANT) install

doc:
	$(ANT) doc

wipe: clean
	@find . -name ".DS_Store" -exec rm {} ";" -exec echo rm -f {} ";"
	(cd ../ ; rm -f ./$(ARCHIVE).zip)


zip: wipe
	@find . -exec touch -t `date "+%Y%m%d%H%M"` {} \; ; xattr -cr .
	(cd ../ ; zip -r ./$(ARCHIVE).zip ./$(ARCHIVE)/ --exclude='*/.svn/*')

format:
	@rm -f $(STYLE_CONF) ; ln -s $(STYLE_YAML) $(STYLE_CONF)
	for each in $(SOURCES) ; do echo ---[$${each}]--- ; clang-format -style=file $${each} ; echo ; done
	@rm -f $(STYLE_CONF)

app: install
	@xattr -cr ./Example.app
	open ./Example.app
