package 基础.socket.服务端优化.并发处理能力;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

import javax.net.ssl.SSLServerSocket;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Hujf
 * @title: SocketServer
 * @date 2020/11/28 0028下午 3:01
 * @description: TODO
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        int port = 55555;
        ServerSocket server = new ServerSocket(port);

        System.out.println("等待服务");


        while(true){
            //处理多个socket
            Socket socket = server.accept();
            InputStream inputStream = socket.getInputStream();

            byte []bytes=new byte[1024];
            int len ;
            StringBuffer sb = new StringBuffer();
            while((len =inputStream.read(bytes))!=-1){
                System.out.println(new String(bytes,0,len, StandardCharsets.UTF_8));
                sb.append(new String(bytes,0,len, StandardCharsets.UTF_8));
            }
            System.out.println(sb.toString());
            inputStream.close();
            socket.close();
        }

    }
}
