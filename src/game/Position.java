package game;

public interface Position {
    Cell getCell(int x, int y);

    int getLength();

    int getWidth();
}
