package DesignPattern.SimDuck;

/**
 * Created by weizhou on 9/6/16.
 */
public class Quack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("quack~~~~~");
    }
}
