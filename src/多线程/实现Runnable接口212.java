package 多线程;

import org.junit.Test;

/**
 * @author Hujf
 * @title: 实现Runnable接口212
 * @date 2020/10/20 0020下午 5:37
 * @description: TODO
 */
public class 实现Runnable接口212 {
    public  class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread");
        }
    }
    @Test
    public void test(){
        new Thread(new MyThread()).start();

        new Thread(() -> {
            System.out.println("Java 8 匿名内部类");
        }).start();
    }
}
