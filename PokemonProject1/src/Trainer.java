/**
 * The Trainer class holds information about trainer cards for a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class Trainer extends Card{

    private String typeOfTrainerCard;
    private String nameOfCard;
    private String descriptionOfCard;

    /**
     * Getter for the typeOfTrainerCard variable.
     * @return The type of trainer card.
     */
    public String getTypeOfTrainerCard() {
        return typeOfTrainerCard;
    }

    /**
     * Setter for the typeOfTrainerCard variable.
     * @param typeOfTrainerCard The new type of trainer card.
     */
    public void setTypeOfTrainerCard(String typeOfTrainerCard) {
        this.typeOfTrainerCard = typeOfTrainerCard;
    }

    /**
     * Getter for the nameOfCard variable.
     * @return The name of the trainer card.
     */
    public String getNameOfCard() {
        return nameOfCard;
    }

    /**
     * Setter for the nameOfCard variable.
     * @param nameOfCard The new name of the trainer card.
     */
    public void setNameOfCard(String nameOfCard) {
        this.nameOfCard = nameOfCard;
    }

    /**
     * Getter for the descriptionOfCard variable.
     * @return The description of the trainer card.
     */
    public String getDescriptionOfCard() {
        return descriptionOfCard;
    }

    /**
     * Setter for the descriptionOfCard variable.
     * @param descriptionOfCard The new description for the trainer card.
     */
    public void setDescriptionOfCard(String descriptionOfCard) {
        this.descriptionOfCard = descriptionOfCard;
    }

}
