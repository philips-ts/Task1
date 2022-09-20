package com.tarasenko.gof_patterns.behavioral;

import java.util.List;


interface CarPart {
    void accept(CarPartVisitor visitor);

}

interface CarPartVisitor {
    void visit(Body body);
    void visit(Car car);
    void visit(Engine engine);

}

class Body implements CarPart {
    @Override
    public void accept(CarPartVisitor visitor) {
        visitor.visit(this);
    }

}

class Engine implements CarPart {

    @Override
    public void accept(CarPartVisitor visitor) {
        visitor.visit(this);
    }

}

class Car implements CarPart {
    private final List<CarPart> elements;

    public Car() {
        this.elements = List.of(new Body(), new Engine());
    }

    @Override
    public void accept(CarPartVisitor visitor) {
        for (CarPart element : elements) {
            element.accept(visitor);
        }
        visitor.visit(this);
    }

}

class CarPartPrintVisitor implements CarPartVisitor {

    @Override
    public void visit(Body body) {
        System.out.println("Visiting body.");
    }

    @Override
    public void visit(Car car) {
        System.out.println("Visiting car.");
    }

    @Override
    public void visit(Engine engine) {
        System.out.println("Visiting engine.");
    }

}


public class VisitorPattern {
    public static void main(String[] args) {
        Car car = new Car();
        car.accept(new CarPartPrintVisitor());
    }
}
