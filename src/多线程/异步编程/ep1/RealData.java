package 多线程.异步编程.ep1;

/**
 * @author Hujf
 * @title: RealData
 * @date 2021-10-08 21:51
 * @description: TODO
 */
public class RealData implements Data{

    private String data ;
    public RealData(String hello_world) {
        this.data = hello_world;
    }

    @Override
    public String getResult() {
        return data;
    }
}
