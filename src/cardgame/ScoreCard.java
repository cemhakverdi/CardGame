package cardgame;
import java.util.ArrayList;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author: İpek Tüfekçioğlu - Cem Hakverdi
// date: 21/02/2021
public class ScoreCard
{
    // properties
    int[] scores;
    
    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    

    // methods
                
    /**
     * This method gives the score of the specified player
     * @param playerNo is the player numbe that we want to know the score of 
     * @return the score of the specified player
    */
    public int getScore( int playerNo)
    {
        return scores[ playerNo];
    }
    
    
                
    /**
     * This method updates the score of the specified player
     * @param playerNo is the player numbe that we want to update the score
     * @param amount is the number that we want to update
    */
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    
                    
    /**
     * This method gives a string representation of the score card
     * @return the string representation of the score card
    */
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    
    
                    
    /**
     * This method finds the winners and returns them
     * @return an array which has the winners in it
    */
    public int[] getWinners()
    {
        int index;
        index = 0;
        
        ArrayList<Integer> winnerList = new ArrayList<Integer>();
        
        for (int i = 0; i < scores.length - 1; i++) 
        {
            if (scores[i] > scores[i + 1]) 
            {
                index = i + 1;
            }
        }
        
        for (int i = 0; i<scores.length;i++ )  
        {
            if (scores[index] == scores[i])
            {
                winnerList.add(index);
            }
        }
        
        int[] winners = new int[winnerList.size()];
        
        for (int i = 0; i < winners.length; i++)
        {
            winners[i] = winnerList.get(i);
        }
        return winners;

        
    }
    
} // end class ScoreCard
