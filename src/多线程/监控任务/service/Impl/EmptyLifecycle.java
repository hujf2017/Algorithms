package 多线程.监控任务.service.Impl;

import 多线程.监控任务.service.TaskLifecycle;

/**
 * @author Hujf
 * @title: EmptyLifecycle
 * @date 2020/12/4 0004下午 9:15
 * @description: TODO
 */
public class EmptyLifecycle<T> implements TaskLifecycle<T> {
    @Override
    public void OnStart(Thread thread) {

    }

    @Override
    public void onRunning(Thread thread) {

    }

    @Override
    public void onFinish(Thread thread, T result) {

    }

    @Override
    public void onError(Thread thread, Exception e) {

    }
}
