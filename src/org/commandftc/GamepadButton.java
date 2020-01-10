package org.commandftc;

import java.util.function.BooleanSupplier;

public class GamepadButton extends Trigger {
    private GamepadButton(BooleanSupplier isPressed) {
        super(isPressed);
    }
}