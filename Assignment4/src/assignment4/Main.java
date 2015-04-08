/* Joshua Dong (jid295)
 *
 * Xavier Salazar
 * section 16005
 */

package assignment4;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.Set;

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


class Main
{
	static int COUNT = 1000000;
	static int MAX_VAL = Integer.MAX_VALUE;
	static boolean doDebug = false;
	static String FILENAME = "input.txt";

	public static void main(String[] args)
	{
		if (args.length == 1)
		{
			FILENAME = args[0];
		}

		Random rand = new Random(15485863);
		ArrayList<Integer> data = new ArrayList(
		    Arrays.stream(new Random()
		                  .ints(COUNT, 1, MAX_VAL)
		                  .toArray())
		    .boxed()
		    .collect(Collectors.toList()));

		if (doDebug)
		{
			debug(data);
		}

		try
		{
			experiment1(data);
			experiment2(data);
			experiment3(data);
			experiment4(data);
			experiment5(data);
			experiment6(data);
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}

	// Returns index of target in sortedList, or -1 if not found.
	public static int interpolationSearch(List<Integer> sortedList,
	                                      Integer target)
	{
		int low = 0;
		int high = sortedList.size() - 1;
		int mid;

		while (sortedList.get(low) <= target &&
		        sortedList.get(high) >= target)
		{
			mid = low +
			      ((target - sortedList.get(low)) * (high - low)) /
			      (sortedList.get(high) - sortedList.get(low));

			if (sortedList.get(mid) < target)
			{
				low = mid + 1;
			}
			else if (sortedList.get(mid) > target)
			{
				high = mid - 1;
			}
			else
			{
				return mid;
			}
		}

		if (sortedList.get(low) == target)
		{
			return low;
		}
		else
		{
			return -1; // Not found
		}
	}

	public static void makeOutput(int n, long found, long notFound,
	                              long invalidCount, StopWatch watch)
	{
		System.out.println("Experiment " + n + ":"
		                   + "\nNumber of found values: " + found
		                   + "\nNumber of values not found: " + notFound
		                   + "\nNumber of illegal values in input file: " + invalidCount
		                   + "\nTime elapsed in nanoseconds is: "
		                   + watch.getElapsedNanoseconds()
		                   + "\nTime elapsed in seconds is: "
		                   + watch.getElapsedSeconds());
	}

	public static void makeOutput(int n, StopWatch watch)
	{
		System.out.println("Experiment " + n + ":"
		                   + "\nTime elapsed in nanoseconds is: "
		                   + watch.getElapsedNanoseconds()
		                   + "\nTime elapsed in seconds is: "
		                   + watch.getElapsedSeconds());
	}

	public static Integer s2i(String s)
	{
		try
		{
			Integer value = Integer.parseInt(s);
			return value > 0 ? value : null;
		}
		catch (NumberFormatException e)
		{
			return null;
		}
	}

	public static List<Integer> readInput() throws IOException
	{
		Path path = Paths.get(System.getProperty("user.dir"), FILENAME);
		try (Stream<String> lines = Files.lines(path))
		{
			return lines
			       .map(s -> s2i(s))
			       .collect(Collectors.toList());
		}
	}

	/* For all the values on the disk file, note the total number of values
	 * found, and the total number of values not found, and the number of
	 * illegal values not searched for. Use an ArrayList.
	 *
	 * Using a Stopwatch object (provided class on the web page) you are to
	 * measure and report the total time spent on searching for these values
	 * (not including the I/O time to read or report). Close the disk file
	 * when done.
	 */
	public static void experiment1(ArrayList<Integer> data)
	throws IOException
	{
		List<Integer> raw = readInput();
		long invalidCount = raw
		                    .stream()
		                    .filter(i -> i == null)
		                    .count();
		List<Integer> targets = raw
		                        .stream()
		                        .filter(i -> i != null)
		                        .collect(Collectors.toList());
		int count = 0;
		StopWatch watch = new StopWatch();

		for (Integer target: targets)
		{
			watch.start();
			boolean isContained = data.contains(target);
			watch.stop();
			if (isContained)
			{
				++count;
			}
		}

		makeOutput(1, count, targets.size() - count, invalidCount, watch);
	}

	/* For all the values on the disk file, note the total number of values
	 * found, and the total number of values not found, and the number of
	 * illegal values not searched for. Use a LinkedList.
	 *
	 * Using a Stopwatch object (provided class on the web page) you are to
	 * measure and report the total time spent on searching for these values
	 * (not including the I/O time to read or report). Close the disk file
	 * when done.
	 */
	public static void experiment2(ArrayList<Integer> data)
	throws IOException
	{
		List<Integer> raw = readInput();
		long invalidCount = raw
		                    .stream()
		                    .filter(i -> i == null)
		                    .count();
		List<Integer> targets = raw
		                        .stream()
		                        .filter(i -> i != null)
		                        .collect(Collectors.toList());
		int count = 0;
		StopWatch watch = new StopWatch();
		LinkedList<Integer> newData = new LinkedList(data);

		for (Integer target: targets)
		{
			watch.start();
			boolean isContained = newData.contains(target);
			watch.stop();
			if (isContained)
			{
				++count;
			}
		}

		makeOutput(2, count, targets.size() - count, invalidCount, watch);
	}

	// Sort a list. Time it.
	public static void experiment3(ArrayList<Integer> data)
	throws IOException
	{
		StopWatch watch = new StopWatch();

		watch.start();
		Collections.sort(data);
		watch.stop();

		makeOutput(3, watch);
	}

	/* Use binary search. Time it.
	 */
	public static void experiment4(ArrayList<Integer> data)
	throws IOException
	{
		List<Integer> raw = readInput();
		long invalidCount = raw
		                    .stream()
		                    .filter(i -> i == null)
		                    .count();
		List<Integer> targets = raw
		                        .stream()
		                        .filter(i -> i != null)
		                        .collect(Collectors.toList());
		int count = 0;
		StopWatch watch = new StopWatch();
		Collections.sort(data);

		for (Integer target: targets)
		{
			watch.start();
			int binaryResult = Collections.binarySearch(data, target);
			watch.stop();
			if (binaryResult >= 0)
			{
				++count;
			}
		}

		makeOutput(4, count, targets.size() - count, invalidCount, watch);
	}

	/* Use interpolation search. Time it.
	 */
	public static void experiment5(ArrayList<Integer> data)
	throws IOException
	{
		List<Integer> raw = readInput();
		long invalidCount = raw
		                    .stream()
		                    .filter(i -> i == null)
		                    .count();
		List<Integer> targets = raw
		                        .stream()
		                        .filter(i -> i != null)
		                        .collect(Collectors.toList());
		int count = 0;
		StopWatch watch = new StopWatch();

		for (Integer target: targets)
		{
			watch.start();
			int interpolationResult = interpolationSearch(data, target);
			watch.stop();
			if (interpolationResult >= 0)
			{
				++count;
			}
		}

		makeOutput(5, count, targets.size() - count, invalidCount, watch);
	}

	/* Use the ArrayList of values to create a HashMap instance with a 50%
	 * load factor and an appropriate initial capacity. Next reopen the file
	 * on disk, and again process each value in turn, searching the HashMap
	 * for the given value. Measure and report the total time spent on
	 * searching for these values (not including I/O time to read or report).
	 */
	public static void experiment6(ArrayList<Integer> data)
	throws IOException
	{
		HashMap<Integer, Integer> hash =
		    new HashMap<Integer, Integer>(data.size(), 0.5f);
		List<Integer> raw = readInput();
		long invalidCount = raw
		                    .stream()
		                    .filter(i -> i == null)
		                    .count();
		List<Integer> targets = raw
		                        .stream()
		                        .filter(i -> i != null)
		                        .collect(Collectors.toList());
		int count = 0;
		StopWatch watch = new StopWatch();
		for (Integer i: data)
		{
			hash.put(i, 0);
		}

		for (Integer i: targets)
		{
			watch.start();
			boolean keyContained = hash.containsKey(i);
			watch.stop();
			if (keyContained)
			{
				hash.put(i, hash.get(i)+1);
				count++;
			}
		}

		makeOutput(6, count, targets.size() - count, invalidCount, watch);
	}

	public static void debug(ArrayList<Integer> data)
	{
		for (Integer i: data)
		{
			System.out.print(i + ", ");
		}
		System.out.print("\n");
	}
}
