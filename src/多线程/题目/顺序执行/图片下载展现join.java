package 多线程.题目.顺序执行;

/**
 * @author Hujf
 * @title: 图片下载展现join
 * @date 2020/11/30 0030上午 11:11
 * @description: join实现
 */
public class 图片下载展现join {
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
            System.out.println("开始下载附件");
            for (int i = 0; i < 101; i+=10) {
                System.out.println("附件下载" + i + "%");
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread showPic = new Thread(() -> {
            try {
                download.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("正在打开图片");
            for (int i = 0; i < 101; i++) {

                System.out.println("打开进度 " + i);
            }

        });

        download.start();
        showPic.start();
    }
}
