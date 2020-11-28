package 基础.socket.双向通行;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Hujf
 * @title: SocketClient
 * @date 2020/11/27 0027下午 3:47
 * @description: TODO
 */
public class SocketClient {
    public static void main(String[] args) throws IOException {
        String host = "127.0.0.1";
        int port = 55533;

            Socket socket = new Socket(host, port);
        OutputStream outputStream = socket.getOutputStream();
        while(true) {
            Scanner scan = new Scanner(System.in);
            String s = scan.nextLine();
            outputStream.write(s.getBytes(StandardCharsets.UTF_8));
//          socket.shutdownOutput();
            outputStream.flush();
            //获取到输入流
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sbf = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sbf.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
            }
            System.out.println("get message " + sbf);

            inputStream.close();
            outputStream.close();
            socket.close();
        }



    }
}
