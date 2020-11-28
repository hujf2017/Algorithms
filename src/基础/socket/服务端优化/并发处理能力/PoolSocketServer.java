package 基础.socket.服务端优化.并发处理能力;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import java.util.concurrent.*;

/**
 * @author Hujf
 * @title: PoolSocketServer
 * @date 2020/11/28 0028下午 3:21
 * @description: TODO
 */
public class PoolSocketServer {
    public static void main(String[] args) throws IOException {
        int port =55555;
        ServerSocket server = new ServerSocket(port);
        System.out.println("等待连接中...");
        //大小100的线程池 强制静止使用这种方式
      //  ExecutorService service = Executors.newFixedThreadPool(100);
        //手动创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor (10,100,1L,TimeUnit.SECONDS,new ArrayBlockingQueue(10));

        while(true){
            Socket socket = server.accept();

            Runnable runnable =()->{
                try {
                    InputStream inputStream = socket.getInputStream();
                    byte[] bytes = new byte[1024];
                    int len ;
                    StringBuilder builder = new StringBuilder();
                    while((len =inputStream.read(bytes))!=-1){
                        System.out.println(new String(bytes,0,len, StandardCharsets.UTF_8));
                        builder.append(new String(bytes,0,len, StandardCharsets.UTF_8));
                    }
                    System.out.println(builder.toString());

                    Scanner scan = new Scanner(System.in);
                    String s = scan.nextLine();
                    System.out.println(s);
                    OutputStream outputStream = socket.getOutputStream();
                    outputStream.write(s.getBytes(StandardCharsets.UTF_8));
                    outputStream.flush();
                    inputStream.close();
                    socket.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

            };
            executor.submit(runnable);
        }
    }
}
