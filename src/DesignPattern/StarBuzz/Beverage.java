package DesignPattern.StarBuzz;

/**
 * Created by weizhou on 9/10/16.
 */
public abstract class Beverage {
    String description = "Unkown Beverage";

    public String getDescription() {
        return description;
    }

    public abstract double cost();
}
