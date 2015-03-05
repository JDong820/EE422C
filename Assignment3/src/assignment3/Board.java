package assignment3;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;


class Board {
    private final List<MastermindEntry> history;

    Board() {
        history = new ArrayList<>();
    }

    /**
     * Accessor method for list of history entries, returns immutable list.
     * @return the list MastermindEntries
     */
    public List<MastermindEntry> getHistory() {
        return Collections.unmodifiableList(history);
    }

    /**
     * Modifier method to history, adding one entry.
     */
    public void addEntry(MastermindEntry e) {
        history.add(e);
    }
}
