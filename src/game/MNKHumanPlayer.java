package game;

import java.util.Scanner;

public class MNKHumanPlayer implements Player{
    private final Scanner in;
    private final Output out;

    public MNKHumanPlayer(Scanner in, Output out) {
        this.in = in;
        this.out = out;
    }

    public MNKHumanPlayer(Output out) {
        this(new Scanner(System.in), out);
    }

    @Override
    public Move makeMove(Position position) {
        out.println("Enter you move: ");
        while (true) {
            String X = in.next();
            String Y = in.next();
            if (isNumber(X) && isNumber(Y)) {
                int x = Integer.parseInt(X) - 1;
                int y = Integer.parseInt(Y) - 1;
                if (position.getCell(x, y) == Cell.EMPTY) {
                    out.println("");
                    return new MNKMove(x, y);
                }
            }          
        out.println("Incorrect input, try again");
        }
    }

    private boolean isNumber(String arg) {
        boolean isNumber = true;
        for (int x = 0; x < arg.length(); x++) {
            if (!Character.isDigit(arg.charAt(x))) {
                isNumber = false;
            }
        }
        return isNumber;
    }

}
