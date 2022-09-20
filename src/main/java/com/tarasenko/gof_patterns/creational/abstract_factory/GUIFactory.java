package com.tarasenko.gof_patterns.creational.abstract_factory;

import com.tarasenko.gof_patterns.creational.abstract_factory.buttons.Button;
import com.tarasenko.gof_patterns.creational.abstract_factory.checkboxes.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();

    static GUIFactory of(String osName) {
        osName = osName.toLowerCase();

        if (osName.contains("mac")) {
            return new MacOsFactory();
        }
        if (osName.contains("windows")){
            return new WindowsFactory();
        }

        throw new UnsupportedOperationException("Unsupported OS version");
    }
}
