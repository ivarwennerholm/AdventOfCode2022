package Day3_2;

public class Elf implements Printable{
    Rucksack rucksack;

    Elf(Rucksack rucksack) {
        this.rucksack = rucksack;
    }

    public Rucksack getRucksack() {
        return this.rucksack;
    }

    public String toString() {
        return ("Elf");
    }

    @Override
    public String printMe(int index) {
        return ("Elf number " + (index + 1) + " carrying ");
    }

    @Override
    public String printMe() {
        return "Elf";
    }
}
