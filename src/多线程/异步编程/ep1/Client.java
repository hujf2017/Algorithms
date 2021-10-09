package 多线程.异步编程.ep1;

/**
 * @author Hujf
 * @title: Client
 * @date 2021-10-08 21:47
 * @description: TODO
 */
public class Client {
    public Data request(String data){
        FutureData futureData = new FutureData();

        new Thread(new Runnable() {
            @Override
            public void run() {
                //异步执行业务逻辑
                RealData realData = new RealData(data);
                futureData.setData(realData);
            }
        }).start();
        return futureData;
    }


    public static void main(String[] args) throws InterruptedException {
        Client client = new Client();
        Data data = client.request("name");
        Thread.sleep(2000);
        System.out.println(data.getResult());
    }
}
