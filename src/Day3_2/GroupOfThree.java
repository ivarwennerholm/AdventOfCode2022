package Day3_2;

public class GroupOfThree implements Printable{

    private Elf elf1, elf2, elf3;

    GroupOfThree(Elf elf1, Elf elf2, Elf elf3) {
        this.elf1 = elf1;
        this.elf2 = elf2;
        this.elf3 = elf3;
    }

    public Elf getElf1() {
        return this.elf1;
    }

    public Elf getElf2() {
        return this.elf2;
    }

    public Elf getElf3() {
        return this.elf3;
    }

    @Override
    public String toString() {
        return ("Group of Three");
    }

    @Override
    public String printMe(int index) {
        return ("Group of Three number " + (index + 1) + " with:");
    }

    @Override
    public String printMe() {
        return "Group of Three";
    }
}
