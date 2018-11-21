package scrabble;

/**
 * Class to manage players' scores
 * @author Lee
 */
/* 
    What must the class know?
        - What the players' scores are
        - The rank of the players

    What must the class do?
        - Calculate the player's score
        - Determine ranking of the players based on their scores
        - Print out ranking of scores
*/
public class Scores {
    // Declare variables - private - specific to instances
    private int score;  // Individual's score which is a weighted count of tiles played
    
    // Declare variables - static - specific to class not instances

    // Array to hold the ranked scores
    Scores[] scoresRanked = new Scores[4];

    ////////////////////////////////////////////////////////////////////////////
    // CONSTRUCTORS
    //////////////////////////////////////////////////////////////////////////// 
    /**
     * Constructor Players - no arguments
     * Initializes member fields to zero
     */
    public Scores(){
        // Create a new Scores object
        // Add the object to the class array
        // Set the field variables for that instance
        score = 0;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // ACTION METHODS
    ////////////////////////////////////////////////////////////////////////////
    
    
    /**
     * Determines ranking of each player in the game
     * Uses the class's scoresRanked array to keep track of the ranking of the players
     * Should be called every time a player's score is update
     */
    public void rankPlayers(){   

        // Suggest a highest to lowest ranking so [0] is highest for ease in printing out

    }
    /**
     * Prints out the rank of players and their scores from highest to lowest
     */
    public void printRanking(){
        // Print out the ranking showing player and their score from highest to lowest
        // Not sure what kind of format you like - verbose or tabular or ???
        // 1st: Player1 with 123 points
        // 2nd place: Player #2 - 435 points
    }

    /**
     * Adds 50 points to a player's score and then re-ranks the players.
     * This method is called when a player has played all the tiles in their hand 
     * in a single turn.
     */
    public void bingo(){
        // Add 50 points to player's score        
        score += 50;
        // Rank the players
        rankPlayers();
    }

    ////////////////////////////////////////////////////////////////////////////
    // GETTER METHODS
    ////////////////////////////////////////////////////////////////////////////   
    /**
     * Gets value of an object's score - a value that is tallied with each tile played
     * @return score - int
     */
    public int getScore(){
        return score;
    }

    /**
     * Gets value of the class's array of the ranking of players by their score
     * @return scoresRanked - Scores[] - class's array of ranked scores of the players
     */
    public Scores[] getScoresRanked(){
        return scoresRanked;
    }
    
    ////////////////////////////////////////////////////////////////////////////
    // SETTER METHODS
    ////////////////////////////////////////////////////////////////////////////
    
    /**
     * Calculates and sets the player's score by adding their latest points 
     * to their total score
     * Re-ranks players based on the latest score.
     * @param pointsAdded   int - value of the tile player played
     */
    public void setScore(int pointsAdded){
        score += pointsAdded;
        rankPlayers();
    }       
}
