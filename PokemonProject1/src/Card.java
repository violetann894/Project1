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
     *
     * @return
     */
    public Pokemon getP() {
        return p;
    }

    /**
     *
     * @param p
     */
    public void setP(Pokemon p) {
        this.p = p;
    }

    /**
     *
     * @return
     */
    public Trainer getT() {
        return t;
    }

    /**
     *
     * @param t
     */
    public void setT(Trainer t) {
        this.t = t;
    }

    /**
     *
     * @return
     */
    public Energy getE() {
        return e;
    }

    /**
     *
     * @param e
     */
    public void setE(Energy e) {
        this.e = e;
    }
}
