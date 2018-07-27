package com.mac.test.mode.observer;

import java.util.Enumeration;
import java.util.Vector;

public class Subject implements Observerable {
    private Vector<Observer> vector = new Vector<Observer>();

    @Override
    public void registerObserver(Observer o) {
        vector.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        vector.remove(o);
    }

    @Override
    public void notifyObserver() {
        Enumeration<Observer> enumeration = vector.elements();
        while (enumeration.hasMoreElements()) {
            enumeration.nextElement().update();
        }
    }
}
