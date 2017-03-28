package DesignPattern.WeatherMonitoringApp;

/**
 * Created by weizhou on 9/7/16.
 */
public class Main {
    public static void main(String[] agrs) {
        WeatherData weatherData = new WeatherData();

        CurrentConditionDisplay currentConditionDisplay = new CurrentConditionDisplay(weatherData);

//        StatisticsDisplay statisticsDisplay = new StatisticsDisplay(weatherData);
//
//        ForcastDisplay forcastDisplay = new ForcastDisplay(weatherData);

        weatherData.setMeasurements(80, 65, 30.4f);

    }
}
