package com.company;

public class DelegateApp {
    public static void main(String[] args) {
//        A a = new A();
//        a.f();
        Painter painter = new Painter();
        painter.setGraphics(new Square());
        painter.draw();

        painter.setGraphics(new Triangle());
        painter.draw();

        painter.setGraphics(new Circle());
        painter.draw();

    }
}

//class A {
//    void f() {
//        System.out.println("f()");
//    }
//}
//
//class B {
//    A a = new A();
//
//    void f() {
//        a.f();
//    }
//}

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

class Painter {
    private Graphics graphics;

    void setGraphics(Graphics graphics) {
        this.graphics = graphics;
    }

    void draw() {
        graphics.draw();
    }
}