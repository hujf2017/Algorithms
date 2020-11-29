package 基础.设计模式.单例7中模式;

/**
 * @author Hujf
 * @title: Holder
 * @date 2020/11/29 0029下午 7:22
 * @description: TODO
 */
public final class Holder {
    private Holder(){

    }

    //在静态内部类中持有实例，并直接初始化   懒加载
    private static class hold{
        private static  Holder instance = new Holder();
    }

    public static Holder getInstance(){
        return hold.instance;
    }
}
