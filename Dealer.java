import java.util.*;

public class Dealer extends Player {
    
    private boolean reveal;

    public Dealer(){
        super("dealer");
        this.reveal = false;
    }

    public void revealFirstCard(){
        this.reveal = true;
    }

    public void printHand(){
        if(this.reveal == false){
            System.out.print("XX" + "  ");
            for(int i = 1; i < getNumCards(); i++){
                System.out.print(getCard(i) + "  ");
    
            }
            System.out.println();
        }
        else{
            for(int i = 0; i < getNumCards(); i++){
                System.out.print(getCard(i) + "  ");
    
            }
            System.out.println("(value = " + getHandValue() + ")");
        }

    }
    
    public boolean wantsHit(Scanner choice, Player user){
        if(user.getHandValue() < 17 && (this.getHandValue() <= user.getHandValue())){
            return true;
        }
        else if(user.getHandValue() >= 17 && user.getHandValue() < 21 && (this.getHandValue() <= user.getHandValue())){
            return true;
        }
        else if(user.getHandValue() == 21 && user.getNumCards() == 2){
            return false;
        }
        else{
            return false;
        }
    }
    public void discardCards(){
        super.discardCards();
        reveal = false;
    }    
}
