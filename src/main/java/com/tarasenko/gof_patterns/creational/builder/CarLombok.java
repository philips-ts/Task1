package com.tarasenko.gof_patterns.creational.builder;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CarLombok {
    private int numberOfWheels;
    private int numberOfDoors;
    private double engineVolume;
    private boolean isAutomaticGearbox;
    private int power;


    public static void main(String[] args) {
        CarLombok carLombok = CarLombok.builder()
                .power(200)
                .numberOfWheels(4)
                .engineVolume(1.5)
                .numberOfDoors(4)
                .isAutomaticGearbox(true)
                .build();

        System.out.println(carLombok);
    }
}
