package cardgame;

// Player - Simple card game player with name and hand of cards
// author: İpek Tüfekçioğlu - Cem Hakverdi
// date: 21/02/2021
public class Player
{
    // properties
    String name;
    Cards hand;
    
    // constructors
    public Player( String name)
    {
        this.name = name;
        hand = new Cards(false);
    }
    
    // methods
            
    /**
     * This method gives the name of the player
     * @return the name of the player
    */
    public String getName()
    {
        return name;
    }
    
    
    
    /**
     * This method adds a card to the player's hand
     * @param c is the card we want to add to the player's hand
    */
    public void add( Card c)
    {
        hand.addTopCard(c);
    }
    
    
            
    /**
     * This method plays to top card from the player's hand
     * @return the top card from the player's hand that played
    */
    public Card playCard()
    {
        Card topCard = this.hand.getTopCard();
        if(topCard != null)
        {
            return topCard;    
        }
        
        else
        {
            return null;
        }
        
        
    }
    
} // end class Player
