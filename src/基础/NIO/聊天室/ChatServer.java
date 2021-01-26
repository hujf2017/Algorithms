package 基础.NIO.聊天室;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.*;

/**
 * @author Hujf
 * @title: ChatServer
 * @date 2021/1/24 0024下午 9:26
 * @description: TODO
 */
public class ChatServer {
    int port;
    public ChatServer(int port) {
        this.port = port;
    }

    private static final int BUFFER=1024;
    private ByteBuffer read_buffer = ByteBuffer.allocate(BUFFER);
    private ByteBuffer write_buffer = ByteBuffer.allocate(BUFFER);

    //    private Map<Integer, Writer> map=new ConcurrentHashMap<>();
//
//    private ExecutorService executorService= new ThreadPoolExecutor(4,10,10L, TimeUnit.SECONDS,new ArrayBlockingQueue(10));
    public static void main(String[] args) {
        //
        new ChatServer(8877).start();
    }

    private void start() {
        while(true) {
            try {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                Selector selector = Selector.open();

                //通道绑定端口
                serverSocketChannel.socket().bind(new InetSocketAddress(port));
                //设置非阻塞
                serverSocketChannel.configureBlocking(false);
                //监听接收事件
                serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
                System.out.println("启动服务器，监听端口:" + port);


                //进入死循环  一直监听
                while (true) {
                    //有事件发生
                    try {
                        if (selector.select() > 0) {
                            //得到事件
                            Set<SelectionKey> skey = selector.selectedKeys();

                            for (SelectionKey key : skey) {
                                //实际处理类
                                handles(key, selector);
                            }
                            //处理完后清空selectedKeys，避免重复处理
                            skey.clear();
                        }
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void handles(SelectionKey key,Selector selector) throws IOException {
        if(key.isAcceptable()){
            //打开一个通道
            ServerSocketChannel socketChannel = (ServerSocketChannel) key.channel();
            SocketChannel client= socketChannel.accept();
            client.configureBlocking(false);

            client.register(selector,SelectionKey.OP_READ);

            //给出提示  连接到一个客户端
            System.out.println("客户端[" + client.socket().getPort() + "]上线啦！");
        }

        //出发读事件
        if(key.isReadable()){
            SocketChannel client = (SocketChannel) key.channel();
            //获取消息
            String msg = receive(client);
            System.out.println("收到来自客户端[" + client.socket().getPort() + "]的消息:" + msg);
            //把消息转发给其他客户端
            sendMessage(client, msg, selector);
            //判断用户是否退出
            if (msg.equals("quit")) {
                //解除该事件的监听
                key.cancel();
                //更新Selector
                selector.wakeup();
                System.out.println("客户端[" + client.socket().getPort() + "]下线了！");
            }
        }
    }

    private void sendMessage(SocketChannel client, String msg, Selector selector) throws IOException {
        msg = "客户端[" + client.socket().getPort() + "]:" + msg;
        //获取所有客户端,keys()与前面的selectedKeys不同，这个是获取所有已经注册的信息，而selectedKeys获取的是触发了的事件的信息
        for (SelectionKey key : selector.keys()) {
            //排除服务器和本客户端并且保证key是有效的，isValid()会判断Selector监听是否正常、对应的通道是保持连接的状态等
            if (!(key.channel() instanceof ServerSocketChannel) && !client.equals(key.channel()) && key.isValid()) {
                SocketChannel otherClient = (SocketChannel) key.channel();
                write_buffer.clear();
                write_buffer.put(StandardCharsets.UTF_8.encode(msg));
                write_buffer.flip();
                //把消息写入到缓冲区后，再把缓冲区的内容写到客户端对应的通道中
                while (write_buffer.hasRemaining()) {
                    otherClient.write(write_buffer);
                }
            }
        }
    }

    private String receive(SocketChannel client) throws IOException {
        read_buffer.clear();
        while (client.read(read_buffer)>0){
        }
        read_buffer.flip();
        return String.valueOf(StandardCharsets.UTF_8.decode(read_buffer));
    }


}
