package DesignPattern.PizzaStore;

/**
 * Created by weizhou on 9/13/16.
 */
public class ClamPizza extends Pizza{
    PizzaIngredientFactory ingredientFactory;

    public ClamPizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.ingredientFactory = pizzaIngredientFactory;
        name = "Clam Pizza";
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        ingredientFactory.createClams();
        ingredientFactory.createCheese();
        ingredientFactory.createDough();
    }
}
