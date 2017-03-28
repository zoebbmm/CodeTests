package DesignPattern.WeatherMonitoringApp;

/**
 * Created by weizhou on 9/7/16.
 */
public interface Observer {
    public void update(float temp, float humidity, float pressure);
}
