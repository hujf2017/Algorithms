package 设计模式.设计模式分类.创建型.建造者模式.Build;

/**
 * @author Hujf
 * @title: Build
 * @date 2021/3/2014:03
 * @description: TODO
 */
public interface HouseBuilder {
    void reset();
    void build地基();
    void build楼房();
    void build院子();
    void build游泳池();
    void build地下车库();
    void build后花园();
}
