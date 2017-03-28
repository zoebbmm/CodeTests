package DesignPattern.StarBuzz;

/**
 * Created by weizhou on 9/10/16.
 */
public class HouseBlend extends Beverage{
    public HouseBlend() {
        description = "House Blend Coffee";
    }

    @Override
    public double cost() {
        return 0.89;
    }
}
