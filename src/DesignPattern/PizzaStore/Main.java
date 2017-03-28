package DesignPattern.PizzaStore;

/**
 * Created by weizhou on 9/13/16.
 */
public class Main {
    public static void main(String[] agrs) {
        PizzaStore nyPizzaStore = new NYPizzaStore();
        PizzaStore chicagoPizzaStore = new ChicagoPizzaStore();

        Pizza nyPizza = nyPizzaStore.orderPizza("cheese");
        System.out.println(nyPizza.getName());

        Pizza chicargoPizza = chicagoPizzaStore.orderPizza("cheese");
        System.out.println(chicargoPizza.getName());

    }
}
