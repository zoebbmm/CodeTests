package DesignPattern.PizzaStore;

/**
 * Created by weizhou on 9/13/16.
 */
public class CheesePizza extends Pizza{
    PizzaIngredientFactory ingredientFactory;

    public CheesePizza(PizzaIngredientFactory pizzaIngredientFactory) {
        this.ingredientFactory = pizzaIngredientFactory;
        name = "Cheese Pizza";
    }

    @Override
    public void prepare() {
        System.out.println("Preparing " + name);
        cheese = ingredientFactory.createCheese();
        dough = ingredientFactory.createDough();
        sauce = ingredientFactory.createSauce();
    }
}
