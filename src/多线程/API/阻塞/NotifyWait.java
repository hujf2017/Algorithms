package 多线程.API.阻塞;

/**
 * @Author hujf
 * @Date 2022/3/24 11:18
 * @Description TODO
 */
public class NotifyWait {

    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();
        new Thread(() -> {
            synchronized (o) {
                System.out.println(123);
                try {
                    o.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("123 finish");
            }
        }).start();
        new Thread(() -> {
            synchronized (o) {
                System.out.println(456);
                try {
                    Thread.sleep(2000);
                    System.out.println("456 sing 123");
                    o.notify();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        Thread.sleep(5000);
    }
}
