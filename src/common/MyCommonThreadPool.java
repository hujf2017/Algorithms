package common;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author Hujf
 * @title: MyCommonThreadPool
 * @date 2020/11/28 0028下午 3:30
 * @description: TODO
 */
public class MyCommonThreadPool {
    static  int corePoolSize=10;

    static int maxPoolSize = 100;
    static  long keepAliveTime = 1;

    static ArrayBlockingQueue workQueue = new ArrayBlockingQueue(10);


    public MyCommonThreadPool() {

    }

}
