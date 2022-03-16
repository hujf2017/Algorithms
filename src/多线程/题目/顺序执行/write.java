package 多线程.题目.顺序执行;

import org.junit.Test;

/**
 * @Author hujf
 * @Date 2022/3/15 11:13
 * @Description TODO
 */
public class write {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            for(int i=1;i<=4;i++){
                System.out.println("thread 1: "+i);
                if(i==4){
                    i=0;
                }
            }
        });
        t1.start();
        Thread t2 = new Thread(() -> {
            for(int i=2;i<=4;i++){
                System.out.println("thread 2: "+i);
                if(i==4){
                    i=i-4;
                }
            }
        });
        t2.start();
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=3;i<=4;i++){
                    System.out.println("thread 3: "+i);
                    if(i==4){
                        i=i-4;
                    }
                }
            }
        });
        t3.start();
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i=4;i<=4;i++){
                    System.out.println("thread 4: "+i);
                    if(i==4){
                        i=i-4;
                    }
                }
            }
        });
        t4.start();
    }
}
