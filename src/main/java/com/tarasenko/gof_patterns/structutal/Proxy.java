package com.tarasenko.gof_patterns.structutal;


interface Connector {
    void connectTo(String address);
}


class ConnectorImpl implements Connector {
    @Override
    public void connectTo(String address) {
        System.out.println("Connecting to address " + address + " ...");
    }
}


class ConnectorProxy extends ConnectorImpl {
    @Override
    public void connectTo(String address) {
        System.out.println("Logging a connection address...");
        super.connectTo(address);
    }
}


public class Proxy {
    public static void main(String[] args) {
        Connector connector = new ConnectorImpl();
        Connector proxy = new ConnectorProxy();
        proxy.connectTo("google.com");
    }
}
