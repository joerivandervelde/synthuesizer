package nl.joerivandervelde.synthuesizer.light.mode;

import nl.joerivandervelde.synthuesizer.io.ColorConvert;
import nl.joerivandervelde.synthuesizer.light.LightModePalette;

import java.awt.*;

/**
 * 'Lavender' light mode. Based on:
 * https://www.schemecolor.com/pastel-color-tones.php
 */
public class Lavender extends LightModePalette {
    @Override public Color[] getColors() {
        return new Color[]{
                ColorConvert.hex2Rgb("#E0BBE4"),
                ColorConvert.hex2Rgb("#957DAD"),
                ColorConvert.hex2Rgb("#D291BC"),
                ColorConvert.hex2Rgb("#FEC8D8"),
                ColorConvert.hex2Rgb("#FFDFD3")
        };
    }
}
