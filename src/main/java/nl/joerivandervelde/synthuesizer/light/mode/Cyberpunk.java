package nl.joerivandervelde.synthuesizer.light.mode;

import nl.joerivandervelde.synthuesizer.io.ColorConvert;
import nl.joerivandervelde.synthuesizer.light.LightModePalette;

import java.awt.*;

/**
 * 'Cyberpunk' light mode. Based on:
 * https://www.schemecolor.com/everything-unawares.php
 */
public class Cyberpunk extends LightModePalette {
    @Override public Color[] getColors() {
        return new Color[]{
                ColorConvert.hex2Rgb("#FA3CC0"),
                ColorConvert.hex2Rgb("#E60178"),
                ColorConvert.hex2Rgb("#A819A7"),
                ColorConvert.hex2Rgb("#5C29A2"),
                ColorConvert.hex2Rgb("#006FDB"),
                ColorConvert.hex2Rgb("#16B2F1")
        };
    }
}
