package nl.joerivandervelde.synthuesizer.light.mode;

import nl.joerivandervelde.synthuesizer.io.ColorConvert;
import nl.joerivandervelde.synthuesizer.light.LightModePalette;

import java.awt.*;

/**
 * 'Angelic' light mode. Based on:
 * https://www.schemecolor.com/pastel-blues-and-peach.php
 */
public class Angelic extends LightModePalette {
    @Override public Color[] getColors() {
        return new Color[]{
                ColorConvert.hex2Rgb("#65D4E8"),
                ColorConvert.hex2Rgb("#A7F0FA"),
                ColorConvert.hex2Rgb("#C7F9FA"),
                ColorConvert.hex2Rgb("#FCFFEC"),
                ColorConvert.hex2Rgb("#FFFAD4"),
                ColorConvert.hex2Rgb("#FFE5B5")
        };
    }
}
