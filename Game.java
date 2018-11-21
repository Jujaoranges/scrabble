package scrabble;
import java.util.Scanner;

/**
 * Class to manage the game dynamics including the board, players, 
 * tiles, and scores of the players.
 * @author Ruth Mosman
 */

/* 
    What must the class know?
        - Still playing - turn not over
        - Whether game is over - game done
        - The board - 
        - The players - whose playing
        - The tiles - what players hands are
        - The score - the players scores

    What must the class do?
        - Manage the play
        - Get players created
        - Print out the board - call Board printBoard()
        - Get input from user on row to place tile - call getRowFromUser() - returns char
        - Get input from user on column to place tile - call getColumnFromUser() - returns char
        - Validate if selected spot is available - call Board validSpotAvailable() - returns T/F
        - Get input from user on tile to play - call getCharFromUser() - returns char
        - Validate that the tile is a legitimate tile to place - calls Tiles tileInHand() - returns T/F
        - Place the tile on the board - call Board placeTileOnBoard() - pass row, column and tile
        - Calculate score:
            - calls Tiles analyzeTileValue() - passes the letter placed, gets the points added back
            - calls Scores setScore() - passes the points added (that method calls scoresRanked)
        - Determine if player has more tiles to play -- put this call in done()?
            - calls Tiles tilesLeftToPlay - returns boolean - true if more tiles to play
        - Determine if player wants to play more tiles - put this in done()?
        - Loop until they are ready to end their turn
        - Display player's ranking - call Scores printRanking() - prints out array of ranked scores
        - Determine next player - call Players getWhoseTurn() - returns an int value, 
            -- curerntly set at 1 based for printing out player in end user format when I was using a winner variable
            -- think this can be changed to 0 based with storing winner rankings in an array
            -- let me know what works best for you and I'll update the method
        - Determine if board is full such that game should stop - call Board boardFull() - returns boolean
            -- Should we have it stop when less than 10?% of the board is available?
        - Determine if the next player wants to skip or end the game
            - call Players skipTurn() - returns true (skip) / false (play)
            - Should this be handled in done()?
        - Determine if game is over
*/

// This is the aggregate as it has board, players and tiles
public class Game {
    
    // Use this to track if a player wants to keep playing on their turn
    private static boolean turnOver = true;
    
    // Use this to track if game is finished
    private static boolean gameOver = false;
    
    //private char[][] board = new char[14][14];    // board for storing characters, made one bigger than the size we want so can have headers
    
    // Lee or anyone - do we need an instance create for each class here?
    private Board board = new Board();
    private Players player = new Players();
    private Tiles tile = new Tiles();
    private Scores score = new Scores();
    

            
        
    
    
    ////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    ////////////////////////////////////////////////////////////////////////////   
    /**
     * Construtor - no arguments
     */
    public Game(){

    }
    
    ////////////////////////////////////////////////////////////////////////////
    // ACTION METHODS
    ////////////////////////////////////////////////////////////////////////////
       
    /**
     * Method that orchestrates the dynamics of the game.
     * @author Ruth Mosman
     * Rotates through the players in turn:
     * - Gets them a new hand.
     * - Displays the new hand to them.
     * - Prints out the board so they can see what options they have to play.
     * - Asks them if they want to skip their turn.
     * - If they want to skip, play advances to the next player.
     * - If they want to continue:
     * -- Gets a row and column from the player to place their tile in.
     * -- Gets a tile from the player that they want to play.
     * -- Places their tile on the board.
     * -- Repeats getting a space and tile from the user until they are out of tiles
     *      or choose to end their turn or the board is full.
     * - Play then advances to the next player who can choose to end the game.
     * - If they don't end the game, they get a new hand and are given all the options
     *      above again.
     * - Play continues until a player says to end the game, the board is full,
     *      or a player has skipped twice.
     */
    // Change to be an array of Players -
    public void input(Players playerObj){
        // Declare variables
        char row, column, letter;   // User input values for row, column and tile they want played and where
        boolean again = true;       // Flag for ending loops
        int points = 0;             // Stores the points obtained when a tile is played
        
//        // Game loop
//        do{
            // Generate a player's hand - will it already have been generated 
            // such that this should go when the player's turn changes at the end of the loop?
            tile.generateHand(player);
            // Print out the tiles/array
            tile.printHand();
            // Print the board
            board.printBoard();
                
            // Turn loop
            // Check if player wants to skip their turn or their turn is over
            // If want to continue and their turn is not over - proceed
            while(!player.skipTurn() || !getTurnOver()){
                
                // Set flag to trigger looping
                again = true;
                
                // Loop to get an available spot on the board
                do{
                    // get row from user
                    row = getRowFromUser();
                    // get column from user
                    column = getColumnFromUser();
                    // validate that the space identified by row and column is a valid
                    // If it isn't available
                    if(!board.validSpotAvailable(row, column)){
                        // Notify the player to select another spot
                        System.out.println("Space is not available. Please select another space.");
                    }
                    // Spot is available
                    else{
                        // Set flag to exit loop
                        again = false;
                    }
                // Loop until an available space is found
                }while(again);
                
                // Set flag to trigger looping
                again = true;

                // Loop to get tile from user
                do{
                    // Ask user for tile
                    letter = getCharFromUser();
                    // Validate tile came from player's hand
                    if(tile.tileIsInHand(letter)){
                        // Set flag to exit loop
                        again = false;
                    }
                    // Tile selected was not in player's hand
                    else{
                        // Notify player to select a tile from their hand
                        System.out.println("Please select a valid tile from your hand.");
                        // Print out their hand again so they can see what they have
                        tile.printHand();
                    }

                // loop until tile came from player's hand                
                }while(again);

                // place tile on board
                board.placeTileOnBoard(row, column, letter);
                // analyze score
                points = tile.analyzeTileValue(letter);
                // increment player's count by value of tile
                score.setScore(points);
                //Remove the tile from the player's hand
                tile.removeTileFromHand(letter);
                // Determine if player has played all their tiles
                if(tile.allTilesPlayed()){
                    // All tiles played so bingo their score
                    score.bingo();
                    // Set flag to end their turn
                    setTurnOver(true);
                }
                // Determine if player wants to continue, if not
                else if(!continueTurn()){
                    // Set the flag to their turn being over
                    setTurnOver(true);
                }
                // Determine if the board is full
                else if(board.boardFull()){
                    // Set turn over
                    setTurnOver(true);
                    // Set game over
                    setGameOver(true);
                }
                // Player wants to continue playing, has tiles and there is space on the board
                // Print out the remaining tiles/array
                tile.printHand();
                // Print the board
                board.printBoard();

            // Loop until player wants to or has to end their turn
            }
            
            // change turn to next player
            Players.setWhoseTurn();            
            
            // Determine if player wants to end game
            continueGame();

        // Loop until game is over or a player has skipped twice
        //}while(!getGameOver() || player.getSkipped() < 2);
    }
    
