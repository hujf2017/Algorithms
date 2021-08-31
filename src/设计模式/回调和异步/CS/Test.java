package 设计模式.回调和异步.CS;

/**
 * @author Hujf
 * @title: Test
 * @date 2021-08-24 9:32
 * @description: TODO
 */
public class Test {
    public static void main(String[] args) {
        Server server = new Server();
        Client client = new Client(server);
        client.sendMsg("你好啊");
    }
}
