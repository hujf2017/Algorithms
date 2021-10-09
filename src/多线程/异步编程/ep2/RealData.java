package 多线程.异步编程.ep2;

import java.util.concurrent.Callable;

/**
 * @author Hujf
 * @title: RealData
 * @date 2021-10-08 22:06
 * @description: TODO
 */
public class RealData implements Callable {
    private String data;

    public RealData(String data) {
        this.data = data;
    }
    @Override
    public String call() throws Exception {
        //利用sleep方法来表示真是业务是非常缓慢的
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return data;
    }
}
