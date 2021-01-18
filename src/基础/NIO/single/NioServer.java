package 基础.NIO.single;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Hujf
 * @title: NioServer
 * @date 2021/1/18 0018下午 3:24
 * @description: TODO
 */
public class NioServer {

    private final Selector selector;
    private final ServerSocketChannel serverSocketChannel;

    public NioServer(int port) throws IOException {
        //打开一个选择器
        selector = Selector.open();
        //建立一个通道
        serverSocketChannel = ServerSocketChannel.open();
        //通道绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        //设置非阻塞
        serverSocketChannel.configureBlocking(false);
        //注册
        SelectionKey sk =serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        //绑定接收事件处理器、object
        sk.attach(new Acceptor(serverSocketChannel,selector));
    }


    public void run(){
        try {
            while (!Thread.interrupted()){
                selector.select();
                Set selected = selector.selectedKeys();
                Iterator it = selected.iterator();
                while (it.hasNext()){
                    dispatch((SelectionKey)it.next());
                }
                selected.clear();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    private void dispatch(SelectionKey next) {
    }
}
