/* Joshua Dong (jid295)
 *
 * Xavier Salazar
 * section 16005
 */

package assignment4;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Set;
import java.util.LinkedList;
import java.util.List;

//import java.util.HashMap;
//import java.util.Map.Entry;
//import static java.util.stream.Collectors.toMap;

import java.util.Collections;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.lang.NumberFormatException;


class Main {
    static int COUNT = 1000000000;
    static boolean doDebug = false;

    public static void main(String[] args) {
        if (args.length == 1) {
            COUNT = Integer.parseInt(args[0]);
        }
        if (args.length == 2) {
            COUNT = Integer.parseInt(args[0]);
            doDebug = true;
        }

        Random rand = new Random(15485863);
        ArrayList<Integer> data = new ArrayList(
                Arrays.stream(new Random()
                    .ints(COUNT, 1, Integer.MAX_VALUE)
                    .toArray())
                .boxed()
                .collect(Collectors.toList()));
        //HashMap<Integer, Object> h = data
        //    .stream()
        //    .collect(Collectors.toMap(d -> 0, d -> null));
        if (doDebug) {
            debug(data);
        }

        try {
            experiment1(data);
            experiment2(data);
            experiment3(data);
            experiment4(data);
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    
    public static void makeOutput(int n, long found, long notFound,
            long invalidCount, StopWatch watch) {
        System.out.println("Experiment " + n + ":"
                + "\nNumber of found values: " + found
                + "\nNumber of values not found: " + notFound
                + "\nNumber of illegal values in input file: " + invalidCount
                + "\nTime elapsed in nanoseconds is: "
                + watch.getElapsedNanoseconds()
                + "\nTime elapsed in seconds is: " 
                + watch.getElapsedSeconds());
    }

    public static void makeOutput(int n, StopWatch watch) {
        System.out.println("Experiment " + n + ":"
                + "\nTime elapsed in nanoseconds is: "
                + watch.getElapsedNanoseconds()
                + "\nTime elapsed in seconds is: " 
                + watch.getElapsedSeconds());
    }
   
    public static Integer s2i(String s) {
        try {
            Integer value = Integer.parseInt(s);
            return value > 0 ? value : null;
        } catch (NumberFormatException e) {
            return null;
        }
    }

    public static List<Integer> readInput() throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), "input.txt");
        try (Stream<String> lines = Files.lines(path)){
            return lines
                .map(s -> s2i(s))
                .collect(Collectors.toList());
        }
    }

    /* For all the values on the disk file, note the total number of values
     * found, and the total number of values not found, and the number of
     * illegal values not searched for.
     *
     * Using a Stopwatch object (provided class on the web page) you are to
     * measure and report the total time spent on searching for these values
     * (not including the I/O time to read or report). Close the disk file
     * when done.
     */
    public static void experiment1(ArrayList<Integer> data)
        throws IOException {
        List<Integer> raw = readInput();
        long invalidCount = raw
            .stream()
            .filter(i -> i == null)
            .count();
        Set<Integer> targets = raw
            .stream()
            .filter(i -> i != null)
            .collect(Collectors.toSet());
        int count = 0;
        StopWatch watch = new StopWatch();

        watch.start();
        for (Integer target: targets) {
            if (data.contains(target)) {
                ++count;
            }
        }
        watch.stop();
        
        makeOutput(1, count, targets.size() - count, invalidCount, watch);
    }

    public static void experiment2(ArrayList<Integer> data)
        throws IOException {
        List<Integer> raw = readInput();
        long invalidCount = raw
            .stream()
            .filter(i -> i == null)
            .count();
        Set<Integer> targets = raw
            .stream()
            .filter(i -> i != null)
            .collect(Collectors.toSet());
        int count = 0;
        StopWatch watch = new StopWatch();
        LinkedList<Integer> newData = new LinkedList(data);

        watch.start();
        for (Integer target: targets) {
            if (newData.contains(target)) {
                ++count;
            }
        }
        watch.stop();
        
        makeOutput(2, count, targets.size() - count, invalidCount, watch);
    }

    public static void experiment3(ArrayList<Integer> data)
        throws IOException {
        StopWatch watch = new StopWatch();

        watch.start();
        Collections.sort(data);
        watch.stop();
        
        makeOutput(3, watch);
    }

    public static void experiment4(ArrayList<Integer> data)
        throws IOException {
        List<Integer> raw = readInput();
        long invalidCount = raw
            .stream()
            .filter(i -> i == null)
            .count();
        Set<Integer> targets = raw
            .stream()
            .filter(i -> i != null)
            .collect(Collectors.toSet());
        int count = 0;
        StopWatch watch = new StopWatch();
        Collections.sort(data);

        watch.start();
        for (Integer target: targets) {
            if (Collections.binarySearch(data, target) >= 0) {
                ++count;
            }
        }
        watch.stop();
        
        makeOutput(4, count, targets.size() - count, invalidCount, watch);
    }

    public static <T> int interpolationSearch(List<T> list, <T> target) {
        int index = 0;
        return index - 1;
    }

    public static void experiment5(ArrayList<Integer> data)
        throws IOException {
        List<Integer> raw = readInput();
        long invalidCount = raw
            .stream()
            .filter(i -> i == null)
            .count();
        Set<Integer> targets = raw
            .stream()
            .filter(i -> i != null)
            .collect(Collectors.toSet());
        int count = 0;
        StopWatch watch = new StopWatch();

        watch.start();
        for (Integer target: targets) {
            if (interpolationSearch(data, target) >= 0) {
                ++count;
            }
        }
        watch.stop();
        
        makeOutput(4, count, targets.size() - count, invalidCount, watch);
    }

    public static void debug(ArrayList<Integer> data) {
        for (Integer i: data) {
            System.out.print(i + ", ");
        }
        System.out.print("\n");
    }
}


