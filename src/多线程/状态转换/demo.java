package 多线程.状态转换;

import org.junit.Test;

/**
 * @author Hujf
 * @title: demo
 * @date 2020/11/25 0025上午 11:11
 * @description: TODO
 */
public class demo {

    @Test
    public void blockedTest() throws InterruptedException {

        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "a");
        Thread b = new Thread(new Runnable() {
            @Override
            public void run() {
                testMethod();
            }
        }, "b");

        a.start();
        // a.sleep(1000L);
        a.join(1000L);
        b.start();
        System.out.println(a.getName() + ":" + a.getState()); // 输出？
        System.out.println(b.getName() + ":" + b.getState()); // 输出？
    }

    private synchronized void testMethod() {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
