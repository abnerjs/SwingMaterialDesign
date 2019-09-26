package com.hq.swingmaterialdesign.materialdesign.resource;

import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

/**
 * The Nunito font.
 *
 *
 * @author abner (abner.js05@gmail.com)
 */
public class Nunito {

    public static final Font BLACK = loadFont("Nunito-Black.ttf").deriveFont(Font.BOLD);
    public static final Font BLACK_ITALIC = loadFont("Nunito-BlackItalic.ttf").deriveFont(Font.BOLD | Font.ITALIC);
    public static final Font BOLD = loadFont("Nunito-Bold.ttf").deriveFont(Font.BOLD);
    public static final Font BOLD_ITALIC = loadFont("Nunito-BoldItalic.ttf").deriveFont(Font.BOLD | Font.ITALIC);
    public static final Font EXTRA_BOLD = loadFont("Nunito-ExtraBold.ttf").deriveFont(Font.BOLD);
    public static final Font EXTRA_BOLD_ITALIC = loadFont("Nunito-ExtraBoldItalic.ttf").deriveFont(Font.ITALIC);
    public static final Font EXTRA_LIGHT = loadFont("Nunito-ExtraLight.ttf").deriveFont(Font.PLAIN);
    public static final Font EXTRA_LIGHT_ITALIC = loadFont("Nunito-ExtraLightItalic.ttf").deriveFont(Font.ITALIC);
    public static final Font LIGHT = loadFont("Nunito-Light.ttf").deriveFont(Font.PLAIN);
    public static final Font LIGHT_ITALIC = loadFont("Nunito-LightItalic.ttf").deriveFont(Font.ITALIC);
    public static final Font REGULAR = loadFont("Nunito-Regular.ttf").deriveFont(Font.PLAIN);
    public static final Font REGULAR_ITALIC = loadFont("Nunito-RegularItalic.ttf").deriveFont(Font.ITALIC);
    public static final Font SEMI_BOLD = loadFont("Roboto-SemiBold.ttf").deriveFont(Font.PLAIN);
    public static final Font SEMI_BOLD_ITALIC = loadFont("Roboto-SemiBoldItalic.ttf").deriveFont(Font.ITALIC);

    private static Font loadFont(String resourceName) {
        try (InputStream inputStream = Nunito.class.getResourceAsStream("/resources/fonts/" + resourceName)) {
            return Font.createFont(Font.TRUETYPE_FONT, inputStream);
        } catch (IOException | FontFormatException e) {
            throw new RuntimeException("Could not load " + resourceName, e);
        }
    }
}
