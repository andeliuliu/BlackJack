/*
 * Card.java
 *
 * A blueprint class for objects that represent a single playing card
 * that has a rank and a suit.
 * 
 * completed by: Andrew Liu (andeliu@bu.edu)
 */

public class Card {
    /* constants for the ranks of non-numeric cards */
    public static final int ACE = 1;
    public static final int JACK = 11;
    public static final int QUEEN = 12;
    public static final int KING = 13;
    
    /* other constants for the ranks */
    public static final int FIRST_RANK = 1;
    public static final int LAST_RANK = 13;
    
    /* 
     * class-constant array containing the string representations
     * of all of the card ranks. 
     * The string for the numeric rank r is given by RANK_STRINGS[r].
     */
    public static final String[] RANK_STRINGS = {
      null, "A", "2", "3", "4", "5", "6",
      "7", "8", "9", "10", "J", "Q", "K"
    };
    
    /* 
     * class-constant array containing the char representations
     * of all of the possible suits.
     */
    public static final char[] SUITS = {'C', 'D', 'H', 'S'};

    public static int rankNumFor(String rank) {
      /* returns the integer value of the rank, but if it is 
       * not a rank within the class, it returns -1 
      */
      for(int i = 1; i <= 13; i++){
        if(RANK_STRINGS[i].equals(rank)){
          return i;
        }
      }
      return -1;
    }

    public static boolean isValidSuit(char suit){
      /* returns true or false based on whether the char
       * is a suit or not
       */
      for(int i = 0; i < SUITS.length; i++){
        if(SUITS[i] == suit){
          return true;
        }
      }
      return false;
    }

    private int rank;
    private char suit;

    public Card(int r, char s){
      /* a constructor that takes two parameters: 
      an integer specifying the card’s rank, 
      and a single character (a char) specifying the card’s suit 
      */
      if(rankNumFor(RANK_STRINGS[r]) > 0){
        rank = r;
      }
      else{
        throw new IllegalArgumentException("Invalid Card Rank");
      }
      if(isValidSuit(s) == true){
        suit = s;
      }
      else{
        throw new IllegalArgumentException("Invalid Card Suit");
      }
    }

    public Card(String combo){
      /* a constructor that takes 
      a single parameter: a two- or three-character string 
      that specifies the card to be created. */
      int lengthString = combo.length();
      char s = combo.charAt(lengthString-1);
      String r = combo.substring(0,lengthString - 1);
      if(rankNumFor(r) != -1 && isValidSuit(s)){
        rank = rankNumFor(r);
        suit = s;
      }
      else{
        throw new IllegalArgumentException("Invalid Card String");
      }
    }

    public int getRank(){
      /* returns the integer representing the Card object's rank */
      return rank;
    }

    public char getSuit(){
      /* returns the char representing the Card object's suit */
      return suit;
    }

    public boolean isAce(){
      /* returns true or false depending on whether the rank is an
       * Ace or not
       */
      if(getRank() == ACE){
        return true;
      }
      return false;
    }

    public boolean isFaceCard(){
      /* returns true or false depending on whether the rank is a face
       * card or not
       */
      if(getRank() == JACK || getRank() == QUEEN || getRank() == KING){
        return true;
      }
      return false;
    }

    public int getValue(){
      /* returns the value of a rank, but if it is a face card,
       * it returns 10
       */
      if(isFaceCard() == true){
        return 10;
      }
      return getRank();
    }

    public String toString(){
      /* returns a String representation of the Card object
      that can be used when printing it or concatenating 
      it to a String. */
      return RANK_STRINGS[rank] + "" + this.suit;
    }

    public boolean sameSuitAs(Card other){
      /*
       * takes a Card object as a parameter and determines if 
       * it is has the same suit as the called object, 
       * returning true if they have the same suit and false 
       * if they do not have the same suit. 
       */
      if(other == null){
        return false;
      }
      else if(this.suit == other.suit){
        return true;
      }
      return false;
    }
    
    public boolean equals(Card other){
      /* 
       * takes a Card object as a parameter and determines if it 
       * is equivalent to the called object, returning true if 
       * it is equivalent and false if it is not equivalent.
      */
      if(other == null){
        return false;
      }
      else if(this.rank == other.rank && this.suit == other.suit){
        return true;
      }
      return false;
    }
    public static void main(String[] args){
      System.out.println(rankNumFor("12"));
      System.out.println(isValidSuit('B'));

      Card c1 = new Card(1, 'H');
      System.out.println(c1);
      Card c2 = new Card(12, 'D');
      System.out.println(c2);

      System.out.println(c1.getRank());
      System.out.println(c1.getSuit());
      System.out.println(c1.isAce());

      System.out.println(c1.isFaceCard());




      

    }
    /* Put the rest of the class definition below. */
}
