package 基础.socket.NioSocket基本使用1;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author Hujf
 * @title: ServerHandle
 * @date 2021-06-03 10:19
 * @description: TODO
 */
public class ServerHandle {


    public static void dealEvent(SelectionKey key, Selector selector){
        if(key.isAcceptable()){
            System.out.println("收到消息了 emmm");
            ServerSocketChannel channel = (ServerSocketChannel) key.channel();
            try {
                //必须接受一下 不然会一直在的  倒置select 一直有值
                SocketChannel client=channel.accept();
                client.configureBlocking(false);
                client.register(selector,SelectionKey.OP_READ);
                //给出提示  连接到一个客户端
                System.out.println("客户端[" + client.socket().getPort() + "]上线啦！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        if(key.isReadable()){
            System.out.println("emmm 来数据啦");
            SocketChannel client = (SocketChannel) key.channel();
            try {
                //给出提示  连接到一个客户端
                String msg = receive(client);
                System.out.println("收到来自客户端[" + client.socket().getPort() + "]的消息:" + msg);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    private static String receive(SocketChannel client) throws IOException {
        ByteBuffer read_buffer =  ByteBuffer.allocate(1024);
        read_buffer.clear();
        while (client.read(read_buffer)>0){
        }
        read_buffer.flip();
        return String.valueOf(StandardCharsets.UTF_8.decode(read_buffer));
    }
}
