package DesignPattern.StarBuzz;

/**
 * Created by weizhou on 9/10/16.
 */
public class DarkRoast extends Beverage{
    public DarkRoast() {
        description = "DarkRoast";
    }

    @Override
    public double cost() {
        return 0.99;
    }
}
