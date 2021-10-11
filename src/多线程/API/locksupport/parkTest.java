package 多线程.API.locksupport;

import java.util.concurrent.locks.LockSupport;

/**
 * @author Hujf
 * @title: parkTest
 * @date 2021-10-11 9:23
 * @description: 因为没有了sync 所有就不需要资源  直接用park  就可以实现阻塞
 */
public class parkTest {
    public static void main(String[] args) throws InterruptedException {
        Thread t1= new Thread(()-> {
            System.out.println("park begin");
            LockSupport.park();
            System.out.println("park end");
        });
        t1.start();

        new Thread(()-> {
            System.out.println("unpark begin");

            System.out.println("unpark end");
        }).start();

        Thread.sleep(2000);

        LockSupport.unpark(t1);
    }
}
