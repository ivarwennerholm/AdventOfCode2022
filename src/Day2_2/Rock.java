package Day2_2;

public class Rock extends Hand implements CompareHands {

    private final int value = 1;

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public int compareHands(Hand hand) {
        if (hand.isScissor())
            return 6;
        if (hand.isRock())
            return 3;
        else
            return 0;
    }

    @Override
    public boolean isRock() {
        return true;
    }

    @Override
    public boolean isPaper() {
        return false;
    }

    @Override
    public boolean isScissor() {
        return false;
    }
}
