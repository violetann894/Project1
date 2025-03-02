/**
 * The ProfsResearch class is a trainer card that can be used in a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class ProfsResearch extends Trainer{

    /**
     * Default constructor
     */
    public ProfsResearch(){
        setNameOfCard("Professor's Research");
        setTypeOfCard("Trainer");
        setTypeOfTrainerCard("Supporter");
        setDescriptionOfCard("Discard your hand and draw 7 cards.");
        setTrainer(this);
    }

    /**
     * The useAbility method uses Professor's Research's special ability of "Discard your hand and draw 7 cards."
     * @param playerWhoUsedCard The player who used the card.
     */
    public void useAbility(Player playerWhoUsedCard){
        //Inform the player
        System.out.println("Player used Professor's Research");
        System.out.println();

        //Check how many cards are left in the deck
        if(playerWhoUsedCard.getDeck().getDeckOfCards().size() >= 7) {

            //If the player has enough cards in the deck

            //Use the card like normal

            //Add all the cards from the player's hand to their discard pile
            for (Card card : playerWhoUsedCard.getHand()) {
                playerWhoUsedCard.addCardToDiscard(card);
            }

            //Clear the player's hand
            playerWhoUsedCard.getHand().clear();

            //Create a new hand for the player
            playerWhoUsedCard.createHand();

        }else{

            //Else, the player's deck does not have enough cards

            //Inform the player
            System.out.println("You don't have enough cards in your deck!");
            System.out.println("Adding all of the cards you have left into your hand . . .");

            //Add the cards from the player's hand to their discard pile
            for (Card card : playerWhoUsedCard.getHand()) {
                playerWhoUsedCard.addCardToDiscard(card);
            }

            //Clear the player's hand
            playerWhoUsedCard.getHand().clear();

            //Give the player all the cards from their deck
            for(Card card : playerWhoUsedCard.getDeck().getDeckOfCards()){
                playerWhoUsedCard.getHand().add(card);
            }

            //Clear the player's deck because it is now empty
            playerWhoUsedCard.getDeck().getDeckOfCards().clear();

        }

        //Add this card to the discard pile because it has been used
        playerWhoUsedCard.addCardToDiscard(this);
    }

}
