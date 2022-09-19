package com.tarasenko.gof_patterns.creational.abstract_factory;

import com.tarasenko.gof_patterns.creational.abstract_factory.buttons.Button;
import com.tarasenko.gof_patterns.creational.abstract_factory.checkboxes.Checkbox;

public class Test {
    public static void main(String[] args) {
        GUIFactory guiFactory = GUIFactory.of( System.getProperty("os.name"));
        Button button = guiFactory.createButton();
        Checkbox checkbox = guiFactory.createCheckbox();
        button.draw();
        checkbox.draw();
    }
}
