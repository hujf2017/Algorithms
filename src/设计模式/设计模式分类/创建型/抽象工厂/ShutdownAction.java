package 设计模式.设计模式分类.创建型.抽象工厂;

/**
 * @author Hujf
 * @title: ShutdownAction
 * @date 2021/3/1914:50
 * @description: TODO
 */
public class ShutdownAction implements Action{
    @Override
    public void toDoAction() {
        System.out.println("关机啦--------------");
    }
}
