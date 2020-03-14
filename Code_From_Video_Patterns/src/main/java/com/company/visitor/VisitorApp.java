package com.company.visitor;

public class VisitorApp {
    public static void main(String[] args) {
        Element body = new BodyElement();
        Element engine = new EngineElement();

        Visitor hooligan = new HooliganVisitor();
        body.accept(hooligan);
        engine.accept(hooligan);

        Visitor mechanic = new MechanicVisitor();
        body.accept(mechanic);
        engine.accept(mechanic);

        Element car = new CarElement();
        car.accept(hooligan);
        System.out.println();
        car.accept(mechanic);
    }
}

interface Visitor {
    void visit(EngineElement engine);

    void visit(BodyElement body);

    void visit(CarElement car);

    void visit(WheelElement wheel);
}

interface Element {
    void accept(Visitor visitor);
}

class WheelElement implements Element {
    private String name;

    public WheelElement() {
    }

    public String getName() {
        return name;
    }

    public WheelElement(String name) {
        this.name = name;
    }

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class CarElement implements Element {
    private Element[] elements;

    public CarElement() {
        this.elements = new Element[]{
                new WheelElement("Left front wheel"),
                new WheelElement("Right front wheel"),
                new WheelElement("Right back wheel"),
                new WheelElement("Left back wheel"),
        };
    }

    @Override
    public void accept(Visitor visitor) {
        for (Element element : elements) {
            element.accept(visitor);
        }
        visitor.visit(this);
    }
}

class BodyElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class EngineElement implements Element {

    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

class HooliganVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Run engine");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("heat the body");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Smoke in car");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Heat " + wheel.getName());
    }
}

class MechanicVisitor implements Visitor {

    @Override
    public void visit(EngineElement engine) {
        System.out.println("Check engine");
    }

    @Override
    public void visit(BodyElement body) {
        System.out.println("Make body prettier");
    }

    @Override
    public void visit(CarElement car) {
        System.out.println("Check appearance");
    }

    @Override
    public void visit(WheelElement wheel) {
        System.out.println("Pump " + wheel.getName());
    }
}
