package Day2_2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RockPaperScissor {

    private final List<Hand> listPlayerOne = new ArrayList<>();
    private final List<Hand> listPlayerTwo = new ArrayList<>();
    private final List<Result> listResult = new ArrayList<>();

    Hand rock = new Rock();
    Hand paper = new Paper();
    Hand scissor = new Scissor();

    Result loss = new Loss();
    Result draw = new Draw();
    Result win = new Win();

    private final Path inputFilePath = Paths.get("./src/Day2_2/input.txt");

    public static void main(String[] args) {
        RockPaperScissor rps = new RockPaperScissor();
        rps.readFileToListInit();
        rps.generatePlayerTwo();
        int total = rps.getTotal();
        System.out.println("Total: " + total);
    }

    public void readFileToListInit() {
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
            String line = fileScanner.nextLine();
            char letterPlayerOne = line.charAt(0);
            char letterResult = line.charAt(2);
            if (letterPlayerOne == 'A')
                listPlayerOne.add(rock);
            else if (letterPlayerOne == 'B')
                listPlayerOne.add(paper);
            else
                listPlayerOne.add(scissor);
            if (letterResult == 'X')
                listResult.add(loss);
            else if (letterResult == 'Y')
                listResult.add(draw);
            else
                listResult.add(win);
        }
    }

    public void generatePlayerTwo() {
        for (int i = 0; i < listPlayerOne.size(); i++) {
            if (listResult.get(i).isLoss()) {
                if (listPlayerOne.get(i).isRock())
                    listPlayerTwo.add(scissor);
                else if (listPlayerOne.get(i).isPaper())
                    listPlayerTwo.add(rock);
                else
                    listPlayerTwo.add(paper);
            }
            if (listResult.get(i).isDraw()) {
                if (listPlayerOne.get(i).isRock())
                    listPlayerTwo.add(rock);
                else if (listPlayerOne.get(i).isPaper())
                    listPlayerTwo.add(paper);
                else
                    listPlayerTwo.add(scissor);
            }
            if (listResult.get(i).isWin()) {
                if (listPlayerOne.get(i).isRock())
                    listPlayerTwo.add(paper);
                else if (listPlayerOne.get(i).isPaper())
                    listPlayerTwo.add(scissor);
                else
                    listPlayerTwo.add(rock);
            }
        }
    }

    public int getTotal() {
        int total = 0;
        for (int i = 0; i < listPlayerOne.size(); i++) {
            total += getHandPlayerTwo(i).compareHands(getHandPlayerOne(i));
            total += getHandPlayerTwo(i).getValue();
        }
        return total;
    }
    public Hand getHandPlayerOne(int index) {
        return listPlayerOne.get(index);
    }

    public Hand getHandPlayerTwo(int index) {
        return listPlayerTwo.get(index);
    }

    public Result getResult(int index) {
        return listResult.get(index);
    }
}
