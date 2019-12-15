package nl.joerivandervelde.synthuesizer.light.mode;

import io.github.zeroone3010.yahueapi.Room;
import nl.joerivandervelde.synthuesizer.light.LightMode;

import java.util.Collection;

/**
 * 'Rainbow' light mode.
 * TODO !!
 * either transit across rainbow colors, e.g. each press advances by 1 of 255
 * or let the note number determine the rainbow color, e.g. low = red, high =
 * violet ?
 */
public class Rainbow implements LightMode {

    @Override public void performPressAction(int noteNumber, int velocity,
                                             Collection<Room> light) {
    }

    @Override
    public void performReleaseAction(int noteNumber, Collection<Room> light) {

    }
}
