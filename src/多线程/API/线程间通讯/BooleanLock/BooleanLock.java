package 多线程.API.线程间通讯.BooleanLock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

/**
 * @author Hujf
 * @title: BooleanLock
 * @date 2020/11/23 0023下午 10:28
 * @description: TODO
 */
public class BooleanLock implements Lock {

    private Thread currentThread;
    private boolean locked=false;
    private final List<Thread> blockedList = new ArrayList<>();

    @Override
    public void lock() {
        synchronized(this){
            while(locked){
                    blockedList.add(Thread.currentThread());
                try {
                    this.wait(); 
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            blockedList.remove(Thread.currentThread());
            this.locked =true;
            this.currentThread= Thread.currentThread();
        }
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {

    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
