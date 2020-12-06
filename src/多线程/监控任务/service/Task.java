package 多线程.监控任务.service;

/**
 * @author Hujf
 * @title: Task
 * @date 2020/12/4 0004下午 9:18
 * @description: TODO
 */
public interface Task<T> {
    T call();
}
