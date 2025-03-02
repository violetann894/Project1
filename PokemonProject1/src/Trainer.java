/**
 * The Trainer class holds information about trainer cards for a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class Trainer extends Card{

    private String typeOfTrainerCard;
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

    /**
     * The useAbility method handles special abilities when a Trainer card is used.
     * @param playerWhoUsedCard The player who used the card.
     */
    public void useAbility(Player playerWhoUsedCard){
        System.out.println("This trainer card does not have a special ability.");
    }
}
