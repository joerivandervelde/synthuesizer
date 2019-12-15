package nl.joerivandervelde.synthuesizer.light;

import nl.joerivandervelde.synthuesizer.light.action.Comma;
import nl.joerivandervelde.synthuesizer.light.action.Period;

import javax.swing.*;

import static java.awt.event.KeyEvent.VK_COMMA;
import static java.awt.event.KeyEvent.VK_PERIOD;

/**
 * Key bound controls for light.
 */
public class LightControls {

    public LightControls(JComponent component, Light light) {

        KeyStroke pressedComma = KeyStroke.getKeyStroke(VK_COMMA, 0,
                false);
        KeyStroke pressedStop = KeyStroke.getKeyStroke(VK_PERIOD, 0,
                false);

        component.getInputMap().put(pressedComma, ",");
        component.getInputMap().put(pressedStop, ".");

        component.getActionMap().put(",", new Comma(light));
        component.getActionMap().put(".", new Period(light));
    }
}
