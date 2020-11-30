package 多线程.API.Volatile;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: PoolVolatileDemo
 * @date 2020/11/29 0029下午 3:19
 * @description: TODO
 */
public class PoolVolatileDemo {

    final static int MAX= 100;
    static volatile int init_value =0;
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,100,1L, TimeUnit.SECONDS,new ArrayBlockingQueue<>(10));

//        Runnable runnable =()->{
//
//            int localValue = init_value;
//            while(localValue <MAX){
//                if(init_value!=localValue){
//                    System.out.println(init_value);
//                    localValue =init_value;
//                }
//            }
//        };
//
//        Runnable runnable2 =()->{
//            int localValue =init_value;
//            while(init_value<MAX){
//                System.out.println(++localValue);
//                init_value =localValue;
//                try {
//                    TimeUnit.SECONDS.sleep(2);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }
//        };
        Runnable runnable=()->{
            int k =0;
          while(k<MAX){
              System.out.println(Thread.currentThread().getName()+" "+k);
              k++;
          }

        };

        executor.submit(runnable);
 //       executor.submit(runnable2);
    }
}
