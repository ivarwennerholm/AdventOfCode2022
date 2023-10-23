package Day3_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RucksackContent {

    private final ArrayList<GroupOfThree> groupOfThreeList = new ArrayList<>();
    private final Path inputFilePath = Paths.get("./src/Day3_2/input.txt");
    private final String priorities = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static void main(String[] args) {
        RucksackContent rsc = new RucksackContent();
        rsc.readFileToListInit();
        System.out.println("Sum of priorities = " + rsc.getPrioritiesSum());
    }

    public void readFileToListInit() {
        try (BufferedReader fileReader = new BufferedReader(new FileReader(String.valueOf(inputFilePath)))) {
            Scanner fileScanner = new Scanner(fileReader);
            readFileToList(fileScanner);
        } catch (FileNotFoundException e) {
            System.out.println("FEL: kan inte hitta filen " + inputFilePath);
        } catch (IOException e) {
            System.out.println("FEL: Input/Output för filen " + inputFilePath);
        }
    }

    public void readFileToList(Scanner fileScanner) {
        String line1, line2, line3;
        GroupOfThree groupOfThree;
        Elf elf1, elf2, elf3;
        Rucksack rucksack1, rucksack2, rucksack3;
        while (fileScanner.hasNextLine()) {
            line1 = fileScanner.nextLine();
            if (line1.isEmpty())
                break;
            line2 = fileScanner.nextLine();
            line3 = fileScanner.nextLine();
            rucksack1 = new Rucksack(line1);
            rucksack2 = new Rucksack(line2);
            rucksack3 = new Rucksack(line3);
            elf1 = new Elf(rucksack1);
            elf2 = new Elf(rucksack2);
            elf3 = new Elf(rucksack3);
            groupOfThree = new GroupOfThree(elf1, elf2, elf3);
            groupOfThreeList.add(groupOfThree);
        }
    }

    public int getPrioritiesSum() {
        int sum = 0;
        for (GroupOfThree got : groupOfThreeList) {
            for (int i = 0; i < priorities.length(); i++) {
                String item = String.valueOf(priorities.charAt(i));
                if ((got.getElf1().getRucksack().getContents().contains(item)) &&
                        (got.getElf2().getRucksack().getContents().contains(item)) &&
                        (got.getElf3().getRucksack().getContents().contains(item))) {
                    sum += priorities.indexOf(item) + 1;
                }
            }
        }
        return sum;
    }

    public void printList() {
        String output = "";
        int index = 0;
        for (GroupOfThree got: groupOfThreeList) {
            output = output + (got.printMe(index) + "\n" +
                    "\t" + got.getElf1().printMe(0) + got.getElf1().getRucksack().printMe() + "\n" +
                    "\t" + got.getElf2().printMe(1) + got.getElf2().getRucksack().printMe() + "\n" +
                    "\t" + got.getElf3().printMe(2) + got.getElf3().getRucksack().printMe() + "\n");
            index++;
        }
        System.out.println(output);
    }

    public ArrayList<GroupOfThree> getGroupOfThreeList() {
        return this.groupOfThreeList;
    }
}
