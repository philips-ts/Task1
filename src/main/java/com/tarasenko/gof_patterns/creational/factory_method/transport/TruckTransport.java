package com.tarasenko.gof_patterns.creational.factory_method.transport;

public class TruckTransport implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering via trucks");
    }
}
