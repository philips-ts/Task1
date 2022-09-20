package com.tarasenko.gof_patterns.creational.factory_method;

import com.tarasenko.gof_patterns.creational.factory_method.transport.Transport;
import com.tarasenko.gof_patterns.creational.factory_method.transport.TransportType;

public class Test {
    public static void main(String[] args) {
        Transport transport = Transport.of(TransportType.TRUCK);
        transport.deliver();

        Transport transport2 = Transport.of(TransportType.AIRPLANE);
        transport2.deliver();

        Transport transport3 = Transport.of(TransportType.TRUCK);
        transport3.deliver();
    }
}
