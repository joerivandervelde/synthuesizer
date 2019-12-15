package nl.joerivandervelde.synthuesizer.light.mode;

import nl.joerivandervelde.synthuesizer.io.ColorConvert;
import nl.joerivandervelde.synthuesizer.light.LightModePalette;

import java.awt.*;

/**
 * 'Hell' light mode. Based on:
 * https://www.schemecolor.com/hot-as-hell-color-scheme.php
 */
public class Hell extends LightModePalette {

    @Override public Color[] getColors() {
        return new Color[]{
                ColorConvert.hex2Rgb("#950000"),
                ColorConvert.hex2Rgb("#DE2116"),
                ColorConvert.hex2Rgb("#FF3C00"),
                ColorConvert.hex2Rgb("#FFBF00"),
                ColorConvert.hex2Rgb("#FFE601"),
                ColorConvert.hex2Rgb("#FF5C00")
        };
    }

}
