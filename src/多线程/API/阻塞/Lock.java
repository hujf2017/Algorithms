package 多线程.API.阻塞;

import java.sql.SQLSyntaxErrorException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * @Author hujf
 * @Date 2022/10/14 16:17
 * @Description TODO
 */
public class Lock {

    public static void main(String[] args) throws InterruptedException {
        Lock lock = new Lock();
        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.test();
            }
        }).start();


        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.test();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                lock.test();
            }
        }).start();

        Thread.sleep(5000);

    }
    Semaphore semaphore = new Semaphore(2);
    public void test(){
        boolean b = semaphore.tryAcquire();
        try {
            if(b){
                System.out.println(111);
                Thread.sleep(3000);
                semaphore.release();
            }else {
                System.out.println("超过最大并发数：2，请等待作业队列空闲后使用");
            }

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
