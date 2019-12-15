package nl.joerivandervelde.synthuesizer.light.mode;

import io.github.zeroone3010.yahueapi.Room;
import io.github.zeroone3010.yahueapi.State;
import nl.joerivandervelde.synthuesizer.light.LightMode;

import java.awt.*;
import java.util.Collection;

import static nl.joerivandervelde.synthuesizer.Synthuesizer.HUE_FAST_TTIME;

/**
 * 'Strobe' light mode.
 * On press, turn all lights white.
 * On release, turn all lights off.
 */
public class Strobe implements LightMode {

    @Override public void performPressAction(int noteNumber, int velocity,
                                             Collection<Room> light) {
        for (Room r : light) {
            r.setState(
                    State.builder().color(Color.WHITE)
                            .transitionTime(HUE_FAST_TTIME).on());
        }
    }

    @Override
    public void performReleaseAction(int noteNumber, Collection<Room> light) {
        for (Room r : light) {
            r.setState(
                    State.builder().color(Color.WHITE)
                            .transitionTime(HUE_FAST_TTIME).off());
        }
    }
}
