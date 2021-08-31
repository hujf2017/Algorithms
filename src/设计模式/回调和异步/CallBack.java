package 设计模式.回调和异步;

/**
 * @author Hujf
 * @title: CallBack
 * @date 2021-08-24 9:01
 * @description: TODO
 */
public class CallBack {
    public static void main(String[] args) {
        B b = new B();
        A a = new A(b);
        a.test();

    }
}
interface CallBackInterface{
    void doSomething();
}

class A implements CallBackInterface{

    private B b;

    A(B b) {
        this.b = b;
    }

    public void test() {
        b.testB(this);
    }
        @Override
    public void doSomething() {

    }
}

class B{
    public void testB(CallBackInterface callBack) {
        System.out.println("========================");
        callBack.doSomething();
    }
}
