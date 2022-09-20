package com.tarasenko.gof_patterns.creational.factory_method.transport;

public interface Transport {
    void deliver();

    static Transport of(TransportType transportType) {
        return switch (transportType) {
            case SHIP -> new ShipTransport();
            case TRUCK -> new TruckTransport();
            case AIRPLANE -> new AirplaneTransport();
            default -> throw new UnsupportedOperationException("Unknown type of a transport");
        };
    }
}
