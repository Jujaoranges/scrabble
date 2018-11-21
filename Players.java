package scrabble;
import java.util.Scanner;

/**
 * Players class - class for tracking players and their actions * 
 * @author Ruth Mosman
 * Creates players.
 * Determines and tracks whose turn it is.
 * Determines and tracks how many times a player has skipped their turn in a row.
 */
/* 
    What must the class know?
        - Who the players are
        - How many players
        - Whose turn
        - Whether the player has skipped

    What must the class do?
        - Create players
        - Determine whose turn
        - Determine if a player is skipping their turn
        - Update skipped count
*/
public class Players {
    // Declare variables - private - specific to instances
    private int skipped;                // Counter for number of times a player has skipped their turn
    
    // Declare variables - static - specific to class not instances
    private static int whoseTurn = 1;   // Stores whose turn it currently is to play
    // May not need this - suggest setting this to the final variable of the array size of players created
    private static int numPlayers = 0;  // Stores number of players
    
    // Book has this declaration in main but also has all the methods within that file...
    //Players[] playerArray = new Players[4];

    ////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////////////////////////////////////// 
    /**
     * Constructor Players - no arguments
     * Initializes member fields to zero.
     * Creates a Tiles object for accessing a player's hand.
     * Creates a Scores object for tracking a player's score.
     */
    public Players(){
        // Create a new player object - think that createPlayers will work for that
        // Set the field variables for that instance
        skipped = 0;
        // Create a Tile object to be able to get a hand for the player
        Tiles hand = new Tiles();
        // Create a Scores object to be able to get a score for the player
        Scores score = new Scores();
        // insert the new object into the Players array - do we need an array in this class or one in main?
        //playerArray[numPlayers] = new Players();
        // Increment the player count for each player created:
        //numPlayers++;

    }
    
    ////////////////////////////////////////////////////////////////////////////
    // ACTION METHODS
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Fills an array of Players with new player objects
     * Increments counter of number of player objects created
     * @param playerArr Players array that is passed by reference. 
     *                  Array gets filled with new player objects.
     */
    // Book has this as static   
    // Thinking the array should be created in main or Game and then filled with players here 
    public void createPlayers(Players[] playerArr){
        for(int i = 0; i < playerArr.length; i++){
            playerArr[i] = new Players();
            // Increment the player count for each player created:
            // Putting count here as unclear what objects will need created for which
            numPlayers++;
        }       
        
        // Should the array have an array instantiated within this class to match the one created?
    }
    
