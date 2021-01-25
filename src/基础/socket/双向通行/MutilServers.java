package 基础.socket.双向通行;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Hujf
 * @title: MutilServers
 * @date 2021/1/24 0024下午 9:04
 * @description: TODO
 */
public class MutilServers {
    public static void main(String[] args) throws IOException {
        final int DEFAULT_PORT = 55534;
        ServerSocket serverSocket = new ServerSocket(DEFAULT_PORT);
        System.out.println("ServerSocket Start,The Port is:" + DEFAULT_PORT);


        while (true) {//不停地监听该端口
            Socket socket = serverSocket.accept();
            System.out.println("Client[" + socket.getPort() + "]Online");
            //接收消息
            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(socket.getInputStream())
            );
            //发送消息
            BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(socket.getOutputStream())
            );

            //获取用户输入消息
            BufferedReader userReader = new BufferedReader(new InputStreamReader(System.in));

            String msg = null;
            while((msg=reader.readLine())!=null){
                String input = userReader.readLine();
                System.out.println("Client[" + socket.getPort() + "]:" + msg);
                System.out.println("Client[" + socket.getPort() + "]:" + input);
                //写入服务端要发送的消息
                writer.write("Server:" + input + "\n");
                writer.flush();
                //如果客户端的消息是quit代表他退出了，并跳出循环，不用再接收他的消息了。如果客户端再次连接就会重新上线
                if (msg.equals("quit")) {
                    System.out.println("Client[" + socket.getPort() + "]:Offline");
                    break;
                }
            }



        }



    }
}
