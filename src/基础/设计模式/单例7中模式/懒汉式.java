package 基础.设计模式.单例7中模式;

/**
 * @author Hujf
 * @title: 懒汉式
 * @date 2020/11/29 0029下午 6:58
 * @description: 懒汉式饿汉式的直接区别就是 调用类的时候是否直接调用构造方法初始化
 */
public final class 懒汉式 {
    //实例变量省...

    private static  懒汉式 instance =null;

    private 懒汉式(){
    }

    public static 懒汉式 getInstance(){

        if(instance==null){
            instance = new 懒汉式();
        }
        return instance;
    }

}
