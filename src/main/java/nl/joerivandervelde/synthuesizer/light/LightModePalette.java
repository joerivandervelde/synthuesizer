package nl.joerivandervelde.synthuesizer.light;

import io.github.zeroone3010.yahueapi.Room;
import io.github.zeroone3010.yahueapi.State;

import java.awt.*;
import java.util.Collection;
import java.util.Random;

import static nl.joerivandervelde.synthuesizer.Synthuesizer.HUE_FAST_TTIME;
import static nl.joerivandervelde.synthuesizer.Synthuesizer.HUE_SLOW_TTIME;

/**
 * A partial implementation of LightMode that acts as a template for a
 * specific type of lighting that only needs an Color[] to be completed.
 */
public abstract class LightModePalette implements LightMode {

    /**
     * An array of colors used in this light mode. Must be supplied in
     * implementations of this class.
     *
     * @return
     */
    public abstract Color[] getColors();

    // current color
    private int current;

    // random number generator
    private Random rng;

    /**
     * Constructor
     */
    public LightModePalette() {
        rng = new Random();
    }

    /**
     * Return new pseudo random color index. Not random because the
     * current color index will not be returned.
     *
     * @return
     */
    public int getNextNonCurrentRandom() {
        if (getColors().length < 2) {
            throw new RuntimeException("must be at least 2 colors");
        }
        int rnd = rng.nextInt(getColors().length);
        return rnd == current ? getNextNonCurrentRandom() : rnd;
    }

    /**
     * Light action performed when a note is pressed.
     *
     * @param noteNumber
     * @param velocity
     * @param light
     */
    @Override public void performPressAction(int noteNumber, int velocity,
                                             Collection<Room> light) {
        current = getNextNonCurrentRandom();
        for (Room r : light) {
            r.setState(State.builder().color(io.github.zeroone3010.yahueapi.Color.of(getColors()[current]))
                    .transitionTime(HUE_FAST_TTIME).on());
        }
    }

    /**
     * Light action performed when a note is released.
     *
     * @param noteNumber
     * @param light
     */
    @Override public void performReleaseAction(int noteNumber,
                                               Collection<Room> light) {
        for (Room r : light) {
            r.setState(State.builder().color(io.github.zeroone3010.yahueapi.Color.of(getColors()[current].darker()))
                    .transitionTime(HUE_SLOW_TTIME).on());
        }
    }
}
