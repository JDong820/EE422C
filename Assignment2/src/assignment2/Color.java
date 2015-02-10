package assignment2;

import java.io.UnsupportedEncodingException;


public enum Color {
    BLUE, GREEN, ORANGE, PURPLE, RED, YELLOW;

    public static Color getColorFromCode(char code)
    throws InvalidColorCodeException {
        return getColorFromString(Character.toString(code));
    }

    public static Color getColorFromString(String code)
    throws InvalidColorCodeException {
        if (code.length() != 1)
            throw new InvalidColorCodeException("Code length incorrect.");
        switch (code) {
        case "B":
            return Color.BLUE;
        case "G":
            return Color.GREEN;
        case "O":
            return Color.ORANGE;
        case "P":
            return Color.PURPLE;
        case "R":
            return Color.RED;
        case "Y":
            return Color.YELLOW;
        default:
            throw new InvalidColorCodeException("Code not found.");
        }
    }

    public static String getColorCode(Color c) {
        switch (c) {
        case BLUE:
            return "B";
        case GREEN:
            return "G";
        case PURPLE:
            return "P";
        case ORANGE:
            return "O";
        case RED:
            return "R";
        case YELLOW:
            return "Y";
        default:
            throw new InvalidColorCodeException("No code for color.");
        }
    }

    public static String getColoredColorCode(Color c) {
        if (System.getProperty("os.name").equals("Linux")) {
            final String reset, magenta, blue, yellow, green, orange, red;
            reset = new String(new byte[] {0x1b, '[', '3', '9', 'm'});
            magenta = new String(new byte[] {0x1b, '[', '3', '5', 'm'});
            blue = new String(new byte[] {0x1b, '[', '3', '4', 'm'});
            yellow = new String(new byte[] {0x1b, '[', '3', '3', 'm'});
            green = new String(new byte[] {0x1b, '[', '3', '2', 'm'});
            red = new String(new byte[] {0x1b, '[', '3', '1', 'm'});
            orange = new String(new byte[] {0x1b, '[', '3', '2', 'm'});

            switch (c) {
            case BLUE:
                return blue + "B" + reset;
            case GREEN:
                return green + "G" + reset;
            case PURPLE:
                return magenta + "P" + reset;
            case ORANGE:
                return "O";
            case RED:
                return red + "R" + reset;
            case YELLOW:
                return yellow + "Y" + reset;
            default:
                throw new InvalidColorCodeException("No colored code for color.");
            } 
        } else {
            return getColorCode(c);
        }

   }
}
