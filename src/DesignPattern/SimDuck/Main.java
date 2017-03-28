package DesignPattern.SimDuck;

/**
 * Created by weizhou on 9/6/16.
 */
public class Main {
    public static void main(String[] agrs) {
        Duck mallarDuck = new MallarDuck();

        mallarDuck.performFly();
        mallarDuck.performQuack();

        Duck modelDuck = new ModelDuck();
        modelDuck.performFly();
        modelDuck.setFlyBehavior(new FlyRocketPowered());
        modelDuck.performFly();
    }
}
