package 基础.设计模式.单例7中模式;

/**
 * @author Hujf
 * @title: 懒汉式优化同步
 * @date 2020/11/29 0029下午 7:05
 * @description: 第一种最简单的懒汉式有一个很明显的问题
 * 当同事有两个线程读取到null= instance时，无法保持单例
 */
public class 懒汉式优化同步 {

    private static 懒汉式优化同步 instance=null;

    private 懒汉式优化同步(){

    }
    //加了一个同步方法 instance 共享资源限制  但是之前说过了 synchronized这个关键字很费资源
    public static synchronized 懒汉式优化同步 getInstance(){
        if(instance==null){
            instance =new 懒汉式优化同步();
        }
        return instance;
    }

}
