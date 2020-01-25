package Attempt.first;

import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Attempt_1
 * https://docs.oracle.com/javase/tutorial/essential/io/
 * Performance - java Attempt.first.Tail100File  2.67s user 3.61s system 98% cpu 6.395 total
 * Actual - tail -100 bigFile.txt  0.00s user 0.00s system 78% cpu 0.007 total
 */
public class Tail100File {
    public static void main(String[] args) throws IOException {
        final RandomAccessFile firstPointer = new RandomAccessFile("./bigFile.txt", "r");
        final RandomAccessFile secondPointer = new RandomAccessFile("./bigFile.txt", "r");
        String line;
        try {
            long numberOfLines = 100;
            while (numberOfLines > 0) {
                firstPointer.readLine();
                numberOfLines -= 1;
            }
            while (firstPointer.readLine() != null) {
                secondPointer.readLine();
            }
            while ((line = secondPointer.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("Some Exception Occurred :" + e);
        } finally {
            firstPointer.close();
            secondPointer.close();
        }
    }
}
