package com.company.facade;

public class FacadeApp {
    public static void main(String[] args) {
//        Power power = new Power();
//        power.on();
//
//        DVDRom dvd = new DVDRom();
//        dvd.load();
//
//        HDD hdd = new HDD();
//        hdd.copyFromDVD(dvd);

        Computer computer = new Computer();
        computer.copy();
    }
}

class Computer {
    private Power power = new Power();
    private DVDRom dvd = new DVDRom();
    private HDD hdd = new HDD();

    void copy() {
        power.on();
        dvd.load();
        hdd.copyFromDVD(dvd);
    }
}

class Power {
    void on() {
        System.out.println("Power on");
    }

    void off() {
        System.out.println("Power off");
    }
}

class DVDRom {
    private boolean data = false;

    public boolean hasData() {
        return data;
    }

    void load() {
        this.data = true;
    }

    void unload() {
        this.data = false;
    }
}

class HDD {
    void copyFromDVD(DVDRom dvd) {
        if (dvd.hasData()) {
            System.out.println("Copying from drive");
        } else {
            System.out.println("Input drive with data");
        }
    }
}
