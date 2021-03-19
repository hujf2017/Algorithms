package 设计模式.设计模式分类.创建型.抽象工厂;

/**
 * @author Hujf
 * @title: StartAction
 * @date 2021/3/1914:49
 * @description: TODO
 */
public class StartAction implements Action{
    @Override
    public void toDoAction() {
        System.out.println("开机啦+++++++++++");
    }
}
