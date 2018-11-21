package scrabble;
import java.util.*;

/**
 * Class for launching Scrabble game - contains main
 * @author Ruth Mosman
 */
public class Scrabble {

    /**
     * Main class for Scrabble
     * Initiates game
     * Displays ranking and winner upon completion
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Declare variables
        final int NUM_PLAYERS = 4;  // set number of players
        
        // Create an array that can reference Players objects
        Players[] players = new Players[NUM_PLAYERS];
        
        Players playerObj = new Players();
        Game game = new Game();
        
        playerObj.createPlayers(players);
        // Game loop
        do{    
            game.input(playerObj);
        // Loop until game is over or a player has skipped twice
        }while(!game.getGameOver() || playerObj.getSkipped() < 2);
        // Display players scores ranked from highest to lowest:
        // Scores printRanking();
        // Display the winner 
                
    }
    
}
