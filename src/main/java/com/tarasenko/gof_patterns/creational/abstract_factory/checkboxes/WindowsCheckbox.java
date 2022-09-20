package com.tarasenko.gof_patterns.creational.abstract_factory.checkboxes;

public class WindowsCheckbox implements Checkbox {
    @Override
    public void draw() {
        System.out.println("Drawing Windows checkbox");
    }

    @Override
    public void isChecked() {
        System.out.println("Windows checkbox is checked..");
    }
}
