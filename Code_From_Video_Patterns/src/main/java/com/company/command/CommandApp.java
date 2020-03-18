package com.company.command;

public class CommandApp {
    public static void main(String[] args) {
        Comp comp = new Comp();
        User u = new User(new StartCommand(comp),
                new StopCommand(comp),
                new ResetCommand(comp));

        u.startComputer();
        u.stopComputer();
        u.resetComputer();
    }
}

interface Command {
    void execute();
}

class Comp {
    void start() {
        System.out.println("Start");
    }

    void stop() {
        System.out.println("Stop");
    }

    void reset() {
        System.out.println("Reset");
    }
}

class StartCommand implements Command {

    private Comp computer;

    public StartCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.start();
    }
}

class StopCommand implements Command {

    private Comp computer;

    public StopCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.stop();
    }
}

class ResetCommand implements Command {

    private Comp computer;

    public ResetCommand(Comp computer) {
        this.computer = computer;
    }

    @Override
    public void execute() {
        computer.reset();
    }
}

class User {
    Command start;
    Command stop;
    Command reset;

    public User(Command start, Command stop, Command reset) {
        this.start = start;
        this.stop = stop;
        this.reset = reset;
    }

    void startComputer() {
        start.execute();
    }

    void stopComputer() {
        stop.execute();
    }

    void resetComputer() {
        reset.execute();
    }
}
