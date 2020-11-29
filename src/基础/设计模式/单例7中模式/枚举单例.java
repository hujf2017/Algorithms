package 基础.设计模式.单例7中模式;

/**
 * @author Hujf
 * @title: 枚举单例
 * @date 2020/11/29 0029下午 9:00
 * @description: TODO
 */
public enum 枚举单例 {
    INSTANCE ;

    枚举单例(){
        System.out.println("初始化");
    }

    public static void method(){

    }

    public static 枚举单例 getInstance(){
        return INSTANCE;
    }
}
