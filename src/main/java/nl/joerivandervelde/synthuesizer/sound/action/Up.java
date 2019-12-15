package nl.joerivandervelde.synthuesizer.sound.action;

import nl.joerivandervelde.synthuesizer.sound.Sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Up extends AbstractAction implements ActionListener {

    Sound sound;

    public Up(Sound sound) {
        this.sound = sound;
    }

    @Override public void actionPerformed(ActionEvent e) {
        sound.changePitch(1);
    }
}
