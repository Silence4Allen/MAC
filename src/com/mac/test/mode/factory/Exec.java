package com.mac.test.mode.factory;

import java.util.ArrayList;

public class Exec implements Observer {

    private static Producer producer;
    private static Customer customer;
    private static HouseKeeper houseKeeper;

    public void doSth() {
        houseKeeper = new HouseKeeper(new ArrayList());
        producer = new Producer(houseKeeper, 200);
        customer = new Customer(houseKeeper, 1000);

        producer.registerObserver(this);
        customer.registerObserver(this);

        producer.start();
        customer.start();
    }

    @Override
    public void update(Thread thread) {
        if (thread.getClass() == Producer.class) {
            synchronized (customer) {
                customer.notify();
            }
        } else if (thread.getClass() == Customer.class) {
            synchronized (producer) {
                producer.notify();
            }
        }

    }
}
