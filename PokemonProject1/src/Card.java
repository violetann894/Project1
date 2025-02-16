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
}
