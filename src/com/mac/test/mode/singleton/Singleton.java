package com.mac.test.mode.singleton;

public class Singleton {
    private static Singleton instance = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (instance) {
                instance = new Singleton();
            }
        }
        return instance;
    }


}
