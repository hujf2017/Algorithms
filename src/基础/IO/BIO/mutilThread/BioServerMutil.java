package 基础.IO.BIO.mutilThread;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Hujf
 * @title: BioServerSingle
 * @date 2021/1/18 0018上午 8:38
 * @description: TODO
 */
public class BioServerMutil {
    public static void main(String[] args) {
        int port = 8080;
        ServerSocket serverSocket = null;
        Socket socket=null;
        InputStream in =null;
        OutputStream out=null;
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("服务启动---------------------");
            while(true) {
                //接收一个连接客户端 接收消息
                socket = serverSocket.accept();
                //采用多线程处理阻塞逻辑
                new Thread(new SocketHandle(socket)).start();

                //获得连接请求的输出
//                in = socket.getInputStream();

//                byte[] buffer =new byte[1024];
//                int len=0;
//                while((len=in.read(buffer))>0){
//                    out = socket.getOutputStream();
//                    out.write(buffer);
//                }
//                BufferedInputStream bufferedInput = new BufferedInputStream(in);
//                int n = 0;
//                while ((n = bufferedInput.read()) != -1) {//阻塞
//                    //System.out.print((char) n);
//                    out = socket.getOutputStream();
//                    out.write((char) n);
//                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(serverSocket!=null){
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
