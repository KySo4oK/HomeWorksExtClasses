package com.company.abstract_factory;

public class AbstractFactoryApp {
    public static void main(String[] args) {
        DeviceFactory factory = getFactoryByCountryCode("RU");
        Mouse m = factory.getMouse();
        KeyBoard k = factory.getKeyboard();
        TouchPad t = factory.getTouchPad();

        m.click();
        k.print();
        k.println();
        t.track(10, 35);
    }

    public static DeviceFactory getFactoryByCountryCode(String lang) {
        if (lang.equals("RU"))
            return new RuDeviceFactory();
        else if (lang.equals("EN"))
            return new EnDeviceFactory();
        throw new RuntimeException("Not found " + lang);
    }
}

interface Mouse {
    void click();

    void doubleClick();

    void scroll(int direction);
}

interface KeyBoard {
    void print();

    void println();
}

interface TouchPad {
    void track(int deltaX, int deltaY);
}

interface DeviceFactory {
    Mouse getMouse();

    KeyBoard getKeyboard();

    TouchPad getTouchPad();
}

class RuMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Mouse click in ru");
    }

    @Override
    public void doubleClick() {
        System.out.println("Mouse double click in ru");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Scroll up in ru");
        } else if (direction < 0) {
            System.out.println("Scroll down in ru");
        } else System.out.println("Not Scroll in ru");
    }
}

class RuKeyboard implements KeyBoard {

    @Override
    public void print() {
        System.out.println("Print in ru");
    }

    @Override
    public void println() {
        System.out.println("Print line in ru");
    }
}

class RuTouchPad implements TouchPad {

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Moved " + s + "pixels in ru");
    }
}

class EnMouse implements Mouse {

    @Override
    public void click() {
        System.out.println("Mouse click");
    }

    @Override
    public void doubleClick() {
        System.out.println("Mouse double click");
    }

    @Override
    public void scroll(int direction) {
        if (direction > 0) {
            System.out.println("Scroll up");
        } else if (direction < 0) {
            System.out.println("Scroll down");
        } else System.out.println("Not Scroll");
    }
}

class EnKeyboard implements KeyBoard {

    @Override
    public void print() {
        System.out.println("Print");
    }

    @Override
    public void println() {
        System.out.println("Print line");
    }
}

class EnTouchPad implements TouchPad {

    @Override
    public void track(int deltaX, int deltaY) {
        int s = (int) Math.sqrt(Math.pow(deltaX, 2) + Math.pow(deltaY, 2));
        System.out.println("Moved " + s + "pixels");
    }
}

class RuDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new RuMouse();
    }

    @Override
    public KeyBoard getKeyboard() {
        return new RuKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new RuTouchPad();
    }
}

class EnDeviceFactory implements DeviceFactory {

    @Override
    public Mouse getMouse() {
        return new EnMouse();
    }

    @Override
    public KeyBoard getKeyboard() {
        return new EnKeyboard();
    }

    @Override
    public TouchPad getTouchPad() {
        return new EnTouchPad();
    }
}