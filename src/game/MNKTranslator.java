package game;

import java.util.Map;

public class MNKTranslator implements Translator{
    private final Map<Cell, Character> translationMap = Map.of(
        Cell.EMPTY, '.',
        Cell.X, 'X',
        Cell.O, '0',
        Cell.BLOCKED, '#'
    );

    @Override
    public char getSymbol(Cell cell) {
        return translationMap.get(cell);
    }
}
