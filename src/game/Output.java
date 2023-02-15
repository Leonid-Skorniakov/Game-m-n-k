package game;

public interface Output {
    void println(String str);

    void printPosition(Position position);

    void printMove(Move move, Cell turn);

    void printException(Exception e);
}
