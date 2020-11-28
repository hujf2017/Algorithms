package 基础.socket.服务端优化.并发处理能力;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * @author Hujf
 * @title: MutilSocketClient
 * @date 2020/11/27 0027下午 4:34
 * @description: TODO
 */
public class MutilSocketClient {
    public static void main(String args[]) throws Exception {

        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55555;
//        // 与服务端建立连接
//        Socket socket = new Socket(host, port);
//        // 建立连接后获得输出流
//        OutputStream outputStream = socket.getOutputStream();
//        String message = "你好  yiwangzhibujian";
//        //首先需要计算得知消息的长度
//        byte[] sendBytes = message.getBytes(StandardCharsets.UTF_8);
//        //然后将消息的长度优先发送出去
//        outputStream.write(sendBytes.length >>8);
//        System.out.println(new String(sendBytes,StandardCharsets.UTF_8));
//        outputStream.write(sendBytes.length);
//        //然后将消息再次发送出去
//        outputStream.write(sendBytes);
//        outputStream.flush();
//        //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
//        message = "第二条消息";
//        sendBytes = message.getBytes(StandardCharsets.UTF_8);
//        outputStream.write(sendBytes.length >>8);
//        outputStream.write(sendBytes.length);
//        outputStream.write(sendBytes);
//        outputStream.flush();
//        //==========此处重复发送一次，实际项目中为多个命名，此处只为展示用法
//        message = "the third message!";
//        sendBytes = message.getBytes(StandardCharsets.UTF_8);
//        outputStream.write(sendBytes.length >>8);
//        outputStream.write(sendBytes.length);
//        outputStream.write(sendBytes);
//
//
//
//
//
//        outputStream.close();
//        socket.close();
//        // 要连接的服务端IP地址和端口
//        String host = "127.0.0.1";
//        int port = 55534;


        while(true){
            // 与服务端建立连接
            Socket socket = new Socket(host, port);
            // 建立连接后获得输出流
            OutputStream outputStream = socket.getOutputStream();

            InputStreamReader read = new InputStreamReader(System.in);
            BufferedReader buf = new BufferedReader(read);

            String message = buf.readLine();
            //首先需要计算得知消息的长度
            byte[] sendBytes = message.getBytes("UTF-8");
            //然后将消息的长度优先发送出去
            outputStream.write(sendBytes.length >>8);
            outputStream.write(sendBytes.length);
            //然后将消息再次发送出去
            outputStream.write(sendBytes);
            outputStream.flush();

            //得到返回数据
            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            int len;
            StringBuilder sbf = new StringBuilder();
            while ((len = inputStream.read(bytes)) != -1) {
                sbf.append(new String(bytes, 0, len, StandardCharsets.UTF_8));
            }
            System.out.println("get message " + sbf);

            outputStream.close();
            socket.close();
        }

    }

}
