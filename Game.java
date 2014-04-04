// Ali Seybold
// COMS1004
// The game class runs the poker simulation.  It creates a player and directs the program user to play.  

import java.util.Scanner;

public class Game
{

  public static void main(String[] args) 
  {
    
    // Initialization
    Scanner input = new Scanner(System.in);
    
    // Introduction.
    System.out.println("Welcome to video poker.  You have been dealt the following five cards:");
    Player player = new Player();
    player.deal();
    for (int i = 0; i < 5; i++)
    {
      System.out.println(player.hand.hand[i].toString());
    }
    
    // Ask to redraw
    System.out.println("Would you like to replace any cards? (Answer 1 for yes or 0 for no.)");
    int y = input.nextInt();
    if (y == 0) 
    {
      String finalHand = player.hand.bestHand();
      System.out.println(finalHand + "!  Thank you for playing.");
    }
    if (y == 1)
    {
      System.out.println("How many cards would you like to replace?");
      y = input.nextInt();
      if (y == 5)
      {
        int[] a = {0, 1, 2, 3, 4};
        player.redraw(a, y);
      }
      else
      {
        int[] a = new int[y];
        int i = 0;
        int j = 0;
        while (j < y)
        {
          System.out.println("Replace the " + player.hand.hand[i].toString() + "? (Answer 1 for yes or 0 for no.)");
          int z = input.nextInt();
          if (z == 0) i++;
          if (z == 1)
          {
            a[j] = i;
            j++;
            i++;
          }
        }
        player.redraw(a, y);
      }
      System.out.println("Your new hand is :");
      for (int i = 0; i < 5; i++)
      {
        System.out.println(player.hand.hand[i].toString());
      } 
      String finalHand = player.hand.bestHand();
      System.out.println(finalHand + "!  Thank you for playing.");
    }
  }
}
















