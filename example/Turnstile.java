package example;
/**
 * 西門または東門を表すゲートのクラス
 */

public class Turnstile extends Thread
{
    private Counter counter;

    // コンストラクタ
    public Turnstile(Counter counter)
    {
        this.counter = counter;
    }

    // 任意のタイミングでカウンタに1を加える
    @Override
    public void run()
    {
        for (int i = 0; i < 10000; i++)
        {
            counter.writeValue();
            try
            {
                Thread.sleep(1);
            }
            catch (InterruptedException e)
            {
                e.printStackTrace();
            }
        }
    }
}
