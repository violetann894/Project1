import java.util.ArrayList;

/**
 * The Card class holds information about the card that is in the deck.
 * @author Rachel Hussmann
 */
public class Card {

    private String typeOfCard;

    private Pokemon pokemon;
    private Trainer trainer;
    private Energy energy;

    /**
     * Default constructor for the Card class.
     */
    public Card(){
        typeOfCard = "None";
    }

    /**
     * Constructor for the Card class.
     * @param pokemon The Pokemon object.
     */
    public Card(Pokemon pokemon){
        typeOfCard = "Pokemon";
        this.pokemon = pokemon;
    }

    /**
     * Constructor for the Card class.
     * @param trainer The Trainer object.
     */
    public Card(Trainer trainer){
        typeOfCard = "Trainer";
        this.trainer = trainer;
    }

    /**
     * Constructor for the Card class.
     * @param energy The Energy object.
     */
    public Card(Energy energy){
        typeOfCard = "Energy";
        this.energy = energy;
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
     * Getter method for the pokemon variable
     * @return If the card is a Pokemon, it returns the Pokemon object. Otherwise, it returns null.
     */
    public Pokemon getPokemon() {
        if(typeOfCard.equals("Pokemon")) {
            return pokemon;
        }

        return null;
    }

    /**
     * Setter method for the pokemon variable
     * @param pokemon The new Pokemon card.
     */
    public void setPokemon(Pokemon pokemon){
        this.pokemon = pokemon;
    }

    /**
     * Getter method for the trainer variable
     * @return If the card is a Trainer, it returns the Trainer object. Otherwise, it returns null.
     */
    public Trainer getTrainer() {
        if(typeOfCard.equals("Trainer")) {
            return trainer;
        }

        return null;
    }

    /**
     * Setter for the trainer variable
     * @param trainer The new Trainer card.
     */
    public void setTrainer(Trainer trainer){
        this.trainer = trainer;
    }

    /**
     * The getEnergy method returns the Energy object associated with the Card.
     * @return If the card is an Energy, it returns the Energy object. Otherwise, it returns null.
     */
    public Energy getEnergy() {
        if(typeOfCard.equals("Energy")) {
            return energy;
        }

        return null;
    }

    /**
     * Setter method for the energy variable
     * @param energy The new Energy card.
     */
    public void setEnergy(Energy energy){
        this.energy = energy;
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
