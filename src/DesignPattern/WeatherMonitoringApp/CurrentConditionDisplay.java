package DesignPattern.WeatherMonitoringApp;

import java.util.*;

/**
 * Created by weizhou on 9/7/16.
 */
public class CurrentConditionDisplay implements java.util.Observer, DisplayElement {
    private float temperature;
    private float humidity;
    private float pressure;
    private Observable observable;

    public CurrentConditionDisplay(Observable observable) {
        this.observable = observable;
        observable.addObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Current conditions: " + temperature + "F degree and " + humidity + "% humidity");
    }

    @Override
    public void update(Observable o, Object arg) {
        if (o instanceof WeatherData) {
            WeatherData weatherData = (WeatherData)o;
            this.temperature = weatherData.getTemperature();
            this.humidity = weatherData.getHumidity();
            display();
        }
    }
}
