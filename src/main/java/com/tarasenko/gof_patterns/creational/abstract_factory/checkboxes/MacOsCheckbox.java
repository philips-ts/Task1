package com.tarasenko.gof_patterns.creational.abstract_factory.checkboxes;

public class MacOsCheckbox implements Checkbox {
    @Override
    public void draw() {
        System.out.println("Drawing MacOs checkbox");
    }

    @Override
    public void isChecked() {
        System.out.println("MacOs checkbox is checked..");
    }
}
