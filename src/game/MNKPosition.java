package game;

public class MNKPosition implements Position{
    private final Cell[][] board;

    public MNKPosition(Cell[][] board) {
        this.board = board;
    }

    @Override
    public Cell getCell(int x, int y) {
        if ( (x >= 0) && (x < board.length) && (y >= 0) && (y < board[0].length)) {
            return board[x][y];
        }
        return Cell.UNKNOW;
    }

    @Override
    public int getLength() {
        return board.length;
    }

    @Override
    public int getWidth() {
        return board[0].length;
    }
}
