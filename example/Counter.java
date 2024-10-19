package example;
/**
 * カウンタクラス
 */

import java.util.concurrent.atomic.AtomicInteger;

public class Counter 
{
    private AtomicInteger value = new AtomicInteger(0);
    
    // コンストラクタ
    public Counter()
    {
        value.set(0);
    }

    // カウンタの値を取得
    int readValue(){ return value.get(); }

    // カウンタに1を加える
    void writeValue(){ value.getAndIncrement(); }
}
