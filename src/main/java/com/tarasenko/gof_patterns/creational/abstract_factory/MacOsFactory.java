package com.tarasenko.gof_patterns.creational.abstract_factory;

import com.tarasenko.gof_patterns.creational.abstract_factory.buttons.Button;
import com.tarasenko.gof_patterns.creational.abstract_factory.buttons.WindowsButton;
import com.tarasenko.gof_patterns.creational.abstract_factory.checkboxes.Checkbox;
import com.tarasenko.gof_patterns.creational.abstract_factory.checkboxes.MacOsCheckbox;

public class MacOsFactory implements GUIFactory {
    @Override
    public Button createButton() {
        return new WindowsButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacOsCheckbox();
    }
}
