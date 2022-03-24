package 多线程.API.阻塞;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @Author hujf
 * @Date 2022/3/24 11:21
 * @Description 等上一步完成之后 执行下一步
 */
public class CyclicBarriers {
    public static void main(String[] args) throws BrokenBarrierException, InterruptedException {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);


        for(int i=0;i<3;i++){
            new Thread(()->{
                System.out.println(123);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("123 redy go");
            }).start();


            new Thread(()->{
                System.out.println(456);
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }

                System.out.println("456 redy go");
            }).start();
            Thread.sleep(2000);
        }




//
//        new Thread(()->{
//            System.out.println(456);
//            try {
//                cyclicBarrier.await();
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            } catch (BrokenBarrierException e) {
//                e.printStackTrace();
//            }
//
//            System.out.println("456 redy go");
//        }).start();
    }
}
