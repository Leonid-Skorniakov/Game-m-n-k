package game;

public class MNKTournament {
    private final int m;
    private final int n;
    private final int k;

    private final Output out;
    private final Player[] playerList;
    private final int playerCount;

    private int[] resultTable;

    public MNKTournament(int m, int n, int k, Player[] playerList, Output out) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.out = out;
        this.playerList = playerList;
        this.playerCount = playerList.length;
        resultTable = new int[playerCount];
        for (int i = 0; i < playerCount; i++) {
            resultTable[i] = 0;
        }
    }

    public void start() {
        for (int x = 0; x < playerCount; x++) {
            for (int y = 0; y < playerCount; y++) {
                if (x == y) {
                    continue;
                }

                out.println("Start game between players: " + (x + 1) + " and " + (y + 1));
                out.println("");

                int result = startGame(m, n, k, playerList[x], playerList[y]);
                switch (result) {
                    case 1 -> {
                        System.out.println("First Player Win");
                        resultTable[x] += 3;
                    }
                    case 2 -> {
                        System.out.println("Second Player Win");
                        resultTable[y] += 3;
                    }
                    case 0 -> {
                        System.out.println("Draw");
                        resultTable[x] += 1;
                        resultTable[y] += 1;
                    }
                    default -> {}
                }
            }
        }
        showTable(resultTable);
    }

    private int startGame(int m, int n, int k, Player firstPlayer, Player secondPlayer) {
        Player player1 = firstPlayer;
        Player player2 = secondPlayer;

        int result = new Game(player1, player2, new MNKBoard(m, n, k), out).play();

        return result;
    }

    private void showTable(int[] table) {
        out.println("---Table---");
        for(int i = 0; i < table.length; i++) {
            out.println((i + 1) + ": " + table[i]);
        }
    }
}
