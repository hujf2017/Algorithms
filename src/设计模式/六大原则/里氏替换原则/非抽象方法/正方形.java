package 设计模式.六大原则.里氏替换原则.非抽象方法;

/**
 * @author Hujf
 * @title: 正方形
 * @date 2021/3/1517:10
 * @description: TODO
 */
public class 正方形 extends 长方形{

    @Override
    public void setWigth(int wigth) {
        super.setWigth(wigth);
        super.setHeight(wigth);
    }

    @Override
    public void setHeight(int height) {
        super.setWigth(height);
        super.setHeight(height);
    }
}
