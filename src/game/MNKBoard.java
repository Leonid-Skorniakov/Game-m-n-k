package game;

import java.util.Arrays;

public class MNKBoard implements Board{
    private final Cell[][] board;

    private final int m;
    private final int n;
    private final int k;

    private int filled;

    MNKBoard(int m, int n, int k) {
        this.m = Math.max(m, 1);
        this.n = Math.max(n, 1);
        this.k = Math.max(k, 1);

        board = new Cell[this.m][this.n];
        for (Cell[] row : board) {
            Arrays.fill(row, Cell.EMPTY);
        }
        filled = 0;
    }

    @Override
    public Position getPosition() {
        return new MNKPosition(board);
    }

    @Override
    public boolean makeMove(Move move, Cell turn){
        int x = move.getX();
        int y = move.getY();
        if ((x >= 0) && (x < m) && (y >= 0) && (y < n) && (board[x][y] == Cell.EMPTY)) {
            board[x][y] = turn;
            filled++;
            return true;
        }
        return false;
    }

    @Override
    public boolean checkWin(Move move) {
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if ((dx != 0 || dy != 0) && checkLine(move, dx, dy)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(Move move, int dx, int dy) {
        int x = move.getX();
        int y = move.getY();
        Cell turn = board[x][y];
        int maxLine = 0;
        int currentLine = 0;
        for (int i = 1 - k; i < k; i++) {
            int new_x = x + i*dx;
            int new_y = y + i*dy;
            if ((new_x < 0) || (new_x >= m) || (new_y < 0) || (new_y >= n)) {
                continue;
            }
            if (board[new_x][new_y] == turn) {
                currentLine++;
                maxLine = Math.max(maxLine, currentLine);
            } else {
                currentLine = 0;
            }
        }
        return maxLine >= k;
    }

    @Override
    public boolean checkDraw() {
        return (filled == (m * n));
    }

    public void blockDiagonals() {
        for (int x = 0; x < Math.min(m,n); x++) {
            board[x][x] = Cell.BLOCKED;
            filled ++;
            if (x != (Math.min(m,n) - x - 1)) {
                board[x][Math.min(m,n) - x - 1] = Cell.BLOCKED;
                filled++;
            }
        }
    }


}