    /**
     * Asks the user which row they want to play the tile in.
     * Validates that the row is a valid row.
     * Loops until a valid row is selected (char of 'A' through 'M.')
     * @return row Char - represents a row on the board
     */
    public char getRowFromUser(){
        char row;
        // get row from user
        // validate it is a valid row (A-M)
        // loop until a valid row selected
        return row;
    }

    /**
     * Asks the user which column they want to play the tile in.
     * Validates that the column is a valid column.
     * Loops until a valid column is selected (char of 'N' through 'Z.')
     * @return column Char - represents a column on the board
     */
    public char getColumnFromUser(){
        char column;
        // get column from user
        // validate it is a valid column (N-Z)
        // loop until a valid column selected
        return column;
    }    
    
    /**
     * Asks the user which letter they want to play
     * Validates that the character is from their hand
     * Continues to prompt user until a valid tile from their hand is selected
     * @return letter Char - valid tile that is to be played
     */
    public char getCharFromUser(){
        char letter;
        // get letter from user
        // validate it is from their hand 
        // tile.tileIsInHand(letter);
        // loop until it is a valid letter from their hand
        return letter;
    }
  
    /**
     * Asks the user if they want to end their turn or play another tile.
     * Sets turnOver static field with user's input.
     * @return anotherTurn Boolean - returns true if player wants another turn
     *                             - returns false if player does not want another turn
     */
    public boolean continueTurn(){
        boolean anotherTurn = true;
        // ask user if they want to continue their turn 
        setTurnOver(anotherTurn);
        return anotherTurn;
    }
    
    /**
     * Asks the user if they want to end the game.
     * Sets gameOver static field with user's input.
     * @return stillPlaying Boolean - returns true if stillPlaying
     *                              - returns false if player wants to end game
     */
    public boolean continueGame(){
        boolean stillPlaying = true;
        // ask user if they want to end the game 
        setGameOver(stillPlaying);
        return stillPlaying;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // GETTER METHODS
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Gets the stored value of turnOver - variable that stores whether a turn is over
     * @return turnOver Boolean - returns true if turn is over
     *                          - returns false if turn is not over
     */
    public boolean getTurnOver(){
        return turnOver;
    }
    
    /**
     * Gets the stored value of gameOver - variable that stores whether a game is over
     * @return gameOver Boolean - returns true if game is over
     *                          - returns false if game is not over
     */
    public boolean getGameOver(){
        return gameOver;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // SETTER METHODS
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Sets the turnOver static field that stores when the Player's turn is over
     * @param turnStatus Boolean - value passed that determines if turn is over
     *                           - Turn over = true
     *                           - Turn not over yet = false
     */
    public void setTurnOver(boolean turnStatus){
        turnOver = turnStatus;
    }
    
    /**
     * Sets the gameOver static field that stores when the game is over
     * @param gameStatus Boolean - value passed that determines if game is over
     *                           - Game over = true
     *                           - Game not over yet = false
     */
    public void setGameOver(boolean gameStatus){
        gameOver = gameStatus;
    }    

}
