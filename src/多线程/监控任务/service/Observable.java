package 多线程.监控任务.service;

/**
 * @author Hujf
 * @title: Observable
 * @date 2020/12/4 0004下午 9:10
 * @description: TODO
 */
public interface Observable {

    enum Cycle{
        STARTED,RUNNUNG,DONE,ERROR
    }

    //获取当前任务的生命周期状态
    Cycle getCycle();

    //定义启动线程的方法
    void start();

    //定义线程的打断方法
    void interrupt();
}
