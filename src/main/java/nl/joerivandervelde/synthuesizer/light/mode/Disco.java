package nl.joerivandervelde.synthuesizer.light.mode;

import nl.joerivandervelde.synthuesizer.io.ColorConvert;
import nl.joerivandervelde.synthuesizer.light.LightModePalette;

import java.awt.*;

/**
 * 'Disco' light mode. Based on:
 * https://www.schemecolor.com/christmas-tree-lighting-colors.php
 */
public class Disco extends LightModePalette {
    @Override public Color[] getColors() {
        return new Color[]{
                ColorConvert.hex2Rgb("#8934B8"),
                ColorConvert.hex2Rgb("#0A53DE"),
                ColorConvert.hex2Rgb("#24D024"),
                ColorConvert.hex2Rgb("#FBF21A"),
                ColorConvert.hex2Rgb("#FB6F24"),
                ColorConvert.hex2Rgb("#EA0D0D")
        };
    }
}
