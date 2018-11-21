package scrabble;

/**
 * Class to manage the tiles in a players hand
 * A player will be dealt a new hand each turn
 * @author Kylie Gerhard
 */

/* 
    What must the class know?
        - What the tiles are and their values
        - What tiles are in a player's hand

    What must the class do?
        - Generate a hand for a player
        - Display the player's hand
        - *Gets input from user as to tile they want to play - not sure if this goes here or in board
        - Validates that a tile is in a player's hand
        - Analyzes the value of the tile
        - Adds 50 points to player's score when player plays all 7 tiles in one turn - bingo
*/

public class Tiles {
    // Array to store a player's hand
    // Kylie - thinking this needs to be an array list so we can shrink it 
    // down as tiles are removed and then expand it again as the new hand
    // gets generated
    private char[] hand = new char[7];
    
    
    ////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    ////////////////////////////////////////////////////////////////////////////   
    /**
     * Constructor - no arguments
     */
    public Tiles(){
        // Fill array
        // Initial hand
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // ACTION METHODS
    ////////////////////////////////////////////////////////////////////////////
    
    // Generate a hand
    // How are we going to know whose hand was generated? Pass in the player?
    /**
     * Generates a player's hand of seven tiles using randomly generated 
     * uppercase alpha characters
     * Characters are stored in a char array
     * Called at the beginning of each player's turn
     * @param player Players - object identifying which player's turn it is
     */
    public void generateHand(Players player){
    //    Uppercase alpha chars – use ASCII to Random generate and then convert to char or switch? 
    // Initial hand
    // Subsequent hand
    
    }
    
    /**
     * Displays the tiles in the player’s hand to the player
     */
    public void printHand(){
        
    }
      
    /**
     * Analyzes the tile passed in to produce its score.
     * Tiles have weighted values:
     * (1 point)-A, E, I, O, U, L, N, S, T, R
     * (2 points)-D, G    
     * (3 points)-B, C, M, P
     * (4 points)-F, H, V, W, Y
     * (5 points)-K   
     * (8 points)- J, X
     * (10 points)-Q, Z
     * @param tile   Char - tile played by the user
     * @return value Int - value of the character that was played
     */
    public int analyzeTileValue(char tile){
        int value = 0;
//    Each tile has a value
//    Scrabble assigns these values:



        return value;

    }
    
    /**
     * Checks if all tiles have been used from the players hand
     * @return allPlayed Boolean - returns true if all have been played
     *                           - returns false if player still has tiles to play
     */
    public boolean allTilesPlayed(){
        boolean allPlayed = false;
        return allPlayed;
    }
    
    /**
     * Checks to see if the tile passed in matches a tile in the player's hand
     * @param tile      Char - value passed in to represent the tile to be played
     * @return inHnad   Boolean - returns true if the tile matches a tile in the players hand
     *                          - returns false it the tile does not match any tile
     *                              in the player's hand
     */
    public boolean tileIsInHand(char tile){
        boolean inHand = false;
        return inHand;
    }
    

    /**
     * Removes a tile from a player's hand
     * @param letter Char - tile to be removed from the player's hand
     */
    public void removeTileFromHand(char letter){
        // Remove the played tile from the hand
        // Based on this, thinking we need an array list not an array
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // GETTER METHODS
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Gets the players hand - a char array of 7 characters
     * @return hand Char[] - filled with tiles that have not been played 
     */
    public char[] getHand(){
        return hand;
    }

    ////////////////////////////////////////////////////////////////////////////
    // SETTER METHODS
    ////////////////////////////////////////////////////////////////////////////    
    
    /**
     * Adds a letter to the player's hand
     * @param letter Char - letter to be added to player's hand
     */
    public void setHand(char letter){
        
    }
}
