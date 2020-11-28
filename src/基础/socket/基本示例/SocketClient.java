package 基础.socket.基本示例;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Hujf
 * @title: SocketClient
 * @date 2020/11/27 0027下午 2:34
 * @description: TODO
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        String host ="127.0.0.1";
        int port = 55533;
        //创建套接字
        Socket socket = new Socket(host,port);
        //建立连接后可以获取到输出流
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream buf =new BufferedOutputStream(outputStream);
        String s = "hello this is my frist server ";
        buf.write(s.getBytes(StandardCharsets.UTF_8));
        buf.close();
        socket.close();
    }
}
