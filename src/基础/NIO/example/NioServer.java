package 基础.NIO.example;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author Hujf
 * @title: NioServer
 * @date 2021/1/18 0018下午 3:24
 * @description: TODO
 */
public class NioServer {

    private final Selector selector;
    private final ServerSocketChannel serverSocketChannel;
    private ExecutorService service = new ThreadPoolExecutor(4,50,10L, TimeUnit.SECONDS,new ArrayBlockingQueue(10));


    public static void main(String[] args) throws IOException {
        new NioServer(8083).start();
    }

    public NioServer(int port) throws IOException {
        //打开一个选择器
        selector = Selector.open();
        //建立一个通道
        serverSocketChannel = ServerSocketChannel.open();
        //通道绑定端口
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        //设置非阻塞
        serverSocketChannel.configureBlocking(false);
        //注册SelectionKey sk =
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        //绑定接收事件处理器、object
       // sk.attach(new Acceptor(serverSocketChannel,selector));
        System.out.print("NIOserver start------");
    }
    //接受客户端
    public void accept(SelectionKey key) {
        try {
            ServerSocketChannel ssc = (ServerSocketChannel) key.channel();
            SocketChannel sc = ssc.accept();
            sc.configureBlocking(false);
            sc.register(selector, SelectionKey.OP_READ);
            System.out.println("accept a client : " + sc.socket().getInetAddress().getHostName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void start(){
        while (true){
            try {
                int events = selector.select();
                if(events>0){
                    Set selected = selector.selectedKeys();
                    Iterator<SelectionKey> it = selected.iterator();
                    while (it.hasNext()){
                        SelectionKey key = it.next();
                       if(key.isAcceptable()){
                           //
                           accept(key);
                       }else{
                            service.submit(new NioServerHandler(key));
                       }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static class NioServerHandler implements Runnable{
        private SelectionKey selectionKey;

        public NioServerHandler(SelectionKey selectionKey) {
            this.selectionKey = selectionKey;
        }


        @Override
        public void run() {
            try {
                if (selectionKey.isReadable()) {
                    SocketChannel socketChannel = (SocketChannel) selectionKey.channel();
                    ByteBuffer buffer = ByteBuffer.allocate(1024);
                    socketChannel.read(buffer);
                    buffer.flip();
                    System.out.println("收到客户端"+socketChannel.socket().getInetAddress().getHostName()+"的数据："+new String(buffer.array()));
                    //将数据添加到key中
                    ByteBuffer outBuffer = ByteBuffer.wrap(buffer.array());
                    socketChannel.write(outBuffer);// 将消息回送给客户端
                    selectionKey.cancel();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }

}
