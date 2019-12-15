package nl.joerivandervelde.synthuesizer.light.mode;

import nl.joerivandervelde.synthuesizer.io.ColorConvert;
import nl.joerivandervelde.synthuesizer.light.LightModePalette;

import java.awt.*;

/**
 * 'Forest' light mode. Based on:
 * https://www.schemecolor.com/big-forest-color-scheme.php
 */
public class Forest extends LightModePalette {
    @Override public Color[] getColors() {
        return new Color[]{
                ColorConvert.hex2Rgb("#E8F0B5"),
                ColorConvert.hex2Rgb("#C5DF71"),
                ColorConvert.hex2Rgb("#5E8C41"),
                ColorConvert.hex2Rgb("#453A24"),
                ColorConvert.hex2Rgb("#3F6A4E"),
                ColorConvert.hex2Rgb("#A6DCAA")
        };
    }
}
