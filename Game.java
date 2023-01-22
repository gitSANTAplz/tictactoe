import java.lang.management.PlatformLoggingMXBean;

import javax.swing.text.PlainView;

/**
 * Represents the logic of the game in terms of detecting wins or draws. Also
 * places new pieces for the human player or AI.
 */

public class Game {
    private Board board = new Board();
    private Board secondBoard;
    // private Object bord;
    private GameStatus status;
    private AI ai;
    public static char playerXO;
    public static char aiXO;
    public boolean playerTurn = true;
    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct a new Game according to the given parameters.
     */
    public Game(boolean playerIsX, boolean challenging) {
        /*
         * TBD
         */
        if (playerIsX) {
            playerXO = 'X';
            aiXO = 'O';

            // ai.DumbAI(false);
        } else {
            playerXO = 'O';
            aiXO = 'X';

        }
        if (challenging) {
            //not supposed 2 be implemented and is not.
            System.exit(69420);;
        } else {
            ai = new DumbAI(playerIsX);
        }

        if (playerIsX) {
            playerTurn = true;
        } else {
            playerTurn = false;
        }
    }

    public boolean getTurn() {
        return playerTurn;
    }

    /**
     * Return a copy of the board's current contents.
     */
    public Board getBoard() {
        /*
         * TBD
         */
        return board.valueCopy(board);
    }

    /**
     * Get the game's status.
     */
    public GameStatus getStatus() {
        if (board.isFull()) {
            return GameStatus.DRAW;
        }
        boolean winX = false;
        for (int i = 0; i < 3; i++) {
            if ((board.get(i, 2) == 'X') && (board.get(i, 1) == 'X') && (board.get(i, 0) == 'X')) {
                winX = true;
            }

            if ((board.get(2, 2) == 'X') && (board.get(1, 1) == 'X') && (board.get(0, 0) == 'X')) {
                winX = true;
            }

            if ((board.get(2, 2) == 'X') && (board.get(1, 1) == 'X') && (board.get(0, 0) == 'X')) {
                winX = true;
            }

            if ((board.get(2, i) == 'X') && (board.get(1, i) == 'X') && (board.get(0, i) == 'X')) {
                winX = true;
            }
        }
        if (winX) {
            return GameStatus.X_WON;
        }
        boolean winO = false;
        for (int i = 0; i < 3; i++) {
            if ((board.get(i, 2) == 'O') && (board.get(i, 1) == 'O') && (board.get(i, 0) == 'O')) {
                winO = true;
            }

            if ((board.get(2, 2) == 'O') && (board.get(1, 1) == 'O') && (board.get(0, 0) == 'O')) {
                winO = true;
            }

            if ((board.get(2, 2) == 'O') && (board.get(1, 1) == 'O') && (board.get(0, 0) == 'O')) {
                winO = true;
            }

            if ((board.get(2, i) == 'O') && (board.get(1, i) == 'O') && (board.get(0, i) == 'O')) {
                winO = true;
            }
        }
        if (winO) {
            return GameStatus.O_WON;
        }

        else {
            return GameStatus.IN_PROGRESS;
        }
    }

    /**
     * Place a piece for the player on the board.
     * 
     * @param i i-coordinate of desired position.
     * @param j j-coordinate of desired position
     * @return true only if the coordinates of the desired position are in
     *         range and the corresponding cell is empty.
     *
     * @precondition status == IN_PROGRESS
     *
     */
    public boolean placePlayerPiece(int i, int j) {
        if (((0 > i) || (i > 2)) || ((j < 0) || (j > 2))) {
            return false;
        }
        Move m = new Move(i, j, playerXO);
        if (board.get(i, j) == ' ') {
            board = new Board(board, m);
            return true;
        } else {

            return false;
        }
    }

    /**
     * @precondition status == IN_PROGRESS
     */
    public void aiPlacePiece() {
        /*
         * TBD
         */
        boolean good = false;
        do {
            int moves = 0;
            Move aiMove = ai.chooseMove(board);
            if (((moves<1)&&(board.get(aiMove.getI(), aiMove.getJ()) == ' '))) {
                board = new Board(board, aiMove);
                good = true;
                moves++;
            } else {
            
            }


        }
        while(!good);
    }
}