    /**
     * Determines if player wants to skip their turn. 
     * Asks user whether they want to skip their turn. 
     * If yes, then skip counter for that player is incremented 
     *      and sets return value to true - that player wants to skip their turn.
     * If no, then skip counter for that player is reset to 0
     *      and return value continues as false - that player wants to skip is false.
     * @return skip Boolean - returns true if player wants to skip their turn
     *                      - returns false if player does not want to skip their turn.
     */
    // Exception is handled within the method so no "@throws" included in javadoc comments.
    public boolean skipTurn(){
        // Declare variables
        String userInput;       // Stores user's input from keyboard
        boolean skip = false;   // Stores user's choice of whether to skip turn - true, or not - false
        boolean again = true;   // Flag to determine when user input was valid or need to loop again for valid input
        
        // Create a Scanner object for getting input from the keyboard
        Scanner keyboard = new Scanner(System.in);

        // Loop while the input is invalid
        do{
            // Ask the user if they want to skip their turn
            System.out.print("Do you want to skip your turn? (Y/N)");
            
            // Get the user input from the keyboard and store it in userInput
            userInput = keyboard.nextLine();

            // Anticipate errors
            try{
                // Determine if the first character that the user entered was a Y or y
                // Might could use toUpperCase() but need help to know how to do that unless assign to a 
                //if(userInput.charAt(0) == 'Y' || userInput.charAt(0) == 'y'){ 
                if((userInput.toUpperCase()).charAt(0) == 'Y'){
                    // If so, then they want to skip so set skip to true
                    skip = true;
                    // Increment the skip counter for that player
                    // Get current value and increment it by 1
                    setSkipped(getSkipped() + 1);
                    // Set flag to exit the loop
                    again = false;              
                }
                // Determine if the first character that the user entered was an N or an n
                //else if(userInput.charAt(0) == 'N; || userInput.charAt(0) == 'n'){
                else if((userInput.toUpperCase()).charAt(0) == 'N'){    
                    // Reset the player's skipped counter to 0
                    setSkipped(0);
                    // Set flag to exit the loop
                    again = false;                   
                }
                else{
                    throw new NumberFormatException();
                }

            }
            // Catch any error thrown
            catch(NumberFormatException nfe){
                // Prompt user as to valid input.
                System.out.println("Please enter valid input: Y or N");
            }
        // Loop until valid input has been received.    
        }while(again);    
        
        // Return whether the player wants to skip to the calling program
        return skip;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // GETTER METHODS
    ////////////////////////////////////////////////////////////////////////////
   
    /**
     * Gets value of class's numPlayers - the number of players
     * @return numPlayers - int - count of number of players
     */
    public static int getNumPlayers(){
        return numPlayers;
    }
    
    /**
     * Gets value of an object's count of times they chose to skip a turn
     * @return skipped - int
     */
    public int getSkipped(){
        return skipped;
    }
    
    /**
     * Gets value of whose turn it currently is
     * @return whoseTurn - int
     */
    public static int getWhoseTurn(){
        return whoseTurn;
    }

    ////////////////////////////////////////////////////////////////////////////
    // SETTER METHODS
    ////////////////////////////////////////////////////////////////////////////
    /**
     * Sets the numPlayers static field to keep count of the number of players.
     * @param chgPlayerCount int - positive number adds players, 
     *                             negative number subtracts players from
     *                             number of players counter
     */
    public static void setNumPlayers(int chgPlayerCount){
        numPlayers += chgPlayerCount;
        // TO DO: Make sure count doesn't go below 1
    }
    
    /**
     * Sets the player's counter of number of times the player has skipped.
     * As this can either be incremented or set to 0, this method simply sets the 
     * count of skips to the value passed. 
     * Calling program can set it directly to 0.
     * If the calling program wants to increment the count, then they need to first
     * call the getSkipped method to find out the value of the field and increment
     * it as desired before passing the value in.
     * @param skipCount int - Count of how many times a player has skipped in a row.
     *                        Expected values:
     *                          - 0 if they did not skip on their most recent turn
     *                          - 1 if they only skipped the last turn
     *                          - 2 if they skipped the last turn and current turn
     */
    public void setSkipped(int skipCount){
        skipped = skipCount;
    }
    
    /**
     * Sets the class variable for tracking whose turn it is to the next person's
     * turn. Will need called at the end of each player's turn to determine who 
     * plays next.
     * Uses 1 based counting for turns.
     * If the player is the last player, sets the turn back to player 1.
     * Otherwise, it finds whose turn it currently is and increments the 
     * counter to the next player whose turn it is.
     * Current implementation is for a variable number of players.
     */
    public static void setWhoseTurn(){
//        // If current turn is player 1 player array[0]
//        if(whoseTurn == 1){
//            // Sets field to player 2 player array[1]
//            whoseTurn = 2;
//        }
//        // If current turn is player 2 player array[1]
//        else if(whoseTurn == 2){
//            // Sets field to player 3 player array[2]
//            whoseTurn = 3;
//        }
//        // If current turn is player 3 player array[2]
//        else if(whoseTurn == 3){
//            // Sets field to player 4 player array[3]
//            whoseTurn = 4;
//        }
//        // If current turn is player 4 player array[3]
//        else{
//            // Sets field to player 1
//            whoseTurn = 1;
//        }
        
        // Loop for determining whose turn when an number of players
        // can't be known in advance
        // Initialize count to 1 
        // Since starting at one, continue until counter equals the number of players
        // Increment the counter
        for(int i = 1; i <= numPlayers; i++){
            // If the counter matches the maximum number of players - last player
            if(i == numPlayers){
                // Set the turn back to first player
                whoseTurn = 1;
                // Set the counter to exit the loop
                i = numPlayers;
            }
            // If the counter matches whose turn it is and it isn't the last player
            else if(i == whoseTurn){
                // Increment the counter to set it to the next player's turn
                whoseTurn++;
            }
            // Else it wasn't the last player or the player wasn't found
            // Loop until the player is found
        }
    }
    
}
