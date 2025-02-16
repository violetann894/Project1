import java.util.ArrayList;

/**
 * The Card class holds information about the card that is in the deck.
 * @author Rachel Hussmann
 */
public class Card {

    private String typeOfCard;

    private Pokemon p;
    private Trainer t;
    private Energy e;

    /**
     * Default constructor for the Card class.
     */
    public Card(){
        typeOfCard = "None";
    }

    /**
     * Constructor for the Card class.
     * @param p The Pokemon object.
     */
    public Card(Pokemon p){
        typeOfCard = "Pokemon";
        this.p = p;
    }

    /**
     * Constructor for the Card class.
     * @param t The Trainer object.
     */
    public Card(Trainer t){
        typeOfCard = "Trainer";
        this.t = t;
    }

    /**
     * Constructor for the Card class.
     * @param e The Energy object.
     */
    public Card(Energy e){
        typeOfCard = "Energy";
        this.e = e;
    }

    /**
     * Getter method for the typeOfCard variable.
     * @return The type of card in a string variable.
     */
    public String getTypeOfCard() {
        return typeOfCard;
    }

    /**
     * Setter method for the typeOfCard variable
     * @param typeOfCard The new type of card.
     */
    public void setTypeOfCard(String typeOfCard) {
        this.typeOfCard = typeOfCard;
    }

    /**
     * The getP method returns the Pokemon object associated with the Card.
     * @return If the card is a Pokemon, it returns the Pokemon object. Otherwise, it returns null.
     */
    public Pokemon getP() {
        if(typeOfCard.equals("Pokemon")) {
            return p;
        }

        return null;
    }

    /**
     * The getT method returns the Trainer object associated with the Card.
     * @return If the card is a Trainer, it returns the Trainer object. Otherwise, it returns null.
     */
    public Trainer getT() {
        if(typeOfCard.equals("Trainer")) {
            return t;
        }

        return null;
    }

    /**
     * The getE method returns the Energy object associated with the Card.
     * @return If the card is an Energy, it returns the Energy object. Otherwise, it returns null.
     */
    public Energy getE() {
        if(typeOfCard.equals("Energy")) {
            return e;
        }

        return null;
    }

    /**
     * The checkForMulligan method checks to see if the current hand has no pokemon in it.
     * @param hand The hand of cards that needs to be checked.
     * @return A boolean value: true - if a mulligan has been detected, false = if no mulligan has been found.
     */
    public boolean checkForMulligan(ArrayList<Card> hand){

        //Initialize the boolean variable to check if the loop broke
        boolean broke = false;

        //Run through the cards in the hand
        for(Card c: hand){

            //Check to see if a pokemon card is in the hand
            if (c.getTypeOfCard().equals("Pokemon")){

                //Set the broke variable to true and break the loop
                broke = true;
                break;
            }
        }

        //If the loop broke, return true because a mulligan has been found
        if(broke){
            return true;
        }

        //Else return false
        return false;
    }
}
