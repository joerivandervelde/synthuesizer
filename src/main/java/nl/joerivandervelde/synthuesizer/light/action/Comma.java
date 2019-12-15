package nl.joerivandervelde.synthuesizer.light.action;

import nl.joerivandervelde.synthuesizer.light.Light;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Comma extends AbstractAction implements ActionListener {

    Light light;

    public Comma(Light light) {
        this.light = light;
    }

    @Override public void actionPerformed(ActionEvent e) {
        light.changeMode(-1);
    }
}
