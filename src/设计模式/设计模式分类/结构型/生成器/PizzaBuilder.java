package 设计模式.设计模式分类.结构型.生成器;

public abstract class PizzaBuilder {
    protected Pizza pizza;

    public void createNewPizza(){
        pizza =new Pizza();
    }
    public abstract void buildParts();

    public Pizza getPizza() {
        return pizza;
    }
}
