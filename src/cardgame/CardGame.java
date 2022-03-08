package cardgame;

import java.util.ArrayList;

// Cardgame
// author: İpek Tüfekçioğlu - Cem Hakverdi
// date: 21/02/2021
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer;
    Card[]            firstCard = new Card[13];
    Card              temp;
    Cards             deck;
    Card[]            deck2; 
    
    // constructors
    
    /**
     * This constructor set players. Then shuffle a deck and distribute the cards one by one to all players.
     * Also initialize the score card, round number, turn of the player and cards on the table.
    */
    
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        players = new ArrayList<Player>();
        players.add(p1);
        players.add(p2);
        players.add(p3);
        players.add(p4);
        
        
        deck = new Cards(true);
        deck.shuffle();
        
        
        for(int i = 0; i < 52; i++)
        { 
            temp = deck.getTopCard();
            if( i % 4 == 0)
            {
                p1.add(temp);
            }
            
            if( i % 4 == 1)
            {
                p2.add(temp);
            }
            
            if( i % 4 == 2)
            {
                p3.add(temp);
            }
            
            if( i % 4 == 3)
            {
                p4.add(temp);
            }
            
        }
        
        scoreCard = new ScoreCard(players.size());

        roundNo = 0;
        turnOfPlayer = 0;
        
        cardsOnTable = new Cards[13];
        for(int i = 0; i < 13 ; i++)
        {
            cardsOnTable[i] = new Cards(false);
        }
    }
    
    
    
    /**
     * This method plays the turn of the specified player with the top card on their hand.
     * Also finds the maximum card on that round and add a point to the round winner
     * @param p is the player that going to play.
     * @param c is the top card in the player p's hand
     * @return true if the player has been played the card
    */
    // methods
    public boolean playTurn( Player p, Card c)
    {
        deck2 = new Card[players.size()];
        int maximumPlayer = 0;

        if(isTurnOf(p))
        {
            cardsOnTable[roundNo].addTopCard(c);
            turnOfPlayer++;
            

            if(turnOfPlayer % 4 == 0)
            {

                for(int i = deck2.length - 1; i >= 0; i--)
                {
                    deck2[i] = cardsOnTable[roundNo].getTopCard();
                }
                
                for(int i = 0; i < deck2.length; i++)
                {
                    if(deck2[i].compareTo(deck2[maximumPlayer]) == 1 )
                    {
                        maximumPlayer = i;
                    }

                }
                
                scoreCard.update(maximumPlayer,1);
                roundNo++;
                turnOfPlayer = 0;
            }

            return true;
            
        }

        return false;
    }
    
    
    
        
    /**
     * This method determines the turn of the players
     * @param p is the player that we want to know whether it's his/her turn or not
     * @return true if it's that player turn
    */
    public boolean isTurnOf( Player p)
    {
        int playerIndex;
        
        playerIndex = 0;
        for (int i = 0; i < players.size(); i++) 
        {
            if (players.get(i).getName().equals(p.getName())) 
            {
                playerIndex = i;
            }
        }
        if (playerIndex == turnOfPlayer) 
        {
            return true;
        }
        
        return false;
    }
     
    
    
    /**
     * This method determines whether the game is over or not
     * @return true if the game is over
    */
    public boolean isGameOver()
    {
        if(roundNo > 12)
        {
            return true;
        }
        return false;
    }
     
    
    
    /**
     * This method gives the score of the specified player
     * @param playerNumber is the player that we want to know his/her score
     * @return the score of the specified player
    */
    public int getScore( int playerNumber)
    {
        return scoreCard.getScore(playerNumber);
    }
    
    
        
    /**
     * This method gives the name of the player
     * @param playerNumber is the player that we want to know the name of 
     * @return the name of the specified player
    */
    public String getName( int playerNumber)
    {
        return players.get(playerNumber).getName();
    }
    
    
        
    /**
     * This method gives the round number
     * @return the round number
    */
    public int getRoundNo()
    {
        return roundNo;
    }
    
    
        
    /**
     * This method gives the player whose turn it is.
     * @return whose turn it is
    */
    public int getTurnOfPlayerNo()
    {
        
        return turnOfPlayer;
    }
    
            
    /**
     * This method gives the winners
     * @return the array of winners
    */
    public Player[] getWinners()
    {
        Player[] winners = new Player[scoreCard.getWinners().length];
        
        for(int i = 0; i < scoreCard.getWinners().length; i++)
        {
            winners[i] = players.get( scoreCard.getWinners()[i]);
        }
        
        
        return winners;
        
        
    }
    
    
            
    /**
     * This method gives the scores of every player in string form
     * @return the score card in string form
    */
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
    
}