package cardgame;
import java.lang.Math;
import java.util.ArrayList;
// Cards - Maintains a collection of zero or more playing cards.
//         Provides facilities to create a full pack of 52 cards
//         and to shuffle the cards.
// author: İpek Tüfekçioğlu - Cem Hakverdi
// date: 21/02/2021
public class Cards
{
    final int NOOFCARDSINFULLPACK = 52;
    
    // properties
    public Card[] cards;
    int    valid;  // number of cards currently in collection
    
    // constructors
    public Cards( boolean fullPack)
    {
        cards = new Card[ NOOFCARDSINFULLPACK ];
        valid = 0;
        
        if ( fullPack)
            createFullPackOfCards();
    }
    
    
    
            
    /**
     * This constructor let us to create a card pack in any size
    */
    
    public Cards(int size)
    {
        cards = new Card[size];
        valid = 0;
    }
    
    // methods
    
    
            
    /**
     * This method takes the top card from players hand array and set that value to null
     * @return the top card from the player hand
    */
    public Card getTopCard()
    {
        Card tmp;

        if ( valid <= 0)
            return null;
        else
        {
            valid--;
            tmp = cards[valid];
            cards[valid] = null;
            return tmp;
        }
    }
    
    
            
    /**
     * This method gives the name of the player
     * @param c is the player that we want to know the name of 
     * @return the name of the specified player
    */
    public boolean addTopCard( Card c)
    {
        if ( valid < cards.length)
        {
            cards[valid] = c;   
            valid++;
            return true;
        }
        return false;
    }
    
    
            
    /**
     * This method creates a full pack of cards.
     * By using addTopCard method it create a deck which have 52 cards in it
    */
    private void createFullPackOfCards()
    {
        for(int i = 0; i <= 52; i++)
        {
            addTopCard( new Card(i) );
        }
        

    }
    
    
            
    /**
     * This method takes the card deck and shuffle it
     * After calling this method the card deck become randomized
    */
    public void shuffle()
    {
        //Card[] newCard = new Card[52];
        ArrayList<Card> newCard = new ArrayList<Card>();
        
        for(int i = 0; i < cards.length; i++ )
        {
            newCard.add(cards[i]);    
        }
        
        for(int i = 0; i < 52; i++)
        {
            int randomIndex = (int) (Math.random() * newCard.size());
            cards[i] = newCard.get(randomIndex);
            newCard.remove(randomIndex);
        }
    }
    
    

    
} // end class Cards
