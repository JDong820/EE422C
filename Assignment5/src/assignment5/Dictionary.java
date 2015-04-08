package assignment5;

import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;


class Dictionary {
    private static final int WORD_LEN = 5;
    private Set<String> wordBank;

    public Dictionary() {
        wordBank = new HashSet<String>();
    }

    public void addFile(String filename) throws IOException {
        Set<String> set = new HashSet<String>();
        Path path = Paths.get(System.getProperty("user.dir"), filename);

        try (Stream<String> lines = Files.lines(path)) {
            lines
            .filter(line -> line.charAt(0) != '*')
            .forEach(word -> set.add(word.substring(0,
                                                    WORD_LEN)));
            wordBank.addAll(set);
        }
    }

    private int distance(String s1, String s2) {
        assert(s1.length() != s2.length());

        int count = 0;

        for (int i = 0; i < s1.length(); ++i) {
            if (s1.charAt(i) != s2.charAt(i)) {
                ++count;
            }
        }

        return count;
    }

    public Set<String> getAdjacent(String from, int index) {
        Set<String> set = new HashSet<String>();

        for (String word: wordBank) {
            if (distance(word, from) == 1
                    && (index == -1
                        || from.charAt(index) == word.charAt(index))) {
                set.add(word);
            }
        }

        return set;
    }
}
