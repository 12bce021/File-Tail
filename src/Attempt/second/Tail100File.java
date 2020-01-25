package Attempt.second;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Attempt_2
 * Performance - java Attempt.second.Tail100File  1.69s user 1.86s system 101% cpu 3.479 total
 * Actual - tail -100 bigFile.txt  0.00s user 0.00s system 78% cpu 0.007 total
 */
public class Tail100File {
    public static void main(String[] args) throws IOException {
        final RandomAccessFile randomAccessFile = new RandomAccessFile("./bigFile.txt", "r");
        final BufferedReader bufferedReader = new BufferedReader(new FileReader("bigFile.txt"));
        final long totalLines = bufferedReader.lines().count();
        final long printStartingLineNumber = totalLines - 100;

        try {
            long counter = 0;
            String line;
            while ((line = randomAccessFile.readLine()) != null) {
                if (printStartingLineNumber <= counter) {
                    System.out.println(line);
                }
                counter = counter + 1;
            }
        } catch (Exception e) {
            System.out.println("Some Exception Occurred :" + e);
        } finally {
            bufferedReader.close();
        }
    }
}
