/**
 * The Cynthia class is a trainer card that can be used in a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class Cynthia extends Trainer{

    /**
     * Default constructor
     */
    public Cynthia(){
        setNameOfCard("Cynthia");
        setTypeOfCard("Trainer");
        setTypeOfTrainerCard("Supporter");
        setDescriptionOfCard("Shuffle your hand into your deck. Then, draw 6 cards");
        setTrainer(this);
    }

    /**
     * The useAbility method uses Cynthia's special ability of "Shuffle your hand into your deck. Then, draw 6 cards."
     * @param playerWhoUsedCard The player who used the card.
     */
    @Override
    public void useAbility(Player playerWhoUsedCard){
        //Tell the player
        System.out.println("Player used Cynthia");
        System.out.println();

        //Remove this card because it has been used
        playerWhoUsedCard.getHand().remove(this);

        //Return the player's hand to their deck
        playerWhoUsedCard.getDeck().returnHandToDeck(playerWhoUsedCard.getHand());

        //Check to see if there are enough cards in the deck
        if(playerWhoUsedCard.getDeck().getDeckOfCards().size() < 6){

            //If there are not enough cards in the deck

            //Inform the player
            System.out.println("You don't have enough cards in your deck!");
            System.out.println("Giving all of the cards left in deck . . .");

            //Give the player all of the cards left in their deck
            for(Card card : playerWhoUsedCard.getDeck().getDeckOfCards()){
                playerWhoUsedCard.getHand().add(card);
            }

            //Clear the deck since all cards have been added to the player's hand
            playerWhoUsedCard.getDeck().getDeckOfCards().clear();

        }else {

            //Give the player six cards back
            for (int i = 0; i < 6; i++) {
                playerWhoUsedCard.addCardToHand();
            }

        }

        //Add this card to the discard pile because it has been used
        playerWhoUsedCard.addCardToDiscard(this);
    }
}
