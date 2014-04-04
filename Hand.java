// Ali Seybold
// COMS1004
// The Hand class creates an object with an array of cards and three instance variables for ease of hand evaluation.
// It also includes methods for changing which Card objects are in the Hand.
// There are methods to sort the hand by rank of the cards (and methods that allow this to happen), fill the array in the hand with cards,
// and determine how the hand would be scored.  
// Note: the sort method that has been block commented out of use was less neat than the used method, so I
// blocked it out but left it in case it could be useful later.  I don't want it to be graded.

import java.util.ArrayList;

import java.util.Collections;

public class Hand
{
  
  // Constants
  public final int HANDSIZE = 5;
  
  // Instance Variables
  Card[] hand;
  Card highestCard;
  Card lowestCard;
  Card secondLowestCard;
  
  public Hand()
  {
    hand = new Card[HANDSIZE];
    hand[0] = new Card(1, 1);
    hand[1] = new Card(1, 1);
    hand[2] = new Card(1, 1);
    hand[3] = new Card(1, 1);
    hand[4] = new Card(1, 1);
    highestCard = hand[0];
    secondLowestCard = hand[1];
    lowestCard = hand[2];
  }
  
  public void fillHand(int i, Card c)
  {
    this.hand[i] = c;
  }
  
  public void sort()
  {
    ArrayList<Card> a = new ArrayList<Card>();
    for (int i = 0; i < 5; i++)
    {
      a.add(i, this.hand[i]);
    }
    Collections.sort(a);
    for (int j = 0; j < 5; j++)
    {
      this.hand[j] = a.get(j);
    }
    this.highestCard = this.hand[4];
    this.secondLowestCard = this.hand[1];
    this.lowestCard = this.hand[0];
  }
  
  /*public void sort()
  {
    for (int i = 0; i < HANDSIZE - 1; i++)
    {
      int minPos = this.mininimumPosition(i);
      this.swap(minPos, i);
    }
    this.highestCard = this.hand[0];
    this.secondLowestCard = this.hand[3];
    this.lowestCard = this.hand[4];
  }
  
  private int mininimumPosition(int from)
  {
    int minPos = from;
    for (int i = from + 1; i < HANDSIZE; i++)
    {
      if (this.hand[i].compareTo(this.hand[from]) == 1) minPos = i;
    }
    return minPos;
  }*/
  
  public void swap(int i, int j)
  {
    Card temp = this.hand[i];
    this.hand[i] = this.hand[j];
    this.hand[j] = temp;
  }
  
  public void replace(int i, Card c)
  {
    this.hand[i] = c;
  }
  
  public String bestHand()
  {
    this.sort();
    boolean best = false;
    if (best == false)
    {
      String handName = "Royal Flush";
      best = this.royalFlush();
      if (best == true) return handName;
    }
    if (best == false)
    {
      String handName = "Straight Flush";
      best = this.straightFlush();
      if (best == true) return handName;
    }
    if (best == false)
    {
      String handName = "Four of a Kind";
      best = this.fourOfAKind();
      if (best == true) return handName;
    }
    if (best == false)
    {
      String handName = "Full House";
      best = this.fullHouse();
      if (best == true) return handName;
    }
    if (best == false)
    {
      String handName = "Flush";
      best = this.flush();
      if (best == true) return handName;
    }
    if (best == false)
    {
      String handName = "Straight";
      best = this.straight();
      if (best == true) return handName;
    }
    if (best == false)
    {
      String handName = "Three of a Kind";
      best = this.threeOfAKind();
      if (best == true) return handName;
    }
    if (best == false)
    {
      String handName = "Two Pair";
      best = this.twoPair();
      if (best == true) return handName;
    }
    if (best == false)
    {
      String handName = "Pair";
      best = this.pair();
      if (best == true) return handName;
    }
    if (best == false)
    {
      String handName = "High Card";
      return handName;
    }
    else return "something went wrong";
  }
  
  
  // Methods to determine if a Hand h is the hand of the method
  public boolean royalFlush()
  {
    if (this.straightFlush() == true
        && this.highestCard.rank == 13
        && this.lowestCard.rank == 1) return true;
    else return false;
  }
  
  public boolean straightFlush()
  {
    if (this.straight() == true && this.flush() == true) return true;
    else return false;
  }
  
  public boolean fourOfAKind()
  {
    if (this.matches() == 6) return true;
    else return false;
  }
  
  public boolean fullHouse()
  {
    if (this.matches() == 4) return true;
    else return false;
  }
  
  public boolean flush()
  {
    if (this.hand[0].suit == this.hand[1].suit 
        && this.hand[0].suit == this.hand[2].suit 
        && this.hand[0].suit == this.hand[3].suit 
        && this.hand[0].suit == this.hand[4].suit) return true;
    else return false;
  }
  
  public boolean straight()
  {
    if (this.lowestCard.rank != 1
        && this.matches() == 0
        && (this.highestCard.rank - this.lowestCard.rank) == 4) return true;
    if (this.lowestCard.rank == 1
        && this.secondLowestCard.rank == 10
        && this.matches() == 0
        && (14 - this.secondLowestCard.rank) == 4) return true;
    if (this.lowestCard.rank == 1
        && this.secondLowestCard.rank == 2
        && this.matches() == 0
        && (this.highestCard.rank - this.lowestCard.rank) == 4) return true;
    else return false;
  }
  
  public boolean threeOfAKind()
  {
    if (this.matches() == 3) return true;
    else return false;
  }
  
  public boolean twoPair()
  {
    if (this.matches() == 2) return true;
    else return false;
  }
  
  public boolean pair()
  {
    if (this.matches() == 1) return true;
    else return false;
  }
  
  public int matches()
  {
    int matches = 0;
    for (int i = 0; i < HANDSIZE; i++)
    {
      for (int j = i + 1; j < HANDSIZE; j++)
      {
        if (this.hand[i].rank == this.hand[j].rank) matches++;
      }
    }
    return matches;
  }
  
}





















