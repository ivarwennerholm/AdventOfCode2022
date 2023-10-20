package Day1_2;

public class Elf implements Comparable<Elf> {
    private final int carriedCalories;

    Elf(int carriedCalories) {
        this.carriedCalories = carriedCalories;
    }

    public int getCarriedCalories() {
        return this.carriedCalories;
    }

    @Override
    public int compareTo(Elf elf) {
        return (this.carriedCalories - elf.carriedCalories);
    }
}
