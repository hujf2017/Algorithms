package 多线程.API.Synchronized;

/**
 * @author Hujf
 * @title: TicThread
 * @date 2020/11/13 0013下午 7:55
 * @description: TODO
 */
public class TicThread implements Runnable {
    private int index = 1;

    private final int max = 10000;
    private   Object Mutex = new Object();

    @Override
    public void run() {
        while (true) {
            synchronized (Mutex) {
                if (index <= max) {
                    System.out.println(Thread.currentThread().getName() + " " + index);
                    index++;
//                    try {
//                        Thread.sleep(100);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
                }else{
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        final TicThread t = new TicThread();
        Thread t1 = new Thread(t, "frist");
        Thread t2 = new Thread(t, "second");
        Thread t3 = new Thread(t, "thrid");
        Thread t4 = new Thread(t, "fourth");
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
