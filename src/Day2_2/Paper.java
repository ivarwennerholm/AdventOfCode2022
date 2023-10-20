package Day2_2;

public class Paper extends Hand {
    private final int value = 2;

    @Override
    public int getValue() {
        return this.value;
    }

    @Override
    public int compareHands(Hand hand) {
        if (hand.isRock())
            return 6;
        else if (hand.isPaper())
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
        return true;
    }

    @Override
    public boolean isScissor() {
        return false;
    }
}
