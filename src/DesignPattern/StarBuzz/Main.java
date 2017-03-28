package DesignPattern.StarBuzz;

/**
 * Created by weizhou on 9/10/16.
 */
public class Main {
    public static void main(String[] agrs) {
        Beverage espresso = new Espresso();
        System.out.println(espresso.getDescription() + " $" + espresso.cost());

        Beverage darkRoast = new DarkRoast();
        Beverage darkRoastWrappedOneMocha = new Mocha(darkRoast);
        Beverage darkRoastWrappedDoubleMocha = new Mocha(darkRoastWrappedOneMocha);
        Beverage darkRoastWrappedDoubleMochaWhip = new Whip(darkRoastWrappedDoubleMocha);

        System.out.println(darkRoastWrappedDoubleMochaWhip.getDescription() + " $" + darkRoastWrappedDoubleMochaWhip.cost());

        Beverage houseBlend = new HouseBlend();
        Beverage houseBlendWrappedSoy = new Soy(houseBlend);
        Beverage houseBlendWrappedSoyMocha = new Mocha(houseBlendWrappedSoy);
        Beverage houseBlendWrappedSoyMochaWhip = new Whip(houseBlendWrappedSoyMocha);

        System.out.println(houseBlendWrappedSoyMochaWhip.getDescription() + " $" + houseBlendWrappedSoyMochaWhip.cost());
    }
}
