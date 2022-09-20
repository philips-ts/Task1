package com.tarasenko.gof_patterns.creational.abstract_factory.buttons;

public class WindowsButton implements Button{
    @Override
    public void draw() {
        System.out.println("Drawing windows button..");
    }

    @Override
    public void onClick() {
        System.out.println("Windows button is clicked");
    }
}
