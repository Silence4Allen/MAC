package com.mac.main;

import com.mac.test.mode.observer.Observer1;
import com.mac.test.mode.observer.Observer2;
import com.mac.test.mode.observer.Subject;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Subject subject = new Subject();
        Observer1 o1 = new Observer1();
        Observer2 o2 = new Observer2();
        subject.registerObserver(o1);
        subject.registerObserver(o2);

        Thread.sleep(5000);

        subject.notifyObserver();
    }
}
