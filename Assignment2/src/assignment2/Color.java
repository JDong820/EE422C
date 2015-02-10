package assignment2;


public enum Color {
    BLUE, GREEN, ORANGE, PURPLE, RED, YELLOW;

    public static Color getColorFromCode(char code)
    throws InvalidColorCodeException {
        return getColorFromString(Character.toString(code));
    }

    public static Color getColorFromString(String code)
    throws InvalidColorCodeException {
        if (code.length() != 0)
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
}
