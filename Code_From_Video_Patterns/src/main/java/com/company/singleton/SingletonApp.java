package com.company.singleton;

public class SingletonApp {
    public static void main(String[] args) throws InterruptedException {
        final int SIZE = 1000;
        Thread[] t = new Thread[SIZE];

        for (int i = 0; i < SIZE; i++) {
            t[i] = new Thread(new R());
            t[i].start();
        }

        for (int i = 0; i < SIZE; i++) {
            t[i].join();
        }

        System.out.println(Singleton.getCounter());
    }
}

class R implements Runnable {

    @Override
    public void run() {
        Singleton.getInstance();
    }
}

class Singleton {
    private static int counter = 0;
    private static volatile Singleton instance = null;
    private static final Object sync = new Object();

    public static int getCounter() {
        return counter;
    }

    private Singleton() {
        counter++;
    }

//    public static Singleton getInstance() {
//        return instance;
//    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (sync) {
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
//    public static synchronized Singleton  getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
//    public static Singleton getInstance() {
//        if (instance == null) {
//            instance = new Singleton();
//        }
//        return instance;
//    }
}
