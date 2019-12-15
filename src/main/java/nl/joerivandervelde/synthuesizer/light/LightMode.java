package nl.joerivandervelde.synthuesizer.light;

import io.github.zeroone3010.yahueapi.Room;

import java.util.Collection;

/**
 * Interface for adding additional light modes.
 */
public interface LightMode {
    void performPressAction(int noteNumber, int velocity,
                            Collection<Room> light);

    void performReleaseAction(int noteNumber, Collection<Room> light);
}
