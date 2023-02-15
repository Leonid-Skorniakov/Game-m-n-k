package game;

public interface Board {
    Position getPosition();

    boolean makeMove(Move move, Cell turn);

    boolean checkWin(Move move);

    boolean checkDraw();
}
