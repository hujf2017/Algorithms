package 设计模式.设计模式分类.结构型.生成器;

public class FastFoodOrdering {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();
        PizzaBuilder hawaiianPizzaBuilder = new HawaiianPizzaBuilder();

        waiter.setPizzaBuilder(hawaiianPizzaBuilder);
        waiter.construct();

        System.out.println("pizza" + waiter.getPizza());

    }
}





