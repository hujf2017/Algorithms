package 多线程.并发包.atomic;

/**
 * @Author hujf
 * @Date 2022/11/29 16:12
 * @Description TODO
 */
public class Lockwait {
    public static void main(String[] args) {
        TesWait o = new TesWait();
        o.start();

        synchronized (o) {
            try {
                Thread.sleep(3000);
                o.wait();
                Thread.sleep(3000);
                System.out.println(123);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    static class TesWait extends Thread {

        @Override
        public void run() {
            synchronized (this) {
                System.out.println(111);
            }
        }
    }
}
