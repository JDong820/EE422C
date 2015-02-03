package assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {

    public static void main (String args[]) {
        if (args.length != 1) {
            System.err.println ("Error: Incorrect number of command line arguments");
            System.exit(-1);
        }
        processLinesInFile (args[0]);

    }

    public static void processLinesInFile (String filename) {
        PalFinder myPalFinder = new PalFinder();
        try {
            FileReader freader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(freader);

            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                System.out.println("The input string is: " + s);
                String palindromes = myPalFinder.parse(s);
                System.out.println("The Palindromes found: " + palindromes);
            }
        } catch (FileNotFoundException e) {
            System.err.println ("Error: File not found. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            System.err.println ("Error: IO exception. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }
    }
}
