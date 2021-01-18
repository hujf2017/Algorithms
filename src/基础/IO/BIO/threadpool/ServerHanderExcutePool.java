package 基础.IO.BIO.threadpool;

import java.util.Deque;
import java.util.concurrent.*;

/**
 * @author Hujf
 * @title: ServerHanderExcutePool
 * @date 2021/1/18 0018下午 2:05
 * @description: 创建一个线程池
 */
public class ServerHanderExcutePool {

    private ExecutorService executorService;
    //ThreadFactory guavaThreadFactory = new ThreadFactoryBuilder().setNameFormat("retryClient-pool-").build();

    public ServerHanderExcutePool(int max,int queSize){
        executorService = new ThreadPoolExecutor(4,max,10L, TimeUnit.SECONDS,new ArrayBlockingQueue(queSize));

    }
    public void execute(Runnable task){
        executorService.execute(task);
    }
}
