package assignment3;


class MastermindResult {
    final int white;
    final int black;

    MastermindResult(int w, int b) {
        white = w;
        black = b;
    }

    public String toString() {
        if (white == 0 && black == 0)
            return "No pegs";
        else
            return black + " black peg" + (black > 1 ? "s" : "") + " and "
                   + white + " white peg" + (white > 1 ? "s" : "");
    }
}
