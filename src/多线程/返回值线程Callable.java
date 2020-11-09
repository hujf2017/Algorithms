package 多线程;
import java.util.concurrent.*;

/**
 * @author Hujf
 * @title: 返回值线程Callable
 * @date 2020/11/7 0007下午 10:39
 * @description: TODO
 */
public class 返回值线程Callable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 2;
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        //创建线程池 执行线程
        ExecutorService executor = Executors.newCachedThreadPool();
        返回值线程Callable task = new 返回值线程Callable();
        Future<Integer> result = executor.submit(task);
        System.out.println(result.get());
    }
}
