/**
 * The Energy class represents an energy card in the Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class Energy extends Card{

    private String type;

    /**
     * Default constructor for the Energy class
     */
    public Energy(){
        type = "Colorless";
    }

    /**
     * The getType method returns the type of the energy the card is.
     * @return The type of energy the card is.
     */
    public String getType() {
        return type;
    }

    /**
     * The setType method accepts a string of the new type for the card.
     * @param type A string of the new type for the card.
     */
    public void setType(String type) {
        this.type = type;
    }

}
