package DesignPattern.WeatherMonitoringApp;

/**
 * Created by weizhou on 9/7/16.
 */
public class StatisticsDisplay implements  Observer, DisplayElement{
    private float temperature;
    private float humidity;
    private float pressure;
    private Subject weatherData;

    public StatisticsDisplay(Subject weatherData) {
        this.weatherData = weatherData;
        weatherData.registerObserver(this);
    }

    @Override
    public void display() {
        System.out.println("Statistics Display: " + temperature + "F degree and " + humidity + "% humidity and pressure: " + pressure);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temperature = temp;
        this.humidity = humidity;
        this.pressure = pressure;

        display();
    }
}
