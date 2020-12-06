package 多线程.监控任务.service;

/**
 * @author Hujf
 * @title: TaskLifecycle
 * @date 2020/12/4 0004下午 9:12
 * @description: TODO
 */
public interface TaskLifecycle<T> {

    void OnStart (Thread thread);

    void onRunning (Thread thread );

    void onFinish(Thread thread , T result );

    void onError (Thread thread,Exception e);
}
