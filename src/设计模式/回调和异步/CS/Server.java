package 设计模式.回调和异步.CS;

/**
 * @author Hujf
 * @title: Server
 * @date 2021-08-24 9:22
 * @description: 服务端
 */
public class Server {

    public void getClientMsg(CSCallBack csCallBack,String msg){
        System.out.println("服务端：服务端接收到客户端的消息："+msg);
        //休眠  异步发送
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("服务端处理成功 返回");
        csCallBack.process(200+"");
    }
}
