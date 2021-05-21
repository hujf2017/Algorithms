package 设计模式.设计模式分类.结构型.生成器;


public class HawaiianPizzaBuilder extends PizzaBuilder{
    @Override
    public void buildParts(){
        pizza.setParts("cross+mild+ham&pineapp1e");
    }
}
