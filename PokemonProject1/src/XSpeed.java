/**
 * The XSpeed class is a trainer card that can be used in a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class XSpeed extends Trainer{

    /**
     * Default Constructor
     */
    public XSpeed(){
        setNameOfCard("X Speed");
        setTypeOfTrainerCard("Item");
        setTypeOfCard("Trainer");
        setDescriptionOfCard("During this turn, the retreat cost of your active pokemon is one less");
        setTrainer(this);
    }

    /**
     * The useAbility method uses X Speed's special ability of "During this turn, the retreat cost of your active
     * pokemon is one less."
     * @param playerWhoUsedCard The player who used the card.
     */
    @Override
    public void useAbility(Player playerWhoUsedCard){
        //Inform the player
        System.out.println("Player used X Speed");
        System.out.println();

        //Subtract one from the activePokemon retreat cost
        playerWhoUsedCard.getActivePokemon().subtractOneRetreatCost();

        //Remove the card from the hand because it has been used and add it to the discardPile
        playerWhoUsedCard.removeCardFromHand(this);
        playerWhoUsedCard.addCardToDiscard(this);
    }

}
