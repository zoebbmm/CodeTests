package DesignPattern.PizzaStore;

/**
 * Created by weizhou on 9/11/16.
 */
public class ChicagoPizzaStore extends PizzaStore{
    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory chicargoPizzaIngredientFactory = new ChicagoPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(chicargoPizzaIngredientFactory);
        }

        return pizza;
    }
}
