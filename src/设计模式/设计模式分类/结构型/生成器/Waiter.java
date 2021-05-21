package 设计模式.设计模式分类.结构型.生成器;

public class Waiter {
    private PizzaBuilder pizzaBuilder;

    public void setPizzaBuilder(PizzaBuilder pizzaBuilder) {
        this.pizzaBuilder = pizzaBuilder;
    }
    public Pizza getPizza(){
        return pizzaBuilder.getPizza();
    }
    public void construct(){
        pizzaBuilder.createNewPizza();
        pizzaBuilder.buildParts();
    }
}
