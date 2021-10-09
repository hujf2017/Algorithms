package 多线程.异步编程.ep1;

import java.util.concurrent.locks.LockSupport;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Hujf
 * @title: FutureData
 * @date 2021-10-08 21:48
 * @description: TODO
 */
public class FutureData implements Data{
    private RealData realData = null;
    private boolean isready = false;
    @Override
    public String getResult() throws InterruptedException {
        if(!isready){
            LockSupport.park();
        }
        return realData.getResult();
    }

    public void setData(RealData realData) {
        if(isready){
            return;
        }
        this.realData = realData;
        isready = true;
        LockSupport.unpark(Thread.currentThread());
    }
}
