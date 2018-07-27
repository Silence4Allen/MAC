package com.mac.test.mode.factory;

public interface Observerable {
    public void registerObserver(Observer o);
    public void removeObserver(Observer o);
    public void notifyObserver(Thread thread);
}
