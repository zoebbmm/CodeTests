package DesignPattern.PizzaStore;

/**
 * Created by weizhou on 9/13/16.
 */
public interface PizzaIngredientFactory {
    public Dough createDough();
    public Sauce createSauce();
    public Cheese createCheese();
    public Veggie[] createVeggies();
    public Pepperoni createPepperoni();
    public Clams createClams();
}
