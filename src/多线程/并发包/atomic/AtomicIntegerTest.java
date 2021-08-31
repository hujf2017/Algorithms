package 多线程.并发包.atomic;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Hujf
 * @title: AtomicIntegerTest
 * @date 2021-08-31 15:39
 * @description: 原子int
 */
public class AtomicIntegerTest implements Runnable {

    private static int m = 0;

    AtomicBoolean atomicBoolean = new AtomicBoolean();
    private static AtomicInteger integer = new AtomicInteger(0);
    String name;

    public AtomicIntegerTest(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        for (int j = 0; j < 5000; j++) {
            m++;
            integer.getAndIncrement();
        }
        cdl.countDown();
    }
//        while (integer.intValue() < 100) {
//            System.out.println(integer.getAndIncrement());
//        }

    static CountDownLatch cdl = new CountDownLatch(2);

    public static void main(String[] args) throws InterruptedException {

        AtomicIntegerTest a = new AtomicIntegerTest("a");
        AtomicIntegerTest b = new AtomicIntegerTest("b");
        new Thread(a).start();
        new Thread(b).start();

        cdl.await();
        System.out.println(m);
        System.out.println(integer.get());
//        CountDownLatch cdl = new CountDownLatch(2);
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int j = 0; j < 5000; j++) {
//                    m++;
//                }
//                cdl.countDown();
//            }
//        });
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int j = 0; j < 5000; j++) {
//                    m++;
//                }
//                cdl.countDown();
//            }
//        });
//        t1.start();
//        t2.start();
//
//        cdl.await();
//        System.out.println("result=" + m);
    }
}
