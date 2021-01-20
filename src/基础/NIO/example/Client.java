package 基础.NIO.example;

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.util.concurrent.TimeUnit;

/**
 * @author Hujf
 * @title: Client
 * @date 2021/1/20 0020下午 3:08
 * @description: TODO
 */
public class Client {
    @Test
    public  void client(){
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        SocketChannel socketChannel=null;

        try {
            socketChannel=SocketChannel.open();
            socketChannel.configureBlocking(false);
            socketChannel.connect(new InetSocketAddress("localhost", 8083));

            if(socketChannel.finishConnect()){
                int i=0;
                while (true){
                    TimeUnit.SECONDS.sleep(1);
                    String info = "I'm "+i+++"-th information from client";
                    byteBuffer.clear();
                    byteBuffer.put(info.getBytes());
                    byteBuffer.flip();
                    while(byteBuffer.hasRemaining()){
                        System.out.println(byteBuffer);
                        socketChannel.write(byteBuffer);
                    }
                }
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }finally {
            try{
                if(socketChannel!=null){
                    socketChannel.close();
                }
            }catch(IOException e){
                e.printStackTrace();
            }

        }
    }
}
