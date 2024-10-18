package example;
/**
 * メインクラス。2つのゲートを作成し、来場者をシミュレーションする。
 */

public class Garden
{
    public static void main(String[] args) 
    {
        Counter counter = new Counter();

        // 2つのゲートを作成
        Turnstile westGate = new Turnstile(counter);
        Turnstile eastGate = new Turnstile(counter);

        // 2つのゲートを開始
        westGate.start();
        eastGate.start();

        // 2つのゲートが終了するまで待機
        try
        {
            westGate.join();
            eastGate.join();
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }

        System.out.println("来場者数: " + counter.readValue()); 
    }
}
