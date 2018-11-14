package cmpts_deck;

import cmpts_players.Player;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class Main 
{
    public static Deck deck = new Deck();
    public static void main(String[] args) throws FileNotFoundException 
    {
        //variable declaration
        //******************************************************
        Scanner kb = new Scanner(System.in);
        Stack<Card> myStack = deck.loadDeck();
        Stack<Card> pile = new Stack();
        ArrayList<Player> players = new ArrayList();
        //******************************************************
        
        //deck setup
        //******************************************************
        deck.setStack(myStack);
        deck.setStack(deck.shuffle(deck));
        //******************************************************
        
        //game setup
        //******************************************************
        System.out.println("Enter number of players: ");
        int numplayers = kb.nextInt();
        for(int i = 0; i < numplayers; i++)
        {
            System.out.println("Enter player name: ");
            String name = kb.next();
            System.out.println("");
            int ID = i;
            Player p1 = makePlayer(name, ID);
            p1.dealHand(deck, p1);
            System.out.println("");
            players.add(p1);
        }
        //******************************************************
        
        //game loop
        //******************************************************
        Card topCard = deck.getStack().pop();
        pile.push(topCard);
        System.out.println("The top card is " + topCard.toString());
        
        while(checkForWinner(players) == false)
        {
            for(int i = 0; i < players.size(); i++)
            {
                Player currentPlayer = players.get(i);
                playCard(currentPlayer, pile, topCard);
                topCard = pile.peek();
                System.out.println("The top card is " + pile.peek());
                if(checkForWinner(players))
                {
                    break;
                }
            }
        }
        //******************************************************
        String name = " ";
        for(int i = 0; i < players.size(); i++)
        {
            int handSize = players.get(i).getHand().size();
            if(handSize == 0)
            {
                name = players.get(i).getName();
            }
        }
        System.out.println(name + " has won!");
        //******************************************************
    }
    //******************************************************
    public static Player makePlayer(String name, int ID)
    {
        ArrayList<Card>hand = new ArrayList();
        Player p1 = new Player(name, hand, ID);
        return p1;
    }
    //******************************************************
    public static void playCard(Player p1, Stack pile, Card topCard)
    {
        ArrayList<Card>hand = p1.getHand();
        Scanner kb = new Scanner(System.in);
        System.out.println("");
        System.out.println(p1.getName() + ", Choose card by position: ");
        for(int i = 0; i < hand.size(); i++)
        {
            System.out.println(i + ") " + hand.get(i));
        }
        System.out.println(hand.size() + ") To pickup a card.");
        System.out.println("");
        int choice = kb.nextInt();
        if(choice == hand.size())
        {
            if(deck.getStack().isEmpty())
                {
                    deck.flipDeck(deck.getStack(), pile);
                    pile.push(topCard);
                }
            takeCards(p1, 1, deck.getStack());
        }
        else
        {
            Card toPlay = hand.get(choice);
            if(canPlayCard(topCard, toPlay))
            {
                pile.push(toPlay);
                hand.remove(toPlay);
                System.out.println(p1.getName() + " has played " + toPlay.toString() + "\n");
            }
            else
            {
                if(deck.getStack().isEmpty())
                {
                    deck.flipDeck(deck.getStack(), pile);
                    pile.push(topCard);
                }
                System.out.println(p1.getName() + " has made a mistake, 2 cards!");
                takeCards(p1, 2, deck.getStack());
            }
        }
    }
    //******************************************************
    public static boolean checkForWinner(ArrayList<Player> players)
    {
        for(int i = 0; i < players.size(); i++)
        {
            int handSize = players.get(i).getHand().size();
            if(handSize == 0)
            {
                return true;
            }
        }
        return false;
    }
    //******************************************************
    public static boolean canPlayCard(Card topCard, Card toPlay)
    {
        if(!toPlay.getSuit().equals(topCard.getSuit()))
        {
            if(!toPlay.getValue().equals(topCard.getValue()))
            {
                return false;
            }
        }
        return true;
    }
    //******************************************************
    public static void takeCards(Player p1, int numCards, Stack<Card> deck)
    {
        for(int i = 0; i < numCards; i++)
        {
            
            p1.hand.add(deck.pop());
        }
    }
    //******************************************************
    public static void trickHandler(Card card, Player player)
    {
        if(card.getValue().equals("Ace"))
        {
            
        }
        else if(card.getValue().equals("2"))
        {
            takeCards(player, 2, deck.getStack());
        }
        else if(card.getValue().equals("8"))
        {
            
        }
        else if(card.getValue().equals("Jack"))
        {
            
        }
    }
}

