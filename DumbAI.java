
/**
 * Realization of AI interface using simplistic random placement strategy.
 */

import java.util.Random;

public class DumbAI implements AI {

    private Random random = new Random();

    char xOrO;

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Construct a DumbAI.
     * 
     * @param aiIsX Indicates whether the AI player's piece is
     *              the 'X'.
     */
    public DumbAI(boolean aiIsX) {
        /*
         * TBD
         */
        if (aiIsX) {
            xOrO = 'O';
        }
        else
        {
            xOrO = 'X';
        }
    }

    public Move chooseMove(Board board) {
        /*
         * TBD
         
         */

         int x = ((int)random.nextInt(3));
         int y = ((int)random.nextInt(3));
         
         Move m = new Move(x, y, xOrO);
         return m;



    }
}
