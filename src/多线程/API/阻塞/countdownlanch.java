package 多线程.API.阻塞;

import java.util.concurrent.CountDownLatch;

/**
 * @Author hujf
 * @Date 2022/3/24 11:19
 * @Description TODO
 */
public class countdownlanch {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch count = new CountDownLatch(3);
        new Thread(() -> {
            System.out.println(count.getCount());
            count.countDown();

        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(count.getCount());
                count.countDown();
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(count.getCount());
                count.countDown();
            }
        }).start();
        count.await();
        System.out.println("end");
    }
}
