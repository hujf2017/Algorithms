package 基础.设计模式.单例7中模式;

/**
 * @author Hujf
 * @title: DoubleCheckl
 * @date 2020/11/29 0029下午 7:16
 * @description: 二次确认型单例   这种也存在一定的问题 就是别的变量可能 没有实例化 设计到冲排序问题
 * 这里有2种
 */
public class DoubleCheckl {

    //private  static DoubleCheckl instance = null;
    private  volatile static  DoubleCheckl instance = null;
    private DoubleCheckl(){

    }

    public static DoubleCheckl getInstance(){
        if(instance ==null){
            synchronized (DoubleCheckl.class){
                if(instance ==null){
                    instance = new DoubleCheckl();
                }
            }
        }
        return instance;
    }
}
