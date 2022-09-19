package com.tarasenko.gof_patterns.creational.builder;

import lombok.Data;

@Data
public class Car {
    private int numberOfWheels;
    private int numberOfDoors;
    private double engineVolume;
    private boolean isAutomaticGearbox;
    private int power;

    private Car(){}


    public static class Builder{
        private final Car car;

        public Builder() {
            car = new Car();
        }

        public Builder setNumberOfWheels(int numberOfWheels) {
            car.numberOfWheels = numberOfWheels;
            return this;
        }

        public Builder setNumberOfDoors(int numberOfDoors) {
            car.numberOfDoors = numberOfDoors;
            return this;
        }

        public Builder setEngineVolume(double engineVolume) {
            car.engineVolume = engineVolume;
            return this;
        }

        public Builder setIsAutomaticGearbox(boolean isAutomaticGearbox) {
            car.isAutomaticGearbox = isAutomaticGearbox;
            return this;
        }

        public Builder setPower(int power) {
            car.power = power;
            return this;
        }

        public Car build() {
            return car;
        }
    }


    public static void main(String[] args) {
        Car car = new Car.Builder()
                .setPower(200)
                .setNumberOfWheels(4)
                .setEngineVolume(1.5)
                .setNumberOfDoors(4)
                .setIsAutomaticGearbox(true)
                .build();

        System.out.println(car);
    }

}
