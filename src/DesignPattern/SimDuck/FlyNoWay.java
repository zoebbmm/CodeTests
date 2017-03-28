package DesignPattern.SimDuck;

/**
 * Created by weizhou on 9/6/16.
 */
public class FlyNoWay implements FlyBehavior{

    @Override
    public void fly() {
        System.out.println("can't fly, do nothing!");
    }
}
