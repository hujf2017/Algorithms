package 多线程.API;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author Hujf
 * @title: join使用
 * @date 2020/11/11 0011下午 9:55
 * @description: TODO
 */
public class join使用 {
    public static void main(String[] args) throws InterruptedException {
        //范围书
        IntStream k = IntStream.range(1,5);
        System.out.println(IntStream.range(1,3).max());
        List<Thread> threads=  k.mapToObj(join使用::create).collect(Collectors.toList());
//        threads.forEach(o->{
//            o.start();
//        });
        //启动两个线程
        threads.forEach(Thread::start);

        for(Thread t:threads){
            t.join();
        }
        for(int i=0;i<10;i++){
            System.out.println(Thread.currentThread().getName()+"#"+i);
            shortSleep();
        }
    }


    private static  Thread create(int seq){
        //实现了run方法
        return new Thread(()->{
            for(int i=0;i<10;i++){
                System.out.println(Thread.currentThread().getName()+"#"+i);
                shortSleep();
            }
        },String.valueOf(seq));

    }

    private static void shortSleep() {
        try{
            TimeUnit.SECONDS.sleep(1);
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
