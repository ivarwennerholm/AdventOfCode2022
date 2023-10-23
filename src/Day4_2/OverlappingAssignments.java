package Day4_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class OverlappingAssignments {

    private final Path inputFilePath = Paths.get("./src/Day4_2/input.txt");
    private final ArrayList<Assignment> firstAssignmentList = new ArrayList<>();
    private final ArrayList<Assignment> secondAssignmentList = new ArrayList<>();

    public static void main(String[] args) {
        OverlappingAssignments oa = new OverlappingAssignments();
        oa.readFileInit();
        System.out.println("Sum of overlapping intervals: " + oa.getTotalOverlappingIntervals());
    }

    public void readFileInit() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(String.valueOf(inputFilePath)))) {
            Scanner fileScanner = new Scanner(fileReader);
            readFile(fileScanner);
        } catch (FileNotFoundException e) {
            System.out.println("FEL: kan inte läsa filen " + inputFilePath);
        } catch (IOException e) {
            System.out.println("FEL: I/O för filen " + inputFilePath);
        }
    }

    public void readFile(Scanner fileScanner) {
        String line;
        int firstNumber, lastNumber;
        Scanner lineScanner;
        while (fileScanner.hasNextLine()) {
            line = fileScanner.nextLine();
            if (line.isEmpty()) {
                break;
            }
            lineScanner = new Scanner(line);
            lineScanner.useDelimiter("-|,|\\n");
            firstNumber = lineScanner.nextInt();
            lastNumber = lineScanner.nextInt();
            firstAssignmentList.add(new Assignment(firstNumber, lastNumber));
            firstNumber = lineScanner.nextInt();
            lastNumber = lineScanner.nextInt();
            secondAssignmentList.add(new Assignment(firstNumber, lastNumber));
        }
    }

    public int getTotalOverlappingIntervals() {
        int sum = 0;
        Assignment firstAssignment, secondAssignment;
        for (int i = 0; i < firstAssignmentList.size(); i++) {
            firstAssignment = firstAssignmentList.get(i);
            secondAssignment = secondAssignmentList.get(i);
            if (firstAssignment.isOverlapping(secondAssignment) || secondAssignment.isOverlapping(firstAssignment))
                sum += 1;
        }
        return sum;
    }

}