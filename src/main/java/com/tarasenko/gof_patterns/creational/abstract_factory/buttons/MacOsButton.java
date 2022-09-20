package com.tarasenko.gof_patterns.creational.abstract_factory.buttons;

public class MacOsButton implements Button{
    @Override
    public void draw(){
        System.out.println("Drawing MacOs button..");
    }

    @Override
    public void onClick(){
        System.out.println("MacOs button is clicked");
    }
}
