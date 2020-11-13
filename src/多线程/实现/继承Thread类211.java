package 多线程.实现;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 继承Thread类211
 * @date 2020/10/20 0020下午 5:35
 * @description: 继承Thread
 */
public class 继承Thread类211 {
    public class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }
    @Test
    public void test(){
        Thread myThread = new MyThread();
        myThread.start();
    }
}
