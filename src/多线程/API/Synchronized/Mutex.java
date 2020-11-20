package 多线程.API.Synchronized;

import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: Mutex
 * @date 2020/11/19 0019下午 9:00
 * @description: TODO
 */
public class Mutex {
    public final static Object MUTEX =new Object();

    public void accessResource(){
        synchronized(MUTEX){
            try {
                TimeUnit.MINUTES.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args){
        final Mutex mutex =new Mutex();
        for(int i=0;i<5;i++){
            new Thread(mutex::accessResource).start();
        }
    }
}
