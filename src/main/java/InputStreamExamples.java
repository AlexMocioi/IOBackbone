import java.io.*;

public class InputStreamExamples {
    public static void main(String[] args) {
        testWrappingWithBuffer();
    }

    private static void testWrappingWithBuffer() {
        try (InputStream fis = new FileInputStream("basic.txt");
            InputStream iStream = new BufferedInputStream(fis);) {

            int inputByte = iStream.read();;
            while (inputByte != -1) {

                System.out.println(inputByte);

                inputByte = iStream.read();
            }

        } catch (FileNotFoundException fnfe) {
            System.err.println("File at path basic.txt do not exist!");
        } catch (IOException ioe) {
            System.err.println("General error accesing data in basic.txt");
        }
    }
}
