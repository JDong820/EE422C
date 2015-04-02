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
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


class Main {

    public static void main(String[] args) {
        final int COUNT = 1000000000;
        final int MAX = 2147483647;
        final Random rand = new Random(15485863);
        ArrayList<Integer> data = new ArrayList(
                Arrays.stream(new Random()
                    .ints(COUNT, 0, MAX+1)
                    .toArray())
                .boxed()
                .collect(Collectors.toList()));
    }

    public static String[] readInput() throws IOException {
        Path path = Paths.get(System.getProperty("user.dir"), "input.txt");
        try(Stream<String> lines = Files.lines(path)){
            return (String[])lines.toArray();
        }
    }
}


