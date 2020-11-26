package 多线程.API.Hook线程以及捕获;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: Demo
 * @date 2020/11/24 0024下午 4:53
 * @description: 线程异常捕获
 */
public class Demo {

    public static void main(String[] args){
        Thread.setDefaultUncaughtExceptionHandler((t,e)->{
            System.out.println(t.getName()+" ");
            e.printStackTrace();
        });

        final Thread thread = new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
            }
            System.out.println(1/0);
        },"test-thread");
        thread.start();
    }
}
