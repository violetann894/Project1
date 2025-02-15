/**
 * The Card class holds information about the card that is in the deck.
 * @author Rachel Hussmann
 */
public class Card {

    private String typeOfCard;
    private Pokemon p;
    private Trainer t;
    private Energy e;

    public Card(){
        typeOfCard = "None";
    }

    /**
     *
     * @param p
     */
    public Card(Pokemon p){
        typeOfCard = "Pokemon";
        this.p = p;
    }

    /**
     *
     * @param t
     */
    public Card(Trainer t){
        typeOfCard = "Trainer";
        this.t = t;
    }

    /**
     *
     * @param e
     */
    public Card(Energy e){
        typeOfCard = "Energy";
        this.e = e;
    }

    public String getTypeOfCard() {
        return typeOfCard;
    }

    public void setTypeOfCard(String typeOfCard) {
        this.typeOfCard = typeOfCard;
    }
}
