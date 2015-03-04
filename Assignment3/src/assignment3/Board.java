package assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


class Board {
    private final List<MastermindEntry> history;

    Board() {
        history = new ArrayList<>();
    }

    public List<MastermindEntry> getHistory() {
        return Collections.unmodifiableList(history);
    }

    public void addEntry(MastermindEntry e) {
        history.add(e);
    }
}
