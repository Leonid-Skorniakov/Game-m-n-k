package game;

public class MNKMove implements Move {
    private final int x;
    private final int y;

    public MNKMove(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public int getX() {
        return x;
    }

    @Override
    public int getY() {
        return y;
    }
}
