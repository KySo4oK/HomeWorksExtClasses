package com.company.decorator;

public class Decorator {
    public static void main(String[] args) {
//        PrinterInterface printer = new Printer("Привет");
//        printer.print();
        PrinterInterface printerInterface = new QuotesDecorator(
                new LeftBracketDecorator(
                        new RightBracketDecorator(
                                new Printer("Hello"))));
        printerInterface.print();

    }
}

interface PrinterInterface {
    void print();
}

abstract class MyDecorator implements PrinterInterface {
    PrinterInterface component;

    public MyDecorator(PrinterInterface component) {
        this.component = component;
    }

    @Override
    public void print() {
        component.print();
    }
}

class Printer implements PrinterInterface {
    String value;

    public Printer(String value) {
        this.value = value;
    }

    @Override
    public void print() {
        System.out.print(value);
    }
}

class QuotesDecorator extends MyDecorator {
    public QuotesDecorator(PrinterInterface component) {
        super(component);
    }

    public void print() {
        System.out.print("\"");
        super.print();
        System.out.print("\"");
    }
}

class LeftBracketDecorator extends MyDecorator {

    public LeftBracketDecorator(PrinterInterface component) {
        super(component);
    }

    public void print() {
        System.out.print("[");
        super.print();
    }
}

class RightBracketDecorator extends MyDecorator {
    public RightBracketDecorator(PrinterInterface component) {
        super(component);
    }

    public void print() {
        super.print();
        System.out.print("]");
    }
}
