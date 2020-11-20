package 多线程.API.线程间通讯;

import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: EventClient
 * @date 2020/11/19 0019下午 9:59
 * @description: TODO
 */
public class EventClient {
    public static void main(String [] args){
        final EventQueue eventQueue = new EventQueue();
        new Thread(()->{
            while (true){
                eventQueue.offer(new EventQueue.Event());
            }
        },"producer").start();

        new Thread(()->{
            while (true){
                eventQueue.take();
                try {
                    TimeUnit.MILLISECONDS.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"Consumer").start();
    }
}
