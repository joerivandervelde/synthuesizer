package nl.joerivandervelde.synthuesizer.sound.action;

import nl.joerivandervelde.synthuesizer.sound.Sound;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Down extends AbstractAction implements ActionListener {

    Sound sound;

    public Down(Sound sound) {
        this.sound = sound;
    }

    @Override public void actionPerformed(ActionEvent e) {
        sound.changePitch(-1);
    }
}
