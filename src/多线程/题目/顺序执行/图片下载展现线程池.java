package 多线程.题目.顺序执行;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: 图片下载展现join线程池
 * @date 2020/11/30 0030下午 12:01
 * @description: TODO
 */
public class 图片下载展现线程池 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10,100,1L, TimeUnit.SECONDS,new ArrayBlockingQueue(10));
        //限制锁对象
        Object obj = new Object();
        Runnable runnable =()->{
            System.out.println("开始下载图片");
            for (int i = 0; i < 101; i++) {

                System.out.println("图片下载进度 " + i);
            }
            System.out.println("下载完成");
            synchronized (obj) {
                obj.notify();//唤起
            }
            System.out.println("开始下载附件");
            for (int i = 0; i < 101; i+=10) {
                System.out.println("附件下载" + i + "%");
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        };

        Runnable runnable1 = ()->{
            synchronized (obj) {
                try {
                    obj.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("正在打开图片");
            for (int i = 0; i < 101; i++) {
                try {
                    Thread.sleep(10);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                System.out.println("打开进度 " + i);
            }

        };
        executor.submit(runnable);
        executor.submit(runnable1);


    }
}
