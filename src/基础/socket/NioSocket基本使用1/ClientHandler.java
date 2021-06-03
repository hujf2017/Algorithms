package 基础.socket.NioSocket基本使用1;

import 基础.NIO.聊天室.UserInputHandler;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;

/**
 * @author Hujf
 * @title: ClientHandler
 * @date 2021-06-03 10:33
 * @description: TODO
 */
public class ClientHandler {

    public static void deatwith(SelectionKey key) throws IOException {
        //当触发connect事件，也就是服务器和客户端建立连接
        if (key.isConnectable()) {
            SocketChannel client = (SocketChannel) key.channel();
            //finishConnect()返回true，说明和服务器已经建立连接。如果是false，说明还在连接中，还没完全连接完成
            if(client.finishConnect()){
                //新建一个新线程去等待用户输入

                ByteBuffer buffer = ByteBuffer.allocate(1024);
                buffer.put("你好啊".getBytes(StandardCharsets.UTF_8));
                client.write(buffer);
            }

            client.close();
            //连接建立完成后，注册read事件，开始监听服务器转发的消息
        }
    }
}
