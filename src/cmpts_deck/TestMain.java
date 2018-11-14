/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cmpts_deck;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

/**
 *
 * @author DylanReilly
 */
public class TestMain 
{
    public static Deck deck = new Deck();
    public static void main(String[] args) throws FileNotFoundException 
    {
        //variable declaration
        //******************************************************
        Scanner kb = new Scanner(System.in);
        Stack<Card> myStack = deck.loadDeck();
        Stack<Card> pile = new Stack();
        //******************************************************
        
        //deck setup
        //******************************************************
        deck.setStack(myStack);
        System.out.println("Old deck");
        deck.printDeck(deck);
        System.out.println("");
        
        deck.setStack(deck.flipDeck(pile, deck.getStack()));
        System.out.println("New deck");
        for(int i = 0; i < pile.size(); i++)
        {
            System.out.println(pile.get(i).toString());
        }
    }
}
