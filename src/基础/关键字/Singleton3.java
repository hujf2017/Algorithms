package 基础.关键字;

/**
 * @author Hujf
 * @title: Singleton3
 * @date 2020/11/18 0018下午 5:16
 * @description: TODO
 */
public class Singleton3 {
    private int num = 10;
    private static Singleton3 s = new Singleton3();
    private Singleton3(){

    }

    public static Singleton3 get(){
        return s;
    }

}
