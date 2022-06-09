package 多线程.API.join实战航班查询;

/**
 * @Author hujf
 * @Date 2022/5/10 11:18
 * @Description TODO
 */
public class JoinTest {
    public static void main(String[] args) throws InterruptedException {
        Thread a = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(111);
            }
        });
        a.setDaemon(true);
        a.start();
     //   a.join();
        System.out.println("main thread is over ");
    }
}
