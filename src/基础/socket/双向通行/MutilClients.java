package 基础.socket.双向通行;

import java.io.*;
import java.net.Socket;

/**
 * @author Hujf
 * @title: MutilClients
 * @date 2021/1/24 0024下午 8:57
 * @description: TODO
 */
public class MutilClients {

    public static void main(String[] args) throws IOException {
        // 要连接的服务端IP地址和端口
        String host = "127.0.0.1";
        int port = 55534;
        // 与服务端建立连接
        Socket socket = new Socket(host, port);

        //接收消息
        BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        //发送消息
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

        //获取用户输入消息
        BufferedReader userReader = new BufferedReader(new InputStreamReader(System.in));

        String msg = null;
        while(true){
            String input = userReader.readLine();
            writer.write(input + "\n");
            writer.flush();
            msg = reader.readLine();
            System.out.println(msg);
            //如果客户端输入quit就可以跳出循环、断开连接了
            if(input.equals("quit")){
                break;
            }
        }

    }
}
