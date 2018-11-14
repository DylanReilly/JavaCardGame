package cmpts_deck;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.Stack;
import java.util.StringTokenizer;

public class Deck 
{
    private Stack<Card>stack;
    private Card TopCard;

    public Deck(Stack<Card> deck, Card TopCard) 
    {
        this.stack = deck;
        this.TopCard = TopCard;
    }
    
    public Deck(Stack<Card> deck)
    {
        this.stack = stack;
    }
    
    public Deck()
    {}

    public Stack<Card> getStack() 
    {
        return stack;
    }

    public void setStack(Stack<Card> stack) 
    {
        this.stack = stack;
    }

    public Card getTopCard() 
    {
        return TopCard;
    }

    public void setTopCard(Card TopCard) 
    {
        this.TopCard = TopCard;
    }
    
    public Stack loadDeck() throws FileNotFoundException
    {
        String fileName = "deck";
        Stack<Card>myStack = new Stack();
        Scanner fIn = new Scanner(new File(fileName));
        while(fIn.hasNextLine())
        {
            String line = fIn.nextLine();
            StringTokenizer st = new StringTokenizer(line, ";");
            String suit = st.nextToken().trim();
            String value = st.nextToken().trim();
            Card card = new Card(suit, value);
            myStack.push(card);
        }
        return myStack;
    }
    
    public Stack flipDeck(Stack<Card> newDeck, Stack<Card> oldDeck)
    {
        Card topCard = oldDeck.pop();
        int size = oldDeck.size();
        for (int i = 0; i < size; i++) 
        {
            Card card = oldDeck.pop();
            newDeck.push(card);
        }
        return newDeck;
    }
    
    public void printDeck(Deck deck)
    {
        Stack<Card> stack = deck.getStack();
        for(int i = 0; i < stack.size(); i++)
        {
            System.out.println(stack.get(i).toString());
        }
    }
    
    public Stack shuffle(Deck deck)
    {
        Stack<Card> orgDeck = deck.getStack();
        ArrayList<Card>cards = new ArrayList();
        Stack<Card> newDeck = new Stack();
        int size = orgDeck.size();
        for (int i = 0; i < size; i++) 
        {
            Card card = orgDeck.pop();
            cards.add(card);
        }
        Random rand = new Random();
        for (int i = 0; i < cards.size();) 
        {
            Card card = cards.get(rand.nextInt(cards.size()));
            cards.remove(card);
            newDeck.push(card);
        }
        return newDeck;
    }
}
