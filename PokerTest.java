// Ali Seybold
// This class is for the grader.  Sorry if it's messed up or just not helpful.  Instructions on how to use 
// it are in the text.

public class PokerTest
{ 
  
  public static void main(String[] args) 
  {
    
    Deck d = new Deck();
    Hand h = new Hand();
    
    // To test that my deck is right
    d.deckCheck();
      
    // To test that my hand evaluation methods are right
    // input integers 1-13 for the ranks r1-r5; aces are rank 1
    // input integers 1-4 for the suit s1-s5; 1 = clubs, 2 = diamonds, 3 = hearts, 4 = spades
    int s1 = 1;
    int r1 = 1;
    
    int s2 = 1;
    int r2 = 13;
    
    int s3 = 1;
    int r3 = 12;
    
    int s4 = 1;
    int r4 = 11;
    
    int s5 = 1;
    int r5 = 10;
    
    h.hand[0] = new Card(s1, r1);
    h.hand[1] = new Card(s2, r2);
    h.hand[2] = new Card(s3, r3);
    h.hand[3] = new Card(s4, r4);
    h.hand[4] = new Card(s5, r5);
    h.sort();
    
    
    // this was to help me check my ace algorithm
    /*
    System.out.println(h.highestCard);
    System.out.println(h.secondLowestCard);
    System.out.println(h.lowestCard);*/
    
    System.out.println(h.bestHand());
  }
}