package 设计模式.回调和异步.CS;

/**
 * @author Hujf
 * @title: Client
 * @date 2021-08-24 9:25
 * @description: 客户端
 */
public class Client implements CSCallBack{

    private Server server;

    public Client(Server server){
        this.server = server;
    }

    public void sendMsg(String msg){
        System.out.println("客户端发送的消息为"+msg);
        new Thread(new Runnable() {
            @Override
            public void run() {
                server.getClientMsg(Client.this::process,msg);
            }
        }).start();

        System.out.println("客户端异步消息发送成功");
    }

    @Override
    public void process(String status) {
        System.out.println("回调消息"+status);
    }
}
