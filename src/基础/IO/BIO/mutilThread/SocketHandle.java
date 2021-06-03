package 基础.IO.BIO.mutilThread;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author Hujf
 * @title: SocketHandle
 * @date 2021/1/18 0018上午 9:44
 * @description: TODO
 */
public class SocketHandle implements Runnable {

    private Socket socket=null;
    public SocketHandle(Socket socket){
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in=null;
        OutputStream out =null;

        try {
            in =socket.getInputStream();
            BufferedInputStream bufferedInput = new BufferedInputStream(in);
            int n = 0;
            while ((n = bufferedInput.read()) != -1) {//阻塞
                System.out.print((char) n);
                //回写
//                out = socket.getOutputStream();
//                out.write((char) n);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try {
                in.close();
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
