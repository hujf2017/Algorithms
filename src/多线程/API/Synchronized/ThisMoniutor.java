package 多线程.API.Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: ThisMoniutor
 * @date 2020/11/13 0013下午 8:35
 * @description: TODO
 */
public class ThisMoniutor {
    //这儿synchronized 会导致
    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName()+" enter to method1");

        try {
            TimeUnit.MINUTES.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName()+" enter to method2");

        try {
            TimeUnit.MINUTES.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ThisMoniutor moniutor = new ThisMoniutor();
        new Thread(moniutor::method1,"T1").start();
        new Thread(moniutor::method2,"T2").start();
    }
}
