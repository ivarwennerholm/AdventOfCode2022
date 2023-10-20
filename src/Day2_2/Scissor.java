package Day2_2;

public class Scissor extends Hand{
    private final int value = 3;

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public int compareHands(Hand hand) {
        if (hand.isPaper())
            return 6;
        else if (hand.isScissor())
            return 3;
        else
            return 0;
    }

    @Override
    public boolean isRock() {
        return false;
    }

    @Override
    public boolean isPaper() {
        return false;
    }

    @Override
    public boolean isScissor() {
        return true;
    }
}
