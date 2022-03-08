package cardgame;

/**
 * Card - a single playing card
 * @author İpek Tüfekçioğlu - Cem Hakverdi
 *
 * @version 1.0
 */
public class Card
{
    // constants - to do in lectures
    final String[] SUITS = { "Hearts", "Diamonds", "Spades", "Clubs"};
    final String[] FACES = { "A", "2", "3", "4", "5",
                             "6", "7", "8", "9", "10",
                             "J", "Q", "K"};
    
    final int NOOFCARDSINSUIT = 13;
    
    // properties - to do in lectures
    int  cardNo;
    
    // constructors  - to do in lectures
    public Card( int faceValue, int suit )
    {
        cardNo = faceValue + suit * NOOFCARDSINSUIT;
    }
    
    public Card( int cardNumber)
    {
        cardNo = cardNumber;
    }
    
    
    /**
     * This method finds the face value of the card
     * @return the face value
    */
    public int getFaceValue()
    {
        return cardNo % NOOFCARDSINSUIT;
    }
    
    
    
    /**
     * This method find the suit of the card
     * @return the suit
    */
    public int getSuit()
    {
        return cardNo / NOOFCARDSINSUIT;
    }
    
    
    
    /**
     * This method is provide a string representation of the card
     * @return the string representation
    */
    public String toString()
    {
        return FACES[ getFaceValue() ] + " of " + SUITS[ getSuit() ];
    }
     
    
    
    /**
     * This method checks whether the 2 cards are equal or not
     * @param c is the card you want to compare
     * @return true if the cards are equal
    */
    public boolean equals( Card c)
    {
        if(c.getFaceValue() == this.getFaceValue())
        {
            return true;
        }
        return false;
    }
     
    
    
    /**
     * This method compares the 2 card in terms of their face values
     * @param c is the card you want to compare
     * @return 1 if the card is bigger than the given, -1 if the card is smaller and 0 if cards are equal
    */
    public int compareTo( Card c)
    {
        if(this.equals(c))
        {
            return 0;
        }
        else if(this.getFaceValue() > c.getFaceValue())
        {
            return 1;
        }
        else 
        {
            return -1;
        }
    }
}