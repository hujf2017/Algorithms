package 基础.socket.基本使用3;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Hujf
 * @title: Client
 * @date 2021-06-02 16:15
 * @description: socket编程
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",8080);
        String  s = "test !!!";
        OutputStream outputStream = socket.getOutputStream();
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
        bufferedOutputStream.write(s.getBytes(StandardCharsets.UTF_8));
        bufferedOutputStream.close();
        socket.close();
    }
}
