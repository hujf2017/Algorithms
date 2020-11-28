package 基础.socket.双向通行;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Hujf
 * @title: MutilSocketServer
 * @date 2020/11/27 0027下午 4:34
 * @description: TODO
 */
public class MutilSocketServer {
    public static void main(String[] args) throws IOException {
        int port = 55534;
        ServerSocket server = new ServerSocket(port);
        System.out.println("等待连接");
        Socket socket = server.accept();

        //获得输入
        InputStream inputStream = socket.getInputStream();
        byte [] bytes;
        while(true){
            int frist =inputStream.read();
            if(frist==-1){
                break;
            }
            int second = inputStream.read();
            int len =(frist<<8)+second;
            bytes = new byte[len];
            // 然后读取指定长度的消息即可
            inputStream.read(bytes);
            System.out.println("get message from client: " + new String(bytes, "UTF-8"));
        }
        inputStream.close();
        socket.close();
        server.close();
    }
}
