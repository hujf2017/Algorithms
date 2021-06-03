package 基础.socket.NioSocket基本使用1;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;

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
    }
}
