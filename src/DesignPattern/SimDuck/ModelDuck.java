package DesignPattern.SimDuck;

/**
 * Created by weizhou on 9/6/16.
 */
public class ModelDuck extends Duck {
    public ModelDuck() {
        flyBehavior = new FlyNoWay();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Display ModelDuck");
    }
}
