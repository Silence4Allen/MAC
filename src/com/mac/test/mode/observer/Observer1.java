package com.mac.test.mode.observer;

public class Observer1 implements Observer {
    @Override
    public void update() {
        System.out.println("this is Observer1's change!");
    }
}
