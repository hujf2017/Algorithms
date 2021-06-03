package 基础.socket.NioSocket基本使用1;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Set;

/**
 * @author Hujf
 * @title: Client
 * @date 2021-06-03 9:50
 * @description: NIO的socket编程和socket有不同
 */
public class Client {

    public static void main(String[] args) throws IOException {
        SocketChannel channel = SocketChannel.open();
        Selector selector = Selector.open();

        channel.configureBlocking(false);
        channel.register(selector, SelectionKey.OP_CONNECT);
        channel.connect(new InetSocketAddress("127.0.0.1",8081));

//        while (true) {
//            selector.select();
//            Set<SelectionKey> selectionKeys = selector.selectedKeys();
//            for (SelectionKey key : selectionKeys) {
//                ClientHandler.deatwith(key,selector);
//            }
//            selectionKeys.clear();
   //     }
        ByteBuffer buffer =  ByteBuffer.allocate(1024);
        buffer.put("aaa".getBytes(StandardCharsets.UTF_8));
        channel.write(buffer);
        channel.close();
    }
}
