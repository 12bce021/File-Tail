package Attempt.third;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * Attempt_3
 * Performance - java Attempt.third.Tail100File  0.45s user 0.07s system 141% cpu 0.367 total
 * Actual - tail -100 bigFile.txt  0.00s user 0.00s system 78% cpu 0.007 total
 */
public class Tail100File {
    public static void main(String[] args) throws IOException {
        final Stream<String> lines = Files.lines(Paths.get("./bigFile.txt"));
        final BufferedReader bufferedReader = new BufferedReader(new FileReader("./bigFile.txt"));
        final long totalLines = bufferedReader.lines().count();
        final long printStartingLineNumber = totalLines - 100;
        try {
            lines.skip(printStartingLineNumber).forEach(System.out::println);
        } catch (Exception e) {
            System.out.println("Some Exception Occurred :" + e);
        } finally {
            bufferedReader.close();
            lines.close();
        }
    }
}
