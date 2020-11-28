package 基础.socket.双向通行;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Hujf
 * @title: SocketServer
 * @date 2020/11/27 0027下午 3:38
 * @description: TODO
 */
public class SocketServer {
    public static void main(String[] args) throws IOException {
        int port = 55533;
        ServerSocket server = new ServerSocket(port);

        //等待连接
        System.out.println("等待连接...");
        //接受所有socket
        Socket socket = server.accept();
        //获得输入
        InputStream inputStream = socket.getInputStream();
        byte [] bytes=new byte[1024];
        while (true) {
//            int frist =inputStream.read();
//            if(frist==-1){
//                break;
//            }
//            int second = inputStream.read();
//            int len =(frist<<8)+second;
//            bytes = new byte[len];
//            // 然后读取指定长度的消息即可
//            inputStream.read(bytes);
//            System.out.println("get message from client: " + new String(bytes, "UTF-8"));
            StringBuilder stringBuilder = new StringBuilder();
            int len = inputStream.read(bytes);
            if(len==-1){
                break;
            }
            stringBuilder.append(new String(bytes,0,len,StandardCharsets.UTF_8));

            System.out.println("获取到信息：" + stringBuilder);

            OutputStream outputStream = socket.getOutputStream();
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            outputStream.write(s.getBytes("UTF-8"));
            outputStream.flush();

            inputStream.close();
            outputStream.close();
            socket.close();
            server.close();

        }

    }
}
