package Day2_2;

public class Win extends Result {

    @Override
    public boolean isLoss() {
        return false;
    }

    @Override
    public boolean isDraw() {
        return false;
    }

    @Override
    public boolean isWin() {
        return true;
    }
}
