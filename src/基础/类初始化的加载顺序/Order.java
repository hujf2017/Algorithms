package 基础.类初始化的加载顺序;

/**
 * @author Hujf
 * @title: Order
 * @date 2020/11/29 0029下午 7:39
 * @description: 类的加载顺序   验证->准备->解析
 * 1.准备阶段   给静态变量分配内存和初始值  分配到静态域
 * 2. 构造器
 *
 */
public class Order {

    public static int num1 =10;


    //第一个访问的
    public Order(){

    }
}
