import java.util.ArrayList;

public class Main {
    public static Deck myDeck;

    public static void main(String[] args) {
        myDeck = createDeck();

        System.out.println(myDeck.toString());
        myDeck.shuffle();
        System.out.println("-------------------------------");

        System.out.println("Primera carta " + myDeck.head());
        System.out.println(myDeck.toString());
        System.out.println("-------------------------------");

        System.out.println("Carta aleatoria " + myDeck.pick());
        System.out.println(myDeck.toString());
        System.out.println("-------------------------------");

        Card myHand[] = myDeck.hand();
        System.out.println("Mi mano");
        for(int i = 0; i < myHand.length;i++){
            System.out.println(myHand[i]);
        }
        System.out.println(myDeck.toString());
    }

    public static Deck createDeck(){
        Suit[] mySuits = {new Suit("Trébol", "Negro"),
                (new Suit("Espada", "Negro")),
                (new Suit("Corazon", "Rojo")),
                (new Suit("Diamante", "Rojo"))};
        String[] myValues = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K"};
        Deck myDeck = new Deck(new ArrayList<Card>());
        for(int i = 0; i < 4; i++){
            Suit currentSuit = mySuits[i];
            for(int j = 0; j < 13; j++){
                myDeck.getCards().add(new Card(currentSuit, myValues[j]));
            }
        }
        return myDeck;
    }
}