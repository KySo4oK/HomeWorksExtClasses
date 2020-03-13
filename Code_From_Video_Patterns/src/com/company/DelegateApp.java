package com.company;

public class DelegateApp {
    public static void main(String[] args) {

    }

}

class A {
    void f() {
        System.out.println("f()");
    }
}

class B {
    A a = new A();

    void f() {
        a.f();
    }
}

interface Graphics {
    void draw();
}

class Triangle implements Graphics {

    public void draw() {
        System.out.println("draw triangle");
    }
}

class Square implements Graphics {
    public void draw() {
        System.out.println("draw square");
    }
}

class Circle implements Graphics {
    public void draw() {
        System.out.println("draw circle");
    }
}