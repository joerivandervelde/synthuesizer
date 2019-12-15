package nl.joerivandervelde.synthuesizer.light.mode;

import nl.joerivandervelde.synthuesizer.io.ColorConvert;
import nl.joerivandervelde.synthuesizer.light.LightModePalette;

import java.awt.*;

/**
 * 'Desert' light mode. Based on:
 * https://www.schemecolor.com/peach-and-khaki.php
 */
public class Desert extends LightModePalette {
    @Override public Color[] getColors() {
        return new Color[]{
                ColorConvert.hex2Rgb("#FECEA4"),
                ColorConvert.hex2Rgb("#FFE6B6"),
                ColorConvert.hex2Rgb("#C2AF92"),
                ColorConvert.hex2Rgb("#D5C97D"),
                ColorConvert.hex2Rgb("#EEE68E")
        };
    }
}
