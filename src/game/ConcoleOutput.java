package game;

public class ConcoleOutput implements Output{
    private final MNKTranslator translator = new MNKTranslator();

    @Override
    public void println(String str) {
        System.out.println(str);
    }

    @Override
    public void printPosition(Position position) {
        System.out.println(usualOut(position));
    }
    
    @Override
    public void printMove(Move move, Cell turn) {
        System.out.printf("'%c' makes move: %d %d \n\n", translator.getSymbol(turn), move.getX() + 1, move.getY() + 1);
    }

    @Override
    public void printException(Exception e) {
        System.out.println("Player error: ");
        e.printStackTrace();
    }

    private String usualOut(Position position) {
        StringBuilder sb = new StringBuilder();
        for (int x = 0; x < position.getLength(); x++) {
            for (int y = 0; y < position.getWidth(); y++) {
                sb.append(translator.getSymbol(position.getCell(x, y)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
