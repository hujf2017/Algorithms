package 多线程.API;

/**
 * @Author hujf
 * @Date 2022/8/8 11:14
 * @Description 主进程结束就停止
 */
public class 守护进程 {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("new Thread end ");
            }
        });

        thread.setDaemon(true);

        thread.start();
        System.out.println("main end ");
    }
}
