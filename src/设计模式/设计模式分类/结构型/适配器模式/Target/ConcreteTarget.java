package 设计模式.设计模式分类.结构型.适配器模式.Target;

public class ConcreteTarget implements Target {
    @Override
    public void request() {
        System.out.println("concreteTarget目标方法");
    }
}