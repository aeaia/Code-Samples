// Ali Seybold
// COMS1004
// This class creates the Player object that controls the hand and the deck.  
// Methods include dealing the cards and redrawing.  It does what a person would do.

public class Player
{

  //Constants
  public final int HANDSIZE = 5;
  
  // Instance Variables
  Hand hand;
  Deck deck;
 
  public Player()
  {
    hand = new Hand();
    deck = new Deck();
  }

  //deal the cards
  public void deal()
  {
    this.deck.shuffle();
    for (int i = 0; i < 5; i++)
    {
      this.hand.fillHand(i, this.deck.deck[i]);
    }
    this.deck.top = this.deck.top + 5;
  }
 
  public void redraw(int[] a, int y)
  {
    for (int i = 0; i < y; i++)
    {
      this.hand.replace(a[i], this.deck.draw());
    }
  }
 
}
