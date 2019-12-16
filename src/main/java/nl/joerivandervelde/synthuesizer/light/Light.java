package nl.joerivandervelde.synthuesizer.light;

import io.github.zeroone3010.yahueapi.Hue;
import io.github.zeroone3010.yahueapi.Room;
import io.github.zeroone3010.yahueapi.State;
import nl.joerivandervelde.synthuesizer.io.GetProperties;
import nl.joerivandervelde.synthuesizer.light.mode.*;

import java.awt.*;
import java.util.Collection;
import java.util.Properties;

/**
 * The Light class sets up the Hue environment, facilitating changing light
 * modes and handles light events upon pressing and releasing notes.
 * Todo: replace 'rooms' with 'group(0)' to control many lights at once when
 * functionality becomes available in yahueapi to make it more responsive (?).
 */
public class Light {

    private Properties props;
    private Collection<Room> lights;
    private boolean hueConnected;
    private LightMode[] modes;
    private int selectedMode;

    /**
     * Constructor
     *
     * @param props
     */
    public Light(Properties props) {
        this.props = props;
        String bridgeIp = props.getProperty(GetProperties.BRIDGE_IP);
        String apiKey = props.getProperty(GetProperties.API_KEY);
        System.out
                .println("Connecting with Hue bridge at IP " + bridgeIp +
                        " using API key " + apiKey);
        final Hue hue = new Hue(bridgeIp, apiKey);
        try {
            hue.setCaching(true);
            lights = hue.getRooms();
            for (Room r : lights) {
                r.setState(State.builder().color(Color.GRAY).on());
            }
            hueConnected = true;
        } catch (Exception e) {
            hueConnected = false;
            System.out.println("Could not connect to Hue with provided " +
                    "settings. Network unreachable or bad properties " +
                    "file? Ignoring light inputs.");
        }
        modes = new LightMode[]{new Angelic(), new Cyberpunk(), new Desert(),
                new Disco(), new Forest(), new Frozen(), new Hell(),
                new Lavender(), new Thunder(), new Strobe()};
        changeModeTo(0);
    }

    /**
     * Set selected light mode to a particular index (0-modes.length-1).
     * Right now does not really do anything except print information because
     * nothing needs to happen after changeMode() has finished.
     *
     * @param mode
     */
    public void changeModeTo(int mode) {
        String name = modes[selectedMode].getClass().getName();
        System.out.println(
                "Setting lights to nr. " + (selectedMode + 1) + ", " +
                        name.substring(name.lastIndexOf(".") + 1));
    }

    /**
     * Increase or decrease the current light mode index with int delta.
     *
     * @param delta
     */
    public void changeMode(int delta) {
        selectedMode += delta;
        selectedMode = selectedMode % modes.length;
        selectedMode = selectedMode < 0 ? modes.length - 1 : selectedMode;
        changeModeTo(selectedMode);
    }

    /**
     * Trigger light event when a note has been pressed.
     *
     * @param noteNumber
     * @param velocity
     */
    public void pressNote(int noteNumber, int velocity) {
        if (!hueConnected) {
            return;
        }
        modes[selectedMode].performPressAction(noteNumber, velocity, lights);
    }

    /**
     * Trigger light event when a note has been released.
     *
     * @param noteNumber
     */
    public void releaseNote(int noteNumber) {
        if (!hueConnected) {
            return;
        }
        modes[selectedMode].performReleaseAction(noteNumber, lights);
    }
}
