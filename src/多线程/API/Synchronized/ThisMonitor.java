package 多线程.API.Synchronized;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.currentThread;
/**
 * @author Hujf
 * @title: ThisMonitor
 * @date 2020/11/19 0019下午 9:28
 * @description: TODO
 */
public class ThisMonitor {

    public synchronized void method1(){
        System.out.println(Thread.currentThread().getName()+" enter to method1");
        try {
            TimeUnit.MINUTES.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void method2(){
        System.out.println(Thread.currentThread().getName()+" ");
    }
}
