package nl.joerivandervelde.synthuesizer.light.mode;

import nl.joerivandervelde.synthuesizer.io.ColorConvert;
import nl.joerivandervelde.synthuesizer.light.LightModePalette;

import java.awt.*;

/**
 * 'Thunder' light mode. Based on:
 * https://www.schemecolor.com/thunder-and-lightning.php
 */
public class Thunder extends LightModePalette {
    @Override public Color[] getColors() {
        return new Color[]{
                ColorConvert.hex2Rgb("#1D2430"),
                ColorConvert.hex2Rgb("#2D3540"),
                ColorConvert.hex2Rgb("#F1F9F8"),
                ColorConvert.hex2Rgb("#9BA09C"),
                ColorConvert.hex2Rgb("#59646C"),
                ColorConvert.hex2Rgb("#465056")
        };
    }
}
