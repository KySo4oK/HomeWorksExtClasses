package com.company.bridge;

public class BridgeApp {
    public static void main(String[] args) {
        Car car = new Sedan(new Kia());
        car.showDetails();
    }
}

abstract class Car {
    Make make;

    public Car(Make make) {
        this.make = make;
    }

    void showDetails() {
        showType();
        make.setMake();
    }

    abstract void showType();
}

class Sedan extends Car {
    public Sedan(Make make) {
        super(make);
    }

    @Override
    void showType() {
        System.out.println("Sedan");
    }
}

class Hatchback extends Car {
    public Hatchback(Make make) {
        super(make);
    }

    @Override
    void showType() {
        System.out.println("Hatchback");
    }
}

class Coupe extends Car {
    public Coupe(Make make) {
        super(make);
    }

    @Override
    void showType() {
        System.out.println("Coupe");
    }
}

interface Make {
    void setMake();
}

class Kia implements Make {

    @Override
    public void setMake() {
        System.out.println("Kia");
    }
}

class Skoda implements Make {

    @Override
    public void setMake() {
        System.out.println("Skoda");
    }
}

class Mercedes implements Make {

    @Override
    public void setMake() {
        System.out.println("Mercedes");
    }
}