package assignment5;

import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;
import java.util.stream.*;

public class A5Driver {
    private static ArrayDeque<String> solution;
    private static Stack<String> SolutionList;
    private static Set<String> visitedNodes;
    private static Dictionary dict;
    private static StopWatch watch;

    public static void main(String[] args) throws Exception {
        String inputFile = "assn5data.txt";
        String dictFile = "assn5words.dat";
        dict = new Dictionary();

        if (args.length == 2) {
            dictFile = args[0];
            inputFile = args[1];
        } else if (args.length != 0) {
            System.out.println("Usage: A5Driver [<dictionary> <input>]");
            System.exit(1);
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

        System.out.println("Searching for ladder from " + words[0] + " to "
                           + words[1]);

        assert(words.length == 2);

        SolutionList = new Stack<String>();
        visitedNodes = new HashSet<String>();
        MakeLadder(words[0], words[1], -1);

        printSolution(SolutionList);
    }

    public static boolean isValidInputLine(String line) {
        for (int i = 0; i < line.length(); ++i) {
            char c = line.charAt(i);
            if (i == 5) {
                if (line.charAt(5) != ' ') {
                    return false;
                }
            } else if (!(('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z'))) {
                return false;
            }
        }
        return true;
    }

    public static void printSolution(List<String> solution) {
        if (solution.size() > 0) {
            for (String s: solution) {
                System.out.println(s);
            }
        } else {
            System.out.println("There is no word ladder between ...");
        }
        System.out.println("**********");
    }

    public static boolean MakeLadder(String fromWord,
                                     String toWord,
                                     int index) {
        SolutionList.push(fromWord);
        visitedNodes.add(fromWord);

        if (fromWord.equals(toWord)) {
            return true;
        }

        Set<String> newAdjacentNodes = dict.getAdjacent(fromWord, index);
        newAdjacentNodes.removeAll(visitedNodes);
        for (String s: newAdjacentNodes) {
            if (MakeLadder(s, toWord, index)) {
                return true;
            }
        }

        SolutionList.pop();
        return false;
    }
}
