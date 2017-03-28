package DesignPattern.WeatherMonitoringApp;

/**
 * Created by weizhou on 9/7/16.
 */
public interface Subject {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObservers();

}
