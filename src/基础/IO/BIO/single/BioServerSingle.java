package 基础.IO.BIO.single;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Hujf
 * @title: BioServerSingle
 * @date 2021/1/18 0018上午 8:38
 * @description: TODO
 */
public class BioServerSingle {
    public static void main(String[] args) {
        int port = 55533;
        ServerSocket serverSocket = null;
        Socket socket = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务启动---------------------");
            //接收一个连接客户端 接收消息
            socket = serverSocket.accept();
            //获得连接请求的输出
            in = socket.getInputStream();
//
            byte[] b = new byte[1024];
            BufferedInputStream bufferedInput = new BufferedInputStream(in);
            int n;
            StringBuilder stringBuilder = new StringBuilder();
            while ((n = bufferedInput.read(b)) != -1) {//阻塞
                stringBuilder.append(new String(b, 0, n, StandardCharsets.UTF_8));
            }
            System.out.println("得到数据" + stringBuilder);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    in.close();
                    out.close();
                    socket.close();
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
