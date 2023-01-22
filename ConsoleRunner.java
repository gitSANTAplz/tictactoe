
/**
 * ConsoleRunner:  Prompts the user to determine the parameters of the Game
 * constructor.  Creates a Game and manages the alternating calls to the
 * ‘place’ methods in Game.  Prompts the user for inputs and outputs the state
 * of the board to the console.
 */

import java.util.Scanner;

public class ConsoleRunner {

    private Game game;
    // Use to process text input from the user.
    private Scanner scanner = new Scanner(System.in);

    /*
     * TBD: Create additional private members if useful.
     */

    /**
     * Constructor
     */
    public ConsoleRunner() {

        playAsX = false;
        challenge = false;
        System.out.println("Do you want to play as X (Y/N) :");

        String yNAns = scanner.nextLine();
        if ((yNAns == "Y") || (yNAns == "y")) {
            playAsX = false;
        }

        System.out.println("Do you want a challenge (Y/N)");
        yNAns = scanner.nextLine();
        if ((yNAns == "Y") || (yNAns == "y")) {
            challenge = false;
        }

        /*
         * TBD
         *
         * Use the 'next' method of Scanner and the 'matches' of the String
         * class to process user responses as strings.
         */

        game = new Game(playAsX, challenge);
        
    }

    /**
     * Enter the main control loop which returns only at the end of the game
     * when one party has won or there has been a draw.
     */

    public boolean playAsX = false;
    public boolean challenge = false;
    public boolean keepGoing = true;
    public Board currentBoard;

    public void mainLoop() {

        String strBoard = (game.getBoard().toString());
        System.out.println(strBoard);
    }
}
