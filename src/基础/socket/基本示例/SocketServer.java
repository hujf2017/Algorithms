package 基础.socket.基本示例;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Hujf
 * @title: SocketServer
 * @date 2020/11/27 0027下午 2:24
 * @description: socket服务端代码
 */
public class SocketServer {

    public static void main(String[] args) throws IOException {
        int port  = 55533;
        //创建一个服务
        ServerSocket server = new ServerSocket(port);
        //server将一直等待服务的到来
        System.out.println("等待中...");
       // Socket socket = new Socket();
        Socket socket = server.accept();
        //获取到输入流
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream buf = new BufferedInputStream(inputStream);
        byte[] b = new byte[1024];
        int len ;
        StringBuilder stringBuilder = new StringBuilder();
        while((len=buf.read(b))!=-1){
            stringBuilder.append(new String(b,0,len, StandardCharsets.UTF_8));
        }
        System.out.println("得到数据"+stringBuilder);
        inputStream.close();
        socket.close();
        server.close();
    }
}
