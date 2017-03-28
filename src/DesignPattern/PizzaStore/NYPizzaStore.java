package DesignPattern.PizzaStore;

/**
 * Created by weizhou on 9/11/16.
 */
public class NYPizzaStore extends PizzaStore{

    @Override
    protected Pizza createPizza(String item) {
        Pizza pizza = null;
        PizzaIngredientFactory nyPizzaIngredientFactory = new NYPizzaIngredientFactory();

        if (item.equals("cheese")) {
            pizza = new CheesePizza(nyPizzaIngredientFactory);
        } else if (item.equals("clam")) {
            pizza = new ClamPizza(nyPizzaIngredientFactory);
        }

        return pizza;
    }
}
