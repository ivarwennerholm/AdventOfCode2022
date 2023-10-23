package Day3_2;

public class Rucksack implements Printable {
    private String contents;

    public Rucksack(String contents) {
        this.contents = contents;
    }

    public String getContents() {
        return this.contents;
    }

    @Override
    public String printMe(int index) {
        return "Rucksack with index" + index;
    }

    @Override
    public String printMe() {
        return ("rucksack containing: " + this.contents);
    }
}
