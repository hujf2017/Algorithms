package 多线程.并发包.atomic;

import org.junit.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * @author Hujf
 * @title: AtomicBooleanTest
 * @date 2021-08-31 15:14
 * @description: 原子布尔判断
 */
public class AtomicBooleanTest {

    ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 20, 1L, TimeUnit.SECONDS, new ArrayBlockingQueue(10));

    @Test
    public void t() {
        AtomicBoolean atomicBoolean = new AtomicBoolean();
        executor.execute(new Runnable() {
            @Override
            public void run() {
                Thread name = Thread.currentThread();
                ;
                if (atomicBoolean.compareAndSet(false, true)) {
                    System.out.println(Thread.currentThread() + " enter");
                    System.out.println(name + " working");
                    System.out.println(name + " leave");
                    atomicBoolean.set(false);
                } else {
                    System.out.println(name + " give up");
                }
            }
        });

        executor.execute(new Runnable() {
            @Override
            public void run() {
                Thread name = Thread.currentThread();
                ;
                if (atomicBoolean.compareAndSet(false, true)) {
                    System.out.println(Thread.currentThread() + " enter");
                    System.out.println(name + " working");
                    System.out.println(name + " leave");
                    atomicBoolean.set(false);
                } else {
                    System.out.println(name + " give up");
                }
            }
        });

    }
}
