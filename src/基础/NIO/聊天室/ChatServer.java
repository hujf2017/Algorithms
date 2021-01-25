package 基础.NIO.聊天室;

import java.io.Writer;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @author Hujf
 * @title: ChatServer
 * @date 2021/1/24 0024下午 9:26
 * @description: TODO
 */
public class ChatServer {
    int port = 8888;
    private Map<Integer, Writer> map=new ConcurrentHashMap<>();

    private ExecutorService executorService= new ThreadPoolExecutor(4,10,10L, TimeUnit.SECONDS,new ArrayBlockingQueue(10));
    public static void main(String[] args) {
        //
    }
}
