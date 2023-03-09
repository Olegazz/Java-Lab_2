import java.io.*;
import java.util.Scanner;

public class Main{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        try {
            System.out.println("Input path to the file to read and file to write: ");
            FileReader reader = new FileReader(in.nextLine());
            FileWriter writer = new FileWriter(in.nextLine());
            count(reader, writer);
        } catch (IOException e) {
            System.out.println("File with this name is not founded");
        }
    }

    /**
     *
     * @param inputStream The file to read
     * @param outputStream the file to write
     * @throws IOException If such a files does not exist
     */
    private static void count(FileReader inputStream, FileWriter outputStream) throws IOException {
        int upperCase = 0;
        int lowerCase = 0;

        try (Scanner scanner = new Scanner(inputStream);) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                for (int k = 0; k < line.length(); k++) {
                    if (Character.isUpperCase(line.charAt(k))){
                        upperCase++;
                    }
                    if (Character.isLowerCase(line.charAt(k))){
                        lowerCase++;
                    }
                }
            }
        }
        outputStream.write("Upper - " + upperCase + " Lower - " + lowerCase);
        outputStream.close();
    }
}