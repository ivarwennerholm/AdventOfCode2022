package Day2_2;

public abstract class Hand implements CompareHands {

    public abstract int getValue();
    public abstract boolean isRock();
    public abstract boolean isPaper();
    public abstract boolean isScissor();
}