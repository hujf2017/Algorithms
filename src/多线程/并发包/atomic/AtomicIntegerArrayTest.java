package 多线程.并发包.atomic;

import java.util.concurrent.atomic.AtomicIntegerArray;

/**
 * @author Hujf
 * @title: AtomicIntegerArrayTest
 * @date 2021-08-31 16:07
 * @description: arrayTest
 */
public class AtomicIntegerArrayTest implements Runnable{
    private static AtomicIntegerArray atomicIntegerArray = new AtomicIntegerArray(10);
    private static int []array  = new int[10];
    private static int num =0;
    public static void main(String[] args) {
        AtomicIntegerArrayTest a = new AtomicIntegerArrayTest();
        AtomicIntegerArrayTest b = new AtomicIntegerArrayTest();
        new Thread(a).start();
        new Thread(b).start();
    }

    @Override
    public void run() {
        for(int i=0;i<5000;i++){
            array[i%array.length]+=1;
        }
    }
}
