package cmpts_deck;

import java.util.Objects;

public class Card 
{
    private String suit;
    private String value;

    public Card(String suit, String value) 
    {
        this.suit = suit;
        this.value = value;
    }
    
    public String getSuit()
    {
        return suit;
    }
    
    public void setSuit(String suit)
    {
        this.suit = suit;
    }

    public String getValue() 
    {
        return value;
    }

    public void setValue(String value) 
    {
        this.value = value;
    }

    @Override
    public String toString() 
    {
        return "The " + value + " of " + suit;
    }

    @Override
    public int hashCode() 
    {
        int hash = 7;
        hash = 97 * hash + Objects.hashCode(this.suit);
        hash = 97 * hash + Objects.hashCode(this.value);
        return hash;
    }

    @Override
    public boolean equals(Object obj) 
    {
        if (this == obj) 
        {
            return true;
        }
        if (obj == null) 
        {
            return false;
        }
        if (getClass() != obj.getClass()) 
        {
            return false;
        }
        final Card other = (Card) obj;
        if (!Objects.equals(this.suit, other.suit)) 
        {
            return false;
        }
        if (!Objects.equals(this.value, other.value)) 
        {
            return false;
        }
        return true;
    }
    
    
    
}
