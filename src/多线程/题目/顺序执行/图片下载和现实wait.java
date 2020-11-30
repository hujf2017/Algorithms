package 多线程.题目.顺序执行;

/**
 * @author Hujf
 * @title: 图片下载和现实
 * @date 2020/11/30 0030上午 10:31
 * @description: 使用wait和notify  必须在同步方法里面
 */
public class 图片下载和现实wait {
    //用俩线程 一个下载图片，一个展示图片  先下载 后展示
    public static void main(String[] args) {
        //限制锁对象
        Object obj = new Object();

        Thread download = new Thread(() -> {
            System.out.println("开始下载图片");
            for (int i = 0; i < 101; i++) {

                System.out.println("图片下载进度 " + i);
            }
            System.out.println("下载完成");
            synchronized (obj) {
                obj.notifyAll();//唤起
            }
            System.out.println("开始下载附件");
            for (int i = 0; i < 101; i+=10) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("附件下载" + i + "%");
            }
            });

        Thread showPic = new Thread(() -> {
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
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("打开进度 " + i);
                }

        });

        download.start();
        showPic.start();
    }

}
