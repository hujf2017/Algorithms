package 基础.socket.基本使用2;


import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author Hujf
 * @title: Server
 * @date 2021-06-02 16:15
 * @description: TODO
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(8080);

        Socket socket = server.accept();
        InputStream inputStream = socket.getInputStream();
        BufferedInputStream buffer = new BufferedInputStream(inputStream);
        byte[] bytes = new byte[1024];
        while( buffer.read(bytes) >0){
            String s = new String(bytes);
            System.out.println(s);
        }
        buffer.close();
        socket.close();
    }
}
