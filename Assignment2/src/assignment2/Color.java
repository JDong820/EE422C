package assignment2;


public enum Color {
    BLUE, GREEN, ORANGE, PURPLE, RED, YELLOW, VOID;

    static final String reset = new String(new byte[] {0x1b, '[', '3', '9', 'm'});
    static final String resetBack = new String(new byte[] {0x1b, '[', '4', '9', 'm'});
    static final String magenta = new String(new byte[] {0x1b, '[', '3', '5', 'm'});
    static final String blue = new String(new byte[] {0x1b, '[', '3', '4', 'm'});
    static final String yellow = new String(new byte[] {0x1b, '[', '3', '3', 'm'});
    static final String green = new String(new byte[] {0x1b, '[', '3', '2', 'm'});
    static final String red = new String(new byte[] {0x1b, '[', '3', '1', 'm'});
    static final String orange = red + new String(new byte[] {0x1b, '[', '4', '3', 'm'});

    public boolean equals(Color c) {
        if (this == VOID)
            return false;
        return (c == this);
    }
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

    public static String getColorCode(Color c)
    throws InvalidColorCodeException {
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
        case VOID:
            return "-";
        default:
            throw new InvalidColorCodeException("No code for color.");
        }
    }

    public static String getColoredColorCode(Color c)
    throws InvalidColorCodeException {
        if (System.getProperty("os.name").equals("Linux")) {
            String defaultCode = getColorCode(c);
            switch (c) {
            case BLUE:
                return blue + defaultCode + reset;
            case GREEN:
                return green + defaultCode  + reset;
            case PURPLE:
                return magenta + defaultCode + reset;
            case ORANGE:
                return orange + defaultCode + resetBack + reset;
            case RED:
                return red + defaultCode + reset;
            case YELLOW:
                return yellow + defaultCode + reset;
            default:
                return defaultCode;
            }
        } else {
            return getColorCode(c);
        }
    }
}
