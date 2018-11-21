package scrabble;

/**
 * Class to manage the board and placing tiles on the board
 * @author Iryna McBride
 */

/* 
    What must the class know?
        - The board
        - Positions filled on the board
        - Positions available on the board
        - Position player wants to put tile

    What must the class do?
        - Print out the board with spaces filled with latest info
        - Validate if selected spot is available
        - Place the tile on the board
        - ***Determine if board is full such that game should stop - boardFull() - returns boolean - Iryna, I added this method
            -- Should we have it stop when less than 10?% of the board is available?
*/


public class Board {

    private char[][] board = new char[14][14];    // board for storing characters, made one bigger than the size we want so can have headers
    
    
    ////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////////////////////////////////////// 
    /**
     * Constructor - no arguments
     */
    public Board(){
        // Create a 2D cahr array with the characters needed for the board

    }
    
    ////////////////////////////////////////////////////////////////////////////
    // ACTION METHODS
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Prints out the board 
     */
    public void printBoard(){
       
    }
        
    /**
     * Determines if the spot selected is a valid available space to play a tile
     * @param row       Char - user defined value for row on the board
     * @param column    Char - user defined value for column on the board
     * @return filled   Boolean - true if spot is available
     *                          - false if spot is occupied
     */
    public boolean validSpotAvailable(char row, char column){
        // Declare variable for storing whether spot is filled or not
        // Set it to filled
        boolean filled = true;
        
        // determine if spot available
        
        // Return whether the spot was filled or not
        return filled;
    }
      
    /**
     * Places the specified tile on the board in the place determined by the column
     * and row passed
     * @param row       Char - user defined value for the row
     * @param column    Char - user defined value for the column    
     * @param tile      Char - user defined value for the tile to play
     */
    public void placeTileOnBoard(char row, char column, char tile){
        //
        // verify that the spot is not already taken

    }    
    
    /**
     * Determines if the board is full
     * @return full Boolean - true if board is full
     *                      - false if space available on board to play a tile
     */
    public boolean boardFull(){
        boolean full = false;
        return full;
    }

    ////////////////////////////////////////////////////////////////////////////
    // GETTER METHODS
    ////////////////////////////////////////////////////////////////////////////

    /**
     * Gets the board value
     * @return board    Char 2D array of the class's board
     */
    public char[][] getBoard(){
        return board;
    }

    
    ////////////////////////////////////////////////////////////////////////////
    // SETTER METHODS
    ////////////////////////////////////////////////////////////////////////////



 
}
