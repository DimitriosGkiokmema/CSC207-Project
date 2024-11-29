package main.java;

import java.awt.Dimension;
import java.awt.Toolkit;

/**
 * Constants used in this program.
 */
public class Constants {
    // App Size
    private static final Dimension SCREEN_SIZE = Toolkit.getDefaultToolkit().getScreenSize();
    public static final int APP_WIDTH = SCREEN_SIZE.width;
    public static final int APP_HEIGHT = SCREEN_SIZE.height;
    public static final int MIN_HEIGHT = 400;
    public static final int MIN_WIDTH = 400;
}

