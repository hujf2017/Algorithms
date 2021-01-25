package 基础.NIO.聊天室;

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
 * @title: ChatClient
 * @date 2021/1/25 0025下午 2:29
 * @description: TODO
 */
public class ChatClient {

    private static final int BUFFER = 1024;
    private ByteBuffer read_buffer = ByteBuffer.allocate(BUFFER);
    private ByteBuffer write_buffer = ByteBuffer.allocate(BUFFER);
    //声明成全局变量是为了方便下面一些工具方法的调用，就不用try with resource了
    private SocketChannel client;
    private Selector selector;


    private void start(){
        try{
            client = SocketChannel.open();
            selector = Selector.open();
            client.configureBlocking(false);
            //监听连接事件
            client.register(selector, SelectionKey.OP_CONNECT);
            //请求服务器建立连接
            client.connect(new InetSocketAddress("127.0.0.1", 8877));
            //和服务器一样，不停的获取触发事件，并做相应的处理
            while (true) {
                selector.select();
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey key : selectionKeys) {
                    handle(key);
                }
                selectionKeys.clear();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    private void handle(SelectionKey key) throws IOException {
        //当触发connect事件，也就是服务器和客户端建立连接
        if (key.isConnectable()) {
            SocketChannel client = (SocketChannel) key.channel();
            //finishConnect()返回true，说明和服务器已经建立连接。如果是false，说明还在连接中，还没完全连接完成
            if(client.finishConnect()){
                //新建一个新线程去等待用户输入
                new Thread(new UserInputHandler(this)).start();
            }
            //连接建立完成后，注册read事件，开始监听服务器转发的消息
            client.register(selector,SelectionKey.OP_READ);
        }
        //当触发read事件，也就是获取到服务器的转发消息
        if(key.isReadable()){
            SocketChannel client = (SocketChannel) key.channel();
            //获取消息
            String msg = receive(client);
            System.out.println(msg);
            //判断用户是否退出
            if (msg.equals("quit")) {
                //解除该事件的监听
                key.cancel();
                //更新Selector
                selector.wakeup();
            }
        }
    }
    //获取消息
    private String receive(SocketChannel client) throws IOException{
        read_buffer.clear();
        while (client.read(read_buffer)>0);
        read_buffer.flip();
        return String.valueOf(StandardCharsets.UTF_8.decode(read_buffer));
    }

    //发送消息
    public void send(String msg) throws IOException{
        if(!msg.isEmpty()){
            write_buffer.clear();
            write_buffer.put(StandardCharsets.UTF_8.encode(msg));
            write_buffer.flip();
            while (write_buffer.hasRemaining()){
                client.write(write_buffer);
            }
            if(msg.equals("quit")){
                selector.close();
            }
        }
    }

    public static void main(String[] args) {
        new ChatClient().start();
    }
}
