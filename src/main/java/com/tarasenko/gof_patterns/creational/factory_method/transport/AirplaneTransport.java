package com.tarasenko.gof_patterns.creational.factory_method.transport;

public class AirplaneTransport implements Transport {
    @Override
    public void deliver() {
        System.out.println("Delivering via airplanes");
    }
}
