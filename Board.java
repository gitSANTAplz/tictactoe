

/**
 * An immutable class that represents the state of the 2×2 tic-tac-toe board.
 */

public final class Board {

    private char[][] board = new char[3][3];

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct an empty board (contains all space char's).
     */
    public Board() {
        for (int i = 0; i < 3; i++) {
            board[i][0] = ' ';
            board[i][1] = ' ';
            board[i][2] = ' ';

        }

    }

    public Board(char[][] content)
    {
        for(int i =0;i<3;i++)
        {
            for (int j =0;j<3;j++)
            {
                board[i][j] = content[i][j];
            }
        }    
    }

    public Board valueCopy(Board other)
    {
        char xy[][] = new char[3][3];
        for(int i =0;i<3;i++)
        {
            for (int j =0;j<3;j++)
            {
                xy[i][j] = other.get(i, j);
            }
        }
        return new Board(xy);
    }


    /**
     * Given the 'other' board as a starting condition, apply the given
     * 'move' to generate this board's state.
     */
    public Board(Board other, Move move) {
        /*
         * TBD
         */
        char xy[][] = new char[3][3];
        for(int i =0;i<3;i++)
        {
            for (int j =0;j<3;j++)
            {
                xy[i][j] = other.get(i, j);
                
            }
        }
        int iCord = move.getI();
        int jCord = move.getJ();
        xy[iCord][jCord]=move.getPiece();
        

        board = xy;
        ////newBoard.board[iCord][jCord] = move.getPiece();

    }

    /**
     * Convert to a string that shows the board's state.
     */
    public String toString() {
        /*
         * String h = "";
         * for (int i = 0; i < 3; i++) {
         * for (int j = 0; j < 3; j++) {
         * h += board[i][j];
         * }
         * }
         * System.out.println(h);
         * return h;
         */
        String toString = "";
        toString += ("-------------\n");
        toString += ("| " + get(0, 0) + " | " + get(1, 0) + " | " + get(2, 0) +
            " |\n");
        toString += ("-------------\n");
        toString += ("| " + get(0, 1) + " | " + get(1, 1) + " | " + get(2, 1) +
            " |\n");
        toString += ("-------------\n");
        toString += ("| " + get(0, 2) + " | " + get(1, 2) + " | " + get(2, 2) +
            " |\n");
        toString += ("-------------\n");
        return toString;

    }

    /**
     * Get the entry of the board at column i, row j. Both indices should
     * be in the range [0, 2].
     */
    public char get(int i, int j) {
        return board[i][j];
    }

    /**
     * @return true if there remain no empty spots on the board.
     */
    public boolean isFull() {
        if ((((board[0][0] == 'X') || (board[0][0] == 'O')) && ((board[0][1] == 'X') || (board[0][1] == 'O'))
                && ((board[0][2] == 'X') || (board[0][2] == 'O')))) {
            if ((((board[1][0] == 'X') || (board[1][0] == 'O')) && ((board[1][1] == 'X') || (board[1][1] == 'O'))
                    && ((board[1][2] == 'X') || (board[1][2] == 'O')))) {
                if ((((board[2][0] == 'X') || (board[2][0] == 'O')) && ((board[2][1] == 'X') || (board[2][1] == 'O'))
                        && ((board[2][2] == 'X') || (board[2][2] == 'O')))) {
                    return true;
                }
            }
        }
        return false;
    }
}
