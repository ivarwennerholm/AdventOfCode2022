package Day1_1;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class Day1_1 {

    private final Path inputFilePath = Paths.get("./src/Day1/input.txt");
    private final ArrayList<Elf> elfList = new ArrayList<>();

    public static void main(String[] args) {
        Day1_1 day11 = new Day1_1();
        day11.createFileReader();
        System.out.println("Maximum calories carried = " + day11.getMaximumCarriedCalories());
    }

    public void createFileReader() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(String.valueOf(inputFilePath)))) {
            Scanner fileScanner = new Scanner(fileReader);
            readFileToList(fileScanner);
        } catch (FileNotFoundException e) {
            System.out.println("FEL: hittar inte filen " + inputFilePath);
        } catch (IOException e) {
            System.out.println("FEL: Input/Output för filen " + inputFilePath);
        }
    }

    public void readFileToList(Scanner fileScanner) {
        while (fileScanner.hasNextLine()) {
            int calories = 0;
            while (fileScanner.hasNextLine()) {
                String line = fileScanner.nextLine();
                if (line.trim().isEmpty()) {
                    break;
                }
                Scanner lineScanner = new Scanner(line);
                while (lineScanner.hasNextInt()) {
                    calories += lineScanner.nextInt();
                }
            }
            Elf elf = new Elf(calories);
            elfList.add(elf);
        }
    }

    public int getMaximumCarriedCalories() {
        int maximum = -Integer.MAX_VALUE;
        for (Elf elf : elfList) {
            if (elf.getCarriedCalories() > maximum) {
                maximum = elf.getCarriedCalories();
            }
        }
        return maximum;
    }
}