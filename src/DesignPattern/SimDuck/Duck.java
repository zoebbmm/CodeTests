package DesignPattern.SimDuck;

/**
 * Created by weizhou on 9/6/16.
 */
public abstract class Duck {
    public FlyBehavior flyBehavior;

    QuackBehavior quackBehavior;

    public Duck() {

    }

    public void setFlyBehavior(FlyBehavior fb) {
        flyBehavior = fb;
    }

    public void setQuackBehavior(QuackBehavior qb) {
        quackBehavior = qb;
    }

    public abstract void display();

    public void swim() {
        System.out.println("All duck swim...");
    }

    public void performQuack() {
        quackBehavior.quack();
    }

    public void performFly() {
        flyBehavior.fly();
    }
}
