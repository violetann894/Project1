/**
 * The ProfsLetter class is a trainer card that can be used in a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class ProfsLetter extends Trainer{

    /**
     * Default constructor
     */
    public ProfsLetter(){
        setNameOfCard("Professor's Letter");
        setTypeOfTrainerCard("Supporter");
        setTypeOfCard("Trainer");
        setDescriptionOfCard("Search your deck for up to 2 basic energy cards, reveal them, and put them into your" +
                "hand. Shuffle your deck afterwards");
        setTrainer(this);
    }

    /**
     * The useAbility method uses Professor's Letter's special ability of "Search your deck for up to 2 basic
     * energy cards, reveal them, and put them into your hand. Shuffle your deck afterwards."
     * @param playerWhoUsedCard The player who used the card.
     */
    @Override
    public void useAbility(Player playerWhoUsedCard){
        //Inform the player
        System.out.println("Player used Professor's Letter");
        System.out.println();

        //Get the energies
        Energy energyOne = playerWhoUsedCard.getDeck().findFirstEnergy();
        Energy energyTwo = playerWhoUsedCard.getDeck().findFirstEnergy();

        //Check if the energies are null
        if(energyOne == null){

            //If energy one is null

            //Then no more energies are in the deck

            //Inform the player
            System.out.println("You have no more energies left in your deck!");
            System.out.println("Discarding card . . .");
            System.out.println();
        }else if(energyTwo == null){

            //If energy two is null

            //Then there is one energy in the deck

            //Inform the player
            System.out.println("You only have one energy left in your deck!");
            System.out.println("Putting that card in your hand . . .");
            System.out.println();

            //Remove the energy from the deck
            playerWhoUsedCard.getDeck().getDeckOfCards().remove(energyOne);

            //Inform the player
            System.out.println("Player picked one energy: " + energyOne.getType());
            System.out.println();

            //Give the player the one energy
            playerWhoUsedCard.getHand().add(energyOne);

        }else {

            //Remove both energies from the deck
            playerWhoUsedCard.getDeck().getDeckOfCards().remove(energyOne);
            playerWhoUsedCard.getDeck().getDeckOfCards().remove(energyTwo);

            //Inform the player
            System.out.println("Player picked two energies: " + energyOne.getType() + " and " + energyTwo.getType());
            System.out.println();

            //Add both energies to the player's hand
            playerWhoUsedCard.getHand().add(energyOne);
            playerWhoUsedCard.getHand().add(energyTwo);
        }

        //Remove the card from the hand because it has been used and add it to the discardPile
        playerWhoUsedCard.removeCardFromHand(this);
        playerWhoUsedCard.addCardToDiscard(this);
    }

}
