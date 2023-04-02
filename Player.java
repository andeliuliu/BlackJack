import java.util.*;

public class Player {
    private String name;
    private Card[] hand = {};
    private int numCards; 

    public Player(String playerName){
        this.name = playerName;
        this.hand = new Card[Blackjack.MAX_CARDS_PER_PLAYER];
        this.numCards = 0; 
    }
    public String getPlayer(){
        return this.name;
    }

    public int getNumCards() {
        return this.numCards;
    }

    public String toString(){
        return this.name + "";
    }

    public void addCard(Card item){
        if(item == null) {
            throw new IllegalArgumentException();
        }
        else if(this.numCards == this.hand.length){
            throw new IllegalArgumentException();
        }
        else{
            this.hand[this.numCards] = item;
            this.numCards++;
        }
    }
    public Card getCard(int index){
        if(index < 0 || index > numCards){
            throw new IllegalArgumentException();
        }
        else{
            return this.hand[index];
        }
    }
    public int getHandValue(){
        int total = 0;
        int aceIndex = 0;
        int otherAces = 1;
        for(int i = 0; i < numCards; i++){
            if(this.getCard(i).getValue() == 1){
                if(total <= 10 && aceIndex == 0){
                    total += 11;
                    aceIndex +=1;

                }
                else if(aceIndex >= 1){
                    total += otherAces;
                }
             
            }
            else{
                total += this.getCard(i).getValue();
            }
        }
        if(total > 21 && aceIndex >= 1){
            total = total - 10;
        }
        int score = total;
        return score;
    }

    public void printHand(){
        for(int i = 0; i < numCards; i++){
            System.out.print(this.hand[i] + "  ");

        }
        System.out.println("(value = " + getHandValue() + ")");
    }

    public boolean hasBlackJack(){
        if(getHandValue() == 21 && this.numCards == 2){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean wantsHit(Scanner choice, Player number){
        System.out.println("Want another hit, " + this.name + "(Y/N)");
        String yesNo = choice.nextLine();
        if(yesNo.equals("Y") || yesNo.equals("y")){
            return true;
        }
        else{
            return false;
        }

    }
    public void discardCards(){
        this.hand = new Card[Blackjack.MAX_CARDS_PER_PLAYER];
        this.numCards = 0;
    }


}





