package DesignPattern.SimDuck;

/**
 * Created by weizhou on 9/6/16.
 */
public class MuteQuack implements QuackBehavior{
    @Override
    public void quack() {
        System.out.println("<< Silence >>");
    }
}
