package Day2_2;

public class Draw extends Result{

    @Override
    public boolean isLoss() {
        return false;
    }

    @Override
    public boolean isDraw() {
        return true;
    }

    @Override
    public boolean isWin() {
        return false;
    }
}
