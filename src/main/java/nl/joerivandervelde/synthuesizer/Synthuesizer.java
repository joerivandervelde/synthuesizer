package nl.joerivandervelde.synthuesizer;

import nl.joerivandervelde.synthuesizer.io.GetProperties;
import nl.joerivandervelde.synthuesizer.io.SynthKeyBinder;
import nl.joerivandervelde.synthuesizer.light.Light;
import nl.joerivandervelde.synthuesizer.light.LightControls;
import nl.joerivandervelde.synthuesizer.sound.Sound;
import nl.joerivandervelde.synthuesizer.sound.SoundControls;

import javax.swing.*;
import java.awt.*;
import java.util.Properties;

import static java.awt.event.KeyEvent.*;

/**
 * Initialize a new Synthuesizer instance. First, the properties file is read
 * and parsed to get the Hue bridge IP and API key needed to connect the
 * lights. Then a JFrame is created needed for key binding, followed by
 * creating instances of Sound and Light. Finally keys to play the notes are
 * connected to sound and light.
 */
public class Synthuesizer extends JFrame {

    // velocity means how fast a note is pressed, value between 0-127
    public static final int NOTE_VELOCITY = 127;

    // fast and slow transition times for lights. unit unclear.
    public static final int HUE_FAST_TTIME = 0;
    public static final int HUE_SLOW_TTIME = 5;

    /**
     * Constructor without props
     *
     * @throws Exception
     */
    public Synthuesizer() throws Exception {
        new Synthuesizer(null);
    }

    /**
     * Constructor with props
     *
     * @param propsFileLoc
     * @throws Exception
     */
    public Synthuesizer(String propsFileLoc) throws Exception {

        System.out.println("Starting up Synthuesizer...");
        Properties props = new Properties();
        if(propsFileLoc != null){
            System.out.println("Loading properties file...");
            GetProperties gp = new GetProperties(propsFileLoc);
            props = gp.getProperties();
        }else{
            props.setProperty(GetProperties.BRIDGE_IP, "na");
            props.setProperty(GetProperties.API_KEY, "na");
        }

        System.out.println("Creating JFrame...");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.getContentPane().setLayout(new FlowLayout());
        JTextArea comp = new JTextArea();
        comp.setText("Synthuesizer active. Focus to play. Close to exit.");
        comp.setEditable(false);
        comp.setLineWrap(true);
        comp.setSize(350, 50);
        add(comp);
        setSize(350, 50);
        setVisible(true);

        int[] keysLowToHigh = new int[]{VK_Z, VK_X, VK_C, VK_V, VK_B, VK_N,
                VK_M, VK_A, VK_S, VK_D, VK_F, VK_G, VK_H, VK_J, VK_K, VK_L,
                VK_Q, VK_W, VK_E, VK_R, VK_T, VK_Y, VK_U, VK_I, VK_O, VK_P,
                VK_P, VK_1, VK_2, VK_3, VK_4, VK_5, VK_6, VK_7, VK_8, VK_9,
                VK_0};

        System.out.println("Creating sound...");
        Sound sound = new Sound(1, 40, keysLowToHigh.length);
        new SoundControls(comp, sound);

        System.out.println("Creating light...");
        Light light = new Light(props);
        new LightControls(comp, light);

        System.out.println("Binding keys...");
        for (int i = 0; i < keysLowToHigh.length; i++) {
            new SynthKeyBinder(i, NOTE_VELOCITY, keysLowToHigh[i], comp, sound,
                    light);
        }

        System.out.println("Synthuesizer active. How to use:");
        System.out.println("- Use alphanumericals to play notes (A-Z + 0-9).");
        System.out.println("- Change instrument with LEFT and RIGHT arrow.");
        System.out.println("- Change pitch with UP and DOWN arrow.");
        System.out.println("- Change lights with COMMA and PERIOD (< and >)");
    }
}
