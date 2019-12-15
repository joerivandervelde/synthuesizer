package nl.joerivandervelde.synthuesizer.sound;

import nl.joerivandervelde.synthuesizer.sound.action.Down;
import nl.joerivandervelde.synthuesizer.sound.action.Left;
import nl.joerivandervelde.synthuesizer.sound.action.Right;
import nl.joerivandervelde.synthuesizer.sound.action.Up;

import javax.swing.*;

import static java.awt.event.KeyEvent.*;

/**
 * Key bound controls for sound.
 */
public class SoundControls {

    public SoundControls(JComponent component, Sound sound) {

        KeyStroke pressedLeft = KeyStroke.getKeyStroke(VK_LEFT, 0,
                false);
        KeyStroke pressedRight = KeyStroke.getKeyStroke(VK_RIGHT, 0,
                false);

        KeyStroke pressedUp = KeyStroke.getKeyStroke(VK_UP, 0,
                false);
        KeyStroke pressedDown = KeyStroke.getKeyStroke(VK_DOWN, 0,
                false);

        component.getInputMap().put(pressedLeft, "Left");
        component.getInputMap().put(pressedRight, "Right");
        component.getInputMap().put(pressedUp, "Up");
        component.getInputMap().put(pressedDown, "Down");

        component.getActionMap().put("Left", new Left(sound));
        component.getActionMap().put("Right", new Right(sound));
        component.getActionMap().put("Up", new Up(sound));
        component.getActionMap().put("Down", new Down(sound));


    }

}
