package nl.joerivandervelde.synthuesizer.io;

import nl.joerivandervelde.synthuesizer.light.Light;
import nl.joerivandervelde.synthuesizer.sound.Sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Bind keys to the virtual synthesizer. This way of implementing prevents
 * key repeating by registering a key press, then ignoring subsequent
 * presses, registering a key release, and only then listen to key presses
 * again. Inspired by: https://coderanch.com/t/606742/java/key-bindings
 */
public class SynthKeyBinder extends AbstractAction implements ActionListener {

    // local variables
    private int noteNumber;
    private int velocity;
    private JComponent component;
    private KeyStroke pressedKeyStroke;
    private boolean listeningForKeyPressed;
    private Sound sound;
    private Light light;

    /**
     * Constructor
     *
     * @param noteNumber
     * @param velocity
     * @param keyCode
     * @param component
     * @param sound
     * @param light
     */
    public SynthKeyBinder(int noteNumber, int velocity,
                          int keyCode, JComponent component, Sound sound,
                          Light light) {
        super("Note number " + noteNumber);
        this.noteNumber = noteNumber;
        this.velocity = velocity;
        this.component = component;
        this.sound = sound;
        this.light = light;
        pressedKeyStroke = KeyStroke.getKeyStroke(keyCode, 0, false);
        KeyStroke releasedKeyStroke = KeyStroke.getKeyStroke(keyCode, 0, true);
        component.getInputMap().put(pressedKeyStroke, getValue(Action.NAME));
        // Fixme: if 'JComponent.WHEN_IN_FOCUSED_WINDOW' is used, keys repeat?
        component.getInputMap().put(releasedKeyStroke, getValue(Action.NAME));
        component.getActionMap().put(getValue(Action.NAME), this);
        listeningForKeyPressed = true;
    }

    /**
     * Calls handleKeyEvent for key presses and releases while preventing key
     * repeats by adding or removing keys from input map and flipping a
     * boolean.
     *
     * @param e
     */
    @Override public void actionPerformed(ActionEvent e) {
        if (listeningForKeyPressed) {
            handleKeyEvent(true, noteNumber, velocity);
            component.getInputMap().remove(pressedKeyStroke);
            listeningForKeyPressed = false;
        } else {
            handleKeyEvent(false, noteNumber, velocity);
            component.getInputMap()
                    .put(pressedKeyStroke, getValue(Action.NAME));
            listeningForKeyPressed = true;
        }
    }

    /**
     * Call sound and light events when keys are pressed or released.
     * @param pressed
     * @param noteNumber
     * @param velocity
     */
    private void handleKeyEvent(boolean pressed, int noteNumber, int velocity) {
        if (pressed) {
            sound.pressNote(noteNumber, velocity);
            light.pressNote(noteNumber, velocity);
        } else {
            sound.releaseNote(noteNumber);
            light.releaseNote(noteNumber);
        }
    }
}
