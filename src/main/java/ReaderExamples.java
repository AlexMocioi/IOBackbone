import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class ReaderExamples {
    public static final String CSV_SEPARATOR = ",";

    public static void main(String[] args) {
        testFileReader();
        testCsvReader();
    }

    private static void testCsvReader() {
        try (FileReader fr = new FileReader("basic.csv");
             BufferedReader br = new BufferedReader(fr);) {

            String csvHeaderLine = br.readLine();
            System.out.println(csvHeaderLine);

            String csvContentLine = br.readLine();
            while (csvContentLine != null) {

                String[] valuesInCsvLine = csvContentLine.split(CSV_SEPARATOR);
                for (int i=0; i<valuesInCsvLine.length; i++) {
                    System.out.println(valuesInCsvLine[i]);
                }
                System.out.println("Moving to next line");

                csvContentLine = br.readLine();
            }

        } catch (FileNotFoundException fnfe) {
            System.err.println("File at path basic.txt do not exist!");
        } catch (IOException ioe) {
            System.err.println("General error accesing data in basic.txt");
        }
    }

    private static void testFileReader() {
        try (FileReader fr = new FileReader("basic.txt");
             BufferedReader br = new BufferedReader(fr);) {

            int inputChar = br.read();;
            while (inputChar != -1) {

                System.out.println((char)inputChar);

                inputChar = br.read();
            }

        } catch (FileNotFoundException fnfe) {
            System.err.println("File at path basic.txt do not exist!");
        } catch (IOException ioe) {
            System.err.println("General error accesing data in basic.txt");
        }
    }
}
