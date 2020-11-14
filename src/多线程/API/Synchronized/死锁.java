package 多线程.API.Synchronized;

/**
 * @author Hujf
 * @title: 死锁
 * @date 2020/11/13 0013下午 9:00
 * @description: TODO
 */
public class 死锁 {
//    public static void main(String[] args) {
//        Thread t = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                while(true){}
//            }
//        },"cicurThread");
//        t.start();
//    }
static class SynAddRunalbe implements Runnable {
    int a, b;
    public SynAddRunalbe(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public void run() {
        synchronized (Integer.valueOf(a)) {
            synchronized (Integer.valueOf(b)) {
                System.out.println(a + b);
            }
        }
    }
}

    public static void main(String[] args) {
        for (int i = 0; i < 300; i++) {
            new Thread(new SynAddRunalbe(1, 2)).start();
            new Thread(new SynAddRunalbe(2, 1)).start();
        }
    }

}
