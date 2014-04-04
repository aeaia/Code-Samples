// Ali Seybold
// COMS1004
// This class makes a deck of Card objects.
// I have included the methods shuffle, swap, and draw to control the deck.
// I have also included a method for the grader (or a later user) to print the cards in the deck and make
// sure they have the desired attributes.  This method (deckCheck) is not used by the project.  


import java.util.Random;

public class Deck
{

  // Constants
  final public int NUMRANKS = 13;
  final public int NUMSUITS = 4;
  final public int NUMCARDS = 52;
  public Random r = new Random();
  
  // Instance Variables
  Card[] deck;
  int top;
  
  public Deck()
  {
    deck = new Card[NUMCARDS];
    int k = 0;
    for (int i = 1; i <= NUMSUITS; i++)
    {
      for (int j = 1; j <= NUMRANKS; j++)
      {
        deck[k] = new Card(i, j);
        //Check to make sure deck is populated correctly
        //System.out.println(deck[k].toString());
        k++;
      }
    }
    top = 0;
  }
  
  // Shuffle the deck
  public void shuffle()
  {
    for (int i = 0; i < 1000; i ++)
    {
      int a = r.nextInt(NUMCARDS);
      int b = r.nextInt(NUMCARDS);
      this.swap(a, b);
    }
    this.top = 0;
  }
  
  // Swap two cards
  public void swap(int a, int b)
  {
    Card temp = this.deck[a];
    this.deck[a] = this.deck[b];
    this.deck[b] = temp;
  }
  
  // Draw a card off the top
  public Card draw()
  {
    Card c = this.deck[this.top];
    this.top = this.top + 1;
    return c;
  }
  
  public void deckCheck()
  {
    for (int i = 0; i < NUMCARDS; i++)
    {
      System.out.println(this.deck[i].rank + "    " + this.deck[i].suit + "    " + i);
    }
  }
  
}





















