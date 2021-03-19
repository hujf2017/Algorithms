package 设计模式.设计模式分类.创建型.工厂方法模式;

/**
 * @author Hujf
 * @title: LinuxButton
 * @date 2021/3/1914:32
 * @description: TODO
 */
public class LinuxButton implements Button{
    @Override
    public void onClick() {
        System.out.println("使用了linux按钮");
    }
}
