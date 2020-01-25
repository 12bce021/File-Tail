import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Attempt_1
 * https://docs.oracle.com/javase/tutorial/essential/io/
 * Performance - java Tail100File_Attempt_1  2.67s user 3.55s system 99% cpu 6.230 total
 * Actual - tail -100 bigFile.txt  0.00s user 0.00s system 78% cpu 0.007 total
 */
public class Tail100File_Attempt_1 {
    public static void main(String[] args) throws IOException {
        final RandomAccessFile firstPointer = new RandomAccessFile("./bigFile.txt", "r");
        final RandomAccessFile secondPointer = new RandomAccessFile("./bigFile.txt", "r");
        long numberOfLines = 100;
        String line;
        try {
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
