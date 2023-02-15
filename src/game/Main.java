package game;

public class Main {
    public static void main(String[] args) {
        Output out = new ConcoleOutput();

        int m = 11;
        int n = 11;
        int k = 3;

        MNKBoard board = new MNKBoard(m, n, k);
        board.blockDiagonals();
        Player player1 = new MNKHumanPlayer(out);
        Player player2 = new MNKSequentialPlayer();
        Game game = new Game(player1, player2, board, out);
        startGame(game, out);

        m = 5;
        n = 5;
        k = 3;
        Player[] listOfPlayers = new Player[]{ new MNKHumanPlayer(out), new MNKSequentialPlayer(), new MNKSequentialPlayer()};
        MNKTournament tournament = new MNKTournament(m, n, k, listOfPlayers, out);

        tournament.start();         // This start tournament
    }

    private static void startGame(Game game, Output out) {
        int n = game.play();
        switch (n) {
            case 1 -> {
                out.println("First Player Win");
            }
            case 2 -> {
                out.println("Second Player Win");
            }
            case 0 -> {
                out.println("Draw");
            }
            default -> {
                out.println("Error");
            }
        }
    }
}
