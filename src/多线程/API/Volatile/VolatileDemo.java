package 多线程.API.Volatile;

import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: DolatileDemo
 * @date 2020/11/25 0025上午 11:28
 * @description: TODO
 */
public class VolatileDemo {
    int a =0;
    volatile boolean flag =false;

    final static int MAX= 5;
    static  int init_value =0;
    public static void main(String[] args) {
        new Thread(()->{
           int localValue = init_value;
           while(localValue <MAX){
               if(init_value!=localValue){
                   System.out.println(init_value);
                   localValue =init_value;
               }
           }
        },"Reader").start();

        new Thread(()->{
           int localValue =init_value;
           while(init_value<MAX){
               System.out.println(++localValue);
               init_value =localValue;
               try {
                   TimeUnit.SECONDS.sleep(2);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        },"updater").start();
    }
}
