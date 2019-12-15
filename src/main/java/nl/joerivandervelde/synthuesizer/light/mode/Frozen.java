package nl.joerivandervelde.synthuesizer.light.mode;

import nl.joerivandervelde.synthuesizer.io.ColorConvert;
import nl.joerivandervelde.synthuesizer.light.LightModePalette;

import java.awt.*;

/**
 * 'Frozen' light mode. Based on:
 * https://www.schemecolor.com/blue-iceberg.php
 */
public class Frozen extends LightModePalette {
    @Override public Color[] getColors() {
        return new Color[]{
                ColorConvert.hex2Rgb("#71A6D1"),
                ColorConvert.hex2Rgb("#9BC1E3"),
                ColorConvert.hex2Rgb("#B6DFF6"),
                ColorConvert.hex2Rgb("#DCF7FE"),
                ColorConvert.hex2Rgb("#60C4EB"),
                ColorConvert.hex2Rgb("#13ADEB")
        };
    }
}
