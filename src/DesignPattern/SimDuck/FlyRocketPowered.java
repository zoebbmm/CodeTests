package DesignPattern.SimDuck;

/**
 * Created by weizhou on 9/7/16.
 */
public class FlyRocketPowered implements FlyBehavior{
    @Override
    public void fly() {
        System.out.println("I'm flying with a rocket!");
    }
}
