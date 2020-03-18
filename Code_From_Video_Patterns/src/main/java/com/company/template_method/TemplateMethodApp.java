package com.company.template_method;

public class TemplateMethodApp {
    public static void main(String[] args) {
        C a = new A();
        a.templateMethod();

        System.out.println();

        C b = new B();
        b.templateMethod();
    }
}

abstract class C {
    void templateMethod() {
        System.out.print("1");
        differ();
        System.out.print("3");
        differ2();
    }

    protected abstract void differ2();

    protected abstract void differ();
}

class A extends C {

    @Override
    protected void differ() {
        System.out.print("2");
    }

    @Override
    protected void differ2() {
        System.out.print("5");
    }
}

class B extends C {

    @Override
    protected void differ() {
        System.out.print("4");
    }

    @Override
    protected void differ2() {
    }
}
