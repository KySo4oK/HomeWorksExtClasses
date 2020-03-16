package com.company.state;

public class StateApp {
    public static void main(String[] args) {
//        Station dfm = new RadioDFM();
//        Radio radio = new Radio();
//        radio.setStation(dfm);
//
//        for (int i = 0; i < 10; i++) {
//            radio.play();
//            radio.nextStation();
//        }
        Human human = new Human();
        human.setState(new Work());
        for (int i = 0; i < 10; i++) {
            human.doSomething();
        }

    }
}

class Human {
    private Activity state;

    public void setState(Activity state) {
        this.state = state;
    }

    public void doSomething() {
        state.doSomething(this);
    }
}

interface Activity {
    void doSomething(Human context);
}

class Work implements Activity {
    public void doSomething(Human context) {
        System.out.println("Work!!!");
        context.setState(new WeekEnd());
    }
}

class WeekEnd implements Activity {
    private int count = 0;

    public void doSomething(Human context) {
        if (count < 3) {
            System.out.println("Chill (Zzz)");
            count++;
        } else {
            context.setState(new Work());
        }
    }
}

interface Station {
    void play();
}

class Radio7 implements Station {
    public void play() {
        System.out.println("Radio 7...");
    }
}

class RadioDFM implements Station {
    public void play() {
        System.out.println("Radio DFM...");
    }
}

class VestiFM implements Station {
    public void play() {
        System.out.println("Radio vestiFM...");
    }
}

class Radio {
    private Station station;

    public void setStation(Station station) {
        this.station = station;
    }

    void nextStation() {
        if (station instanceof Radio7) {
            setStation(new RadioDFM());
        } else if (station instanceof RadioDFM) {
            setStation(new VestiFM());
        } else if (station instanceof VestiFM) {
            setStation(new Radio7());
        }
    }

    void play() {
        station.play();
    }
}
