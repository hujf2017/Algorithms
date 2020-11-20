package 多线程.API.Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: ThisMoniutor
 * @date 2020/11/13 0013下午 8:35
 * @description: TODO
 */
public class ClassMoniutor {
    //这儿synchronized 会导致
    public static synchronized void method1(){
        System.out.println(Thread.currentThread().getName()+" enter to method1");

        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static synchronized void method2(){
        System.out.println(Thread.currentThread().getName()+" enter to method2");

        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
       // ClassMoniutor moniutor = new ClassMoniutor();
        new Thread(ClassMoniutor::method1,"T1").start();
        new Thread(ClassMoniutor::method2,"T2").start();
    }
}
