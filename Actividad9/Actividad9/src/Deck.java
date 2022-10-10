import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<Card> cards;

    public Deck() {
    }

    public Deck(ArrayList<Card> myCards) {
        this.cards = myCards;
    }

    public ArrayList<Card> getCards() {
        return cards;
    }

    public void setCards(ArrayList<Card> cards) {
        this.cards = cards;
    }

    @Override
    public String toString() {
        return "Deck size = " + cards.size();
    }

    public void showCards(){
        for(int i = 0; i < cards.size(); i++){
            System.out.println(cards.get(i).toString());
        }
        System.out.println(this.toString());
    }

    public void shuffle(){
        Collections.shuffle(cards);
        System.out.println("Se mezcló el Deck");
    }

    public Card head(){
        Card myCard = cards.get(0);
        cards.remove(0);
        return myCard;
    }

    public Card pick(){
        int index = (int)(Math.random() * cards.size());
        Card myCard = cards.get(index);
        cards.remove(index);
        return myCard;
    }
    public Card[] hand(){
        Card myHand[] = {this.pick(), this.pick(), this.pick(), this.pick(), this.pick()};
        return myHand;
    }
}
