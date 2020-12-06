package 多线程.监控任务.service.Impl;

import 多线程.监控任务.service.Observable;
import 多线程.监控任务.service.Task;
import 多线程.监控任务.service.TaskLifecycle;

/**
 * @author Hujf
 * @title: ObservableThread
 * @date 2020/12/4 0004下午 9:21
 * @description: TODO
 */
public class ObservableThread<T> extends Thread implements Observable {
    private final TaskLifecycle<T> lifecycle;

    private final Task<T> task;

    private Cycle cycle;

    public ObservableThread(TaskLifecycle<T> lifecycle, Task<T> task) {
        this.lifecycle = lifecycle;
        this.task = task;
    }

    @Override
    public final void run(){
    }


    private void update(Cycle cycle,T result,Exception e){
        this.cycle = cycle;
        if(lifecycle == null){
            return ;
        }
        try {
            switch (cycle) {
                case STARTED:
                    this.lifecycle.OnStart(currentThread());
                    break;
                case RUNNUNG:
                    this.lifecycle.onRunning(currentThread());
                    break;
                case DONE:
                    this.lifecycle.onFinish(currentThread(), result);
                    break;
                case ERROR:
                    this.lifecycle.onError(currentThread(), e);
                    break;

            }
        }catch (Exception ex){
            if(cycle==Cycle.ERROR){
                throw ex;
            }
        }
    }


    @Override
    public Cycle getCycle() {
        return this.cycle;
    }
}
