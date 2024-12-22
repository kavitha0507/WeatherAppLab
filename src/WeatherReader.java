import java.io.File;
import java.io.FileNotFoundException;

import java.util.Scanner;
public class WeatherReader {
    public static void main(String[] args) {
        try {
            readAndProcessFile("src/Weather.txt");
        } catch (CustomFileException e) {
            System.out.println("Custom File Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("General Error: " + e.getMessage());
        }
    }


    public static void readAndProcessFile(String fileName) throws CustomFileException {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            processFileContents(scanner);
            scanner.close();
        } catch (FileNotFoundException e) {
            throw new CustomFileException("File not found: " + fileName);
        }
    }

    public static void processFileContents(Scanner scanner) throws CustomFileException {
        int lineNumber = 0;
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            lineNumber++;
            validateLine(line, lineNumber);
            System.out.println("Line " + lineNumber + ": " + line);
        }
    }

    public static void validateLine(String line, int lineNumber) throws CustomFileException {
        if (line.trim().isEmpty()) {
            throw new CustomFileException("Empty line found at line " + lineNumber);
        }
    }
}






        
    






















