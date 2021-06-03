package 基础.socket.NioSocket基本使用1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Hujf
 * @title: Server
 * @date 2021-06-03 9:51
 * @description: TODO
 */
public class Server {


    public static void main(String[] args) throws IOException {
        ServerSocketChannel channel = ServerSocketChannel.open();
        Selector selector = Selector.open();
        channel.configureBlocking(false);
        //绑定端口
        channel.socket().bind(new InetSocketAddress(8081));

        channel.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("监听本机8081");


        while(true){
            int events = selector.select();
            if(events>0){
                //SelectionKey 就是事件
                Set<SelectionKey> skey = selector.selectedKeys();
                for(SelectionKey key :skey){
                    //处理key
                    ServerHandle.dealEvent(key,selector);
                }
                skey.clear();
            }
        }
    }
}
