
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

        String yNAns = scanner.nextLine().toString();
        if ((yNAns.equals("Y")) || (yNAns.equals("y"))) {
            playAsX = true;
        }

        System.out.println("Do you want a challenge (Y/N)");
        yNAns = scanner.nextLine().toString();
        if ((yNAns.equals("Y")) || (yNAns.equals("y"))) {
            challenge = true;
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
        boolean playerTurn;
        playerTurn = game.getTurn();
        do {
            int yCord;
            int xCord;
            if (playerTurn) {
                System.out.println("Enter Desired x-coordinate: ");
                xCord = scanner.nextInt();

                System.out.println("Enter Desired y-coordinate: ");
                yCord = scanner.nextInt();
                boolean properSpot = game.placePlayerPiece(xCord, yCord);
                if (properSpot) {
                    game.playerTurn = false;
                } else {
                    System.out.println("Sorry, invalid input. Please type again\n");
        
                }
                ;
                strBoard = (game.getBoard().toString());
                if (properSpot) {
                    System.out.print("After Your Move: \n");
                    System.out.println(strBoard);
                    playerTurn = false;
                }
            } else {
                game.aiPlacePiece();
                playerTurn = true;

                strBoard = (game.getBoard().toString());
                System.out.println("After AI move:\n");
                System.out.println(strBoard);

            }

            if (game.getStatus().equals(GameStatus.DRAW)) {
                System.out.println("Draw :/\n");
            }
            if (game.getStatus().equals(GameStatus.O_WON)) {
                if (!playAsX) {
                    System.out.println("You Win!\n");
                } else {
                    System.out.println("You Lost.\n");
                }
            }
            if (game.getStatus().equals(GameStatus.X_WON)) {
                if (playAsX) {
                    System.out.println("You Win!\n");
                } else {
                    System.out.println("You Lost.\n");
                }
            }
        } while (game.getStatus().equals(GameStatus.IN_PROGRESS));
        /*
         * System.out.println("Do you want to play again as X (Y/N) :");
         * 
         * String yNAns = scanner.nextLine().toString();
         * if ((yNAns.equals("Y")) || (yNAns.equals("y"))) {
         * mainLoop();
         * }
         */
    }

}
