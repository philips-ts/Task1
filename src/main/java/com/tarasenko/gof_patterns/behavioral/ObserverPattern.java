package com.tarasenko.gof_patterns.behavioral;


import java.util.ArrayList;
import java.util.List;

interface Observable {
    void registerObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update (String msg);
}


class Store implements Observable {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update("New products have arrived.");
        }
    }
}

class Client implements Observer {
    private final String name;

    public Client(String name) {
        this.name = name;
    }

    @Override
    public void update(String msg) {
        System.out.println(name + " received a message: " + msg);
    }
}


public class ObserverPattern {
    public static void main(String[] args) {
        Store store = new Store();
        store.registerObserver(new Client("1"));
        store.registerObserver(new Client("2"));
        store.registerObserver(new Client("3"));
        store.registerObserver(new Client("4"));
        store.notifyObservers();
    }
}
