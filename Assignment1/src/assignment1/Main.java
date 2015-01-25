/* Student Name: Joshua Dong, Lab Section: 1  */
package assignment1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Set;
import java.util.stream.Collectors;

public class Main {

    public static void main(String args[]) {
        if (args.length != 1) {
            System.err.println("Error: Incorrect number of command line arguments");
            System.exit(-1);
        }
        ArrayList<String> lines = readFile(args[0]);
        PalFinder palindromeFinder = new PalFinder();
        for (String line: lines) {
            Set<String> palindromes = palindromeFinder.parse(line);
            // Debug
            System.out.println("<<< " + line);
            System.out.println(makeOutput(palindromes));
        }
    }

    /**
     * Reads filename line-by-line, 
     * @param filename - the name of the file that needs to be read
     * @return ArrayList of lines in the file.
     */
    public static ArrayList<String> readFile(String filename) {
        try {
            FileReader freader = new FileReader(filename);
            BufferedReader reader = new BufferedReader(freader);
            ArrayList<String> lines = new ArrayList<String>();
            for (String s = reader.readLine(); s != null; s = reader.readLine()) {
                //if (s == "QUIT") break;
                lines.add(s);
            }
            reader.close();
            freader.close();
            return lines;
        } catch (FileNotFoundException e) {
            System.err.println ("Error: File not found. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        } catch (IOException e) {
            System.err.println ("Error: IO exception. Exiting...");
            e.printStackTrace();
            System.exit(-1);
        }
        return null;
    }

    /**
     * Creates output as desired by the spec.
     */
    public static String makeOutput(Set<String> palindromes) {
        return palindromes.stream()
            .sorted((s1, s2) -> {
                return s1.compareTo(s2);
            })
            .collect(Collectors.joining(" "));
    }
}
