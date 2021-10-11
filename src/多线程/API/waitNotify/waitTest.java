package 多线程.API.waitNotify;

import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: waitTest
 * @date 2021-10-11 9:09
 * @description: wait时  会释放被占有的锁
 */
public class waitTest {
    public static void main(String[] args) throws InterruptedException {
        Object o = new Object();

        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println(Thread.currentThread().getName());
                    try {
                        //释放锁
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"唤醒了 子线程");
                }
            }
        });

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println(Thread.currentThread().getName());
                    try {
                        //释放锁
                        o.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName()+"唤醒了 子线程");
                }
            }
        });

        t1.start();
        t.start();

        Thread.sleep(1000);
        System.out.println("睡醒了 主线程");

        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (o){
                    System.out.println(Thread.currentThread().getName()+" 唤醒所有被锁的资源");
                    o.notifyAll();
                    System.out.println(Thread.currentThread().getName()+" 释放自己的资源");
                }
            }
        });
        t2.start();
    }
}
