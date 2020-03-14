package com.company.observer;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.addObserver(new FileObserver());
        station.setMeasurements(25, 760);
        station.setMeasurements(-5, 745);
    }
}

interface Observed {
    void addObserver(Observer observer);

    void removeObserver(Observer observer);

    void notifyObserver();
}

class MeteoStation implements Observed {
    private int temperature;
    private int pressure;
    private List<Observer> observers = new ArrayList<>();

    public void setMeasurements(int pressure, int temperature) {
        this.pressure = pressure;
        this.temperature = temperature;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObserver() {
        for (Observer observer : observers) {
            observer.HandleEvent(temperature, pressure);
        }
    }
}

interface Observer {
    void HandleEvent(int temperature, int pressure);
}

class ConsoleObserver implements Observer {

    @Override
    public void HandleEvent(int temperature, int pressure) {
        System.out.println("Weather changed: temperature : " + temperature + ", pressure : " + pressure + ".");
    }
}

class FileObserver implements Observer {

    @Override
    public void HandleEvent(int temperature, int pressure) {
        File f;
        try {
            f = File.createTempFile("TempPressure", "_txt");
            PrintWriter pw = new PrintWriter(f);
            pw.print("Weather changed: temperature : " + temperature + ", pressure : " + pressure + ".");
            pw.println();
            pw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
