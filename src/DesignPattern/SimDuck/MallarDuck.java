package DesignPattern.SimDuck;

/**
 * Created by weizhou on 9/6/16.
 */
public class MallarDuck extends Duck{

    public MallarDuck() {
        flyBehavior = new FlyWithWings();
        quackBehavior = new Quack();
    }

    @Override
    public void display() {
        System.out.println("Display MallarDuck");
    }
}
