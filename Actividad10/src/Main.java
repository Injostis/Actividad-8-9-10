import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static Deck myDeck;

    public static void main(String[] args) throws Exception {
        myDeck = createDeck();
        System.out.println("Bienvenido a Poker!");
        do{
            selectOption();
        }while(checkIfDeckEmpty() || tryAgain());
    }

    public static Deck createDeck(){
        Suit[] mySuits = {new Suit("Trébol", "Negro"),
                (new Suit("Espada", "Negro")),
                (new Suit("Corazón", "Rojo")),
                (new Suit("Diamante", "Rojo"))};
        String[] myValues = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        Deck myDeck = new Deck(new ArrayList<>());
        for(int i = 0; i < 4; i++){
            Suit currentSuit = mySuits[i];
            for(int j = 0; j < 13; j++){
                myDeck.getCards().add(new Card(currentSuit,myValues[j]));
            }
        }
        return myDeck;
    }

    public static void selectOption() throws Exception{
        boolean repeat = true;
        while(repeat){
            try{
                Scanner sc = new Scanner(System.in);
                System.out.println("Selecciona una opción:");
                System.out.print("1 Mezclar deck\n" +
                        "2 Sacar una carta\n" +
                        "3 Carta al azar\n" +
                        "4 Generar una mano de 5 cartas\n" +
                        "0 Salir\n");
                int answer = sc.nextInt();
                switch(answer){
                    case 0:
                        System.out.println("Hasta luego!");
                        System.exit(0);
                        break;
                    case 1:
                        myDeck.shuffle();
                        repeat = false;
                        break;

                    case 2:
                        System.out.println(myDeck.head());
                        System.out.println(myDeck.toString());
                        repeat = false;
                        break;

                    case 3:
                        System.out.println(myDeck.pick());
                        System.out.println(myDeck.toString());
                        repeat = false;
                        break;

                    case 4:
                        if(!checkIfDeckEmpty()) {
                            Card[] myHand = myDeck.hand();
                            for (int i = 0; i < myHand.length; i++) {
                                System.out.println(myHand[i]);
                            }
                            System.out.println(myDeck.toString());
                            repeat = false;
                        }
                        break;

                    default:
                        System.out.println("Opción inválida, vuelva a intentarlo.");
                }
            }catch(Exception e){
                System.out.println("Opción inválida, vuelva a intentarlo.");
            }
        }
    }

    public static boolean tryAgain() throws Exception{
        boolean tryAgain = false;
        boolean repeat = true;
        try{
            while(repeat){
                Scanner sc = new Scanner(System.in);
                System.out.println("Quieres escoger otra opción? (Ss/Nn)");
                char answer = sc.next().charAt(0);
                switch(answer){
                    case 'S':
                        tryAgain = true;
                        repeat = false;
                        break;
                    case 's':
                        tryAgain = true;
                        repeat = false;
                        break;
                    case 'N':
                        System.out.println("Hasta luego!");
                        repeat = false;
                        break;
                    case 'n':
                        System.out.println("Hasta luego!");
                        repeat = false;
                        break;
                    default:
                        System.out.println("Opción inválida, vuelva a intentarlo.");
                }
            }
        }catch (Exception e){
            System.out.println("Opción inválida, vuelva a intentarlo.");
        }
        return tryAgain;
    }

    public static boolean checkIfDeckEmpty() throws Exception{
        boolean empty = myDeck.getCards().isEmpty();
        boolean repeat = true;
        if (empty) {
            try{
                while (repeat) {
                    Scanner sc = new Scanner(System.in);
                    System.out.println("Deck vacío. Desea rellenarlo? (Ss/Nn)");
                    char answer = sc.next().charAt(0);
                    switch (answer) {
                        case 'S':
                            myDeck = createDeck();
                            System.out.println("Deck repuesto!");
                            repeat = false;
                            break;
                        case 's':
                            myDeck = createDeck();
                            System.out.println("Deck repuesto!");
                            repeat = false;
                            break;
                        case 'N':
                            System.out.println("Hasta luego!");
                            System.exit(0);
                            break;
                        case 'n':
                            System.out.println("Hasta luego!");
                            System.exit(0);
                            break;
                        default:
                            System.out.println("Opción inválida, vuelva a intentarlo.");
                    }
                }
            }catch(Exception e){
                System.out.println("Opción inválida, vuelva a intentarlo.");
            }
        }
        return empty;
    }
}