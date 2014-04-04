// Ali Seybold
// COMS1004
// This class creates objects with variables for suit and rank to imitate playing cards.  
// It is to be used by the Deck, Hand, and Game classes.
// Its methods include compareTo (compares cards to each other) and toString (names cards with words).

import java.lang.String;

public class Card implements Comparable<Card>
{
  
  // Constants
  final int CLUBS = 1;
  final int DIAMONDS = 2;
  final int HEARTS = 3;
  final int SPADES = 4;
  
  // Instance Variables
  public int suit;
  public int rank;
  
  // make a new card
  public Card(int s, int r)
  {
    suit = s;
    rank = r;
  }
  
  // compareTo class which compares by rank and then suit to find the high card.  Returns 1 if this card is higher than that card, 0 if they are the same card, -1 if that card is higher than this card
  public int compareTo(Card c)
  {
    int higher = 2; // I made it a 2 instead of a zero or something in case I need to check if this is working right later
    if (this.rank > c.rank) higher = 1;
    if (this.rank == c.rank)
    {
      if (this.suit > c.suit) higher = 1;
      if (this.suit == c.suit) higher = 0;
      if (this.suit < c.suit) higher = -1;
    }
    if (this.rank < c.rank) higher = -1;
    return higher;
  }
  
  public String toString()
  {
    // String rank
    String rankname = "";
    if (this.rank == 1) rankname = "ace";
    if (this.rank == 2) rankname = "two";
    if (this.rank == 3) rankname = "three";
    if (this.rank == 4) rankname = "four";
    if (this.rank == 5) rankname = "five";
    if (this.rank == 6) rankname = "six";
    if (this.rank == 7) rankname = "seven";
    if (this.rank == 8) rankname = "eight";
    if (this.rank == 9) rankname = "nine";
    if (this.rank == 10) rankname = "ten";
    if (this.rank == 11) rankname = "jack";
    if (this.rank == 12) rankname = "queen";
    if (this.rank == 13) rankname = "king";
    // String suit
    String suitname = "";
    if (this.suit == 1) suitname = "clubs";
    if (this.suit == 2) suitname = "diamonds";
    if (this.suit == 3) suitname = "hearts";
    if (this.suit == 4) suitname = "spades";
    // All together
    String of = " of ";
    String cardname = rankname.concat(of).concat(suitname);
    return cardname;
  }

}