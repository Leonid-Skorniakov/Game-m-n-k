package game;

public class MNKSequentialPlayer implements Player {
    @Override
    public Move makeMove(Position position) {
        for (int x = 0; x < position.getLength(); x++) {
            for (int y = 0; y < position.getWidth(); y++) {
                if (position.getCell(x, y) == Cell.EMPTY) {
                    return new MNKMove(x, y);
                }
            }
        }
        throw new AssertionError("No valid moves");
    }
}
