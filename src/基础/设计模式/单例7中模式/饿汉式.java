package 基础.设计模式.单例7中模式;

/**
 * @author Hujf
 * @title: 饿汉式
 * @date 2020/11/29 0029下午 6:55
 * @description: TODO
 */
public final class 饿汉式 {

    private byte[] data = new byte[1024];

    //定义实例对象时直接初始化
    private static  饿汉式 instance = new  饿汉式();

    private 饿汉式(){
    }

    public static 饿汉式 getInstance(){
        return instance;
    }
}
