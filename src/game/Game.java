package game;

public class Game {
    private final Player player1;
    private final Player player2;

    private final Board board;
    private final Output out;

    public Game(Player player1, Player player2, Board board, Output out) {
        this.player1 = player1;
        this.player2 = player2;
        this.board = board;
        this.out = out;
    }

    public int play() {
        int turn = 1;
        out.println("");
        out.printPosition(board.getPosition());
        while (true) {
            Result result;
            if (turn == 1) {
                result = makeMove(player1, Cell.X); 
            } else {
                result = makeMove(player2, Cell.O);
            }
            switch (result) {
                case WIN -> {
                    return turn;
                }
                case DRAW -> {
                    return 0;
                }
                case LOSE -> {
                    return 3 - turn;
                }
                default -> {}                
            }
            turn = 3 - turn;
        }
    }

    private Result makeMove(Player player, Cell turn) {
        try {
            Move move = player.makeMove(board.getPosition());
            if (board.makeMove(move, turn)) {
                out.printPosition(board.getPosition());
                out.printMove(move, turn);
                if (board.checkWin(move)) {
                    return Result.WIN;
                } else if (board.checkDraw()) {
                    return Result.DRAW;
                } else {
                    return Result.UNKNOW;
                }
            }
            return Result.LOSE;
        } catch (Exception e) {
            out.printException(e);
            return Result.LOSE;
        }
        
    }
}
