package Day2_2;

public class Loss extends Result {

    @Override
    public boolean isLoss() {
        return true;
    }

    @Override
    public boolean isDraw() {
        return false;
    }

    @Override
    public boolean isWin() {
        return false;
    }
}
