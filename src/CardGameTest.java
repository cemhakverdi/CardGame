import java.util.Scanner;
import cardgame.*;

// CardGameTest
// author: İpek Tüfekçioğlu - Cem Hakverdi
// date: 21/02/2021
public class CardGameTest
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        
        System.out.println( "Start of CardGameTest\n");
        
        // CONSTANTS
        
        // VARIABLES
        Card       c;
        Cards      cards;
        ScoreCard  scores;
        Player     p;
        CardGame   game;
        
        // PROGRAM CODE
        
        // test Card class
        c = new Card( 0);
        System.out.println( c);
        System.out.println();
        
        // test Cards class
        cards = new Cards( true);
        cards.addTopCard( c);

        cards.shuffle();

        
        // test ScoreCard class
        scores = new ScoreCard( 4);
        scores.update( 3, 1);
        scores.update( 1, 2);
        System.out.println( "\n" + scores );
        
        // test Player class
        
        Player  p1, p2, p3, p4;
        
        p1 = new Player( "p1");
        p2 = new Player( "p2");
        p3 = new Player( "p3");
        p4 = new Player( "p4");
        
        
        Card d = new Card(50);
        p1.add(c);
        p1.add(d);
        System.out.println(p1.getName());
        System.out.println(p1.playCard());
        
        
        // test CardGame class too?
        
        
        // Once you have all the bits working, complete the MyCardGame program
        // that provides a menu allowing any of the players to play their card,
        // an option to see the score card, and one to quit the game at any time.
        // When the game is over it should print out the winners.
        
        scan.close();
        System.out.println( "\nEnd of CardGameTest\n" );
        
    }
    
} // end of class CardGameTest
