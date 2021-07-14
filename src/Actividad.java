import jdk.internal.org.objectweb.asm.tree.InsnList;

import java.awt.*;
import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
class Deck {

    private final String[] PALO = {"corazones", "diamantes", "trébol", "picas"};
    private final String[] COLOR = {"rojo", "negro"};
    private final String[] VALOR = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "A", "J", "Q", "K"};

    private static ArrayList<Card> deck;
    public Deck() {
        deck = new ArrayList<Card>();
        for (int palo = 0; palo < 2; palo++)
            for (int valor = 0; valor < VALOR.length; valor++)
                deck.add(new Card(PALO[palo], COLOR[0], VALOR[valor]));
        for (int palo = 2; palo < 4; palo++)
            for (int valor = 0; valor < VALOR.length; valor++)
                deck.add(new Card(PALO[palo], COLOR[1], VALOR[valor]));
    }



    public static void  shuffle() {
        Collections.shuffle(deck);
        System.out.println("Se mezcló el Deck.");
        for (Card elemento : deck) {
            System.out.print(elemento + " / ");
        }
    }
    public static void head(){
        System.out.println(deck.get(0));
        deck.remove(0);
        System.out.println("Quedan " + deck.size() + " cartas");
    }
    public void pick() {
        Random random = new Random();
        System.out.println(deck.get(random.nextInt(deck.size())));
        deck.remove(random.nextInt(deck.size()));
        System.out.println("Quedan " + deck.size() + " cartas");
    }
    public void hand() {
        for(int i=0; i<=4; i++){
            System.out.println(deck.get(i));
        }
        for(int i=0; i<=4; i++){
            deck.remove(i);
        }
        System.out.println("Quedan " + deck.size()+ " cartas");
    }

}
class Card {
    private String Palo;
    private String valor;
    private String Color;

    public Card(String Palo, String valor,String Color) {
        super();
        this.Palo=Palo;
        this.valor= valor;
        this.Color= Color;
    }
    @Override
    public String toString() {
        return "{Palo: " + Palo + "} " + "{Color: " + Color +
                "} " + "{Valor: " + valor+"}";
    }

}
public class Actividad {
    public static void main(String[] args){

        Deck deck = new Deck();


        System.out.println("\n");
        deck.shuffle();
        System.out.println("\n");
        deck.head();
        System.out.println("\n");
        deck.pick();
        System.out.println("\n");
        deck.hand();
    }
}

