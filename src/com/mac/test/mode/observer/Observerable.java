package com.mac.test.mode.observer;

public interface Observerable {
    public void registerObserver(Observer o);

    public void removeObserver(Observer o);

    public void notifyObserver();
}
