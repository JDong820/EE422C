package assignment5;

import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class A5Driver {
    private static ArrayDeque<String> solution;
    private static List<String> SolutionList;
    private static StopWatch watch;

    public static void main(String[] args) {
        String inputFile = "assn5data.txt";
        String dictFile = "assn5words.dat";
        Dictionary dict = new Dictionary();
        SolutionList = new ArrayList<String>();

        if (args.length == 2) {
            dictFile = args[0];
            inputFile = args[1];
        } else if (args.length != 0) {
            throw new Exception("Usage: A5Driver [<dictionary> <input>]");
        }

        dict.addFile(dictFile);

        Path path = Paths.get(System.getProperty("user.dir"),
                              inputFile);
        try (Stream<String> lines = Files.lines(path)) {
            lines
            .filter(line -> isValidInputLine(line))
            .forEach(line -> findLadder(line.split(" ")));
        }
    }

    private static void findLadder(String[] words) {
        if (words.length != 2) {
            throw new Exception("Illegal arguments parsed.");
        } else {
            SolutionList = new ArrayList<String>();
            MakeLadder(words[0], words[1], -1);
        }
        printSolution(SolutionList);
    }

    public static boolean isValidInputLine(String line) {
        for (int i = 0; i < line.length(); ++i) {
            if (i == 5) {
                if (line.charAt(5) != ' ') {
                    return false;
                }
            }
            char c = line.charAt(i);
            if (!(('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z'))) {
                return false;
            }
        }
        return true;
    }

    public static void printSolution(List<String> solution) {
        for (String s: solution) {
            System.out.println(s);
        }
        System.out.println("**********");
    }

    public static boolean MakeLadder(String fromWord,
                                     String toWord,
                                     int index) {
        // Warning: Uses stateful recursion!

        return false;
    }

}
