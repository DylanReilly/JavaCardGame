package cmpts_players;

import cmpts_deck.Card;
import cmpts_deck.Deck;
import java.util.ArrayList;
import java.util.Stack;


public class Player 
{
    private String name;
    public ArrayList<Card>hand;
    private int ID;

    public Player(String name, ArrayList<Card> hand, int ID) 
    {
        this.name = name;
        this.hand = hand;
        this.ID = ID;
    }
    
    public Player()
    {}
    
    public Player(String name, int ID)
    {
        this.name = name;
        this.ID = ID;
    }

    public String getName() 
    {
        return name;
    }

    public void setName(String name) 
    {
        this.name = name;
    }

    public ArrayList<Card> getHand() 
    {
        return hand;
    }

    public void setHand(ArrayList<Card> hand) 
    {
        this.hand = hand;
    }

    public int getID() 
    {
        return ID;
    }

    public void setID(int ID) 
    {
        this.ID = ID;
    }
    
    public void dealHand(Deck deck, Player player)
    {
        for(int i = 0; i < 5; i++)
        {
            Card card = deck.getStack().pop();
            player.hand.add(card);
        }
        for (int i = 0; i < hand.size(); i++) 
        {
            System.out.println(hand.get(i));
        }
    }
    
    
}
