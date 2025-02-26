import java.util.Random;

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

        //Check the name of the card
        if(getNameOfCard().equals("Cynthia")){

            //If the card is Cynthia

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

        }else if(getNameOfCard().equals("Poke Ball")){

            //If the card is Poke ball

            //Inform the player
            System.out.println("Player used Poke Ball");
            System.out.println();

            //Create a new random object for the coin flip
            Random random = new Random();

            //Complete the coin flip and check if it is heads or tails
            int coinFace = random.nextInt(0, 2);
            if(coinFace == 0){

                //If heads

                //Inform the player
                System.out.println("The coin shows heads");
                System.out.println("Searching deck for pokemon . . .");
                System.out.println();

                //Get the first pokemon from the deck
                Pokemon firstPokemon = playerWhoUsedCard.getDeck().findFirstPokemon();

                //If the pokemon object is null
                if (firstPokemon == null) {

                    //There are no pokemon left in the deck

                    //Inform the player
                    System.out.println("You have no more pokemon left in your deck!");
                    System.out.println("Card discarded");
                    System.out.println();
                }else {

                    //Else, there is pokemon left in the deck

                    //Remove the pokemon from the deck
                    playerWhoUsedCard.getDeck().getDeckOfCards().remove(firstPokemon);

                    //Inform the player of the pokemon
                    System.out.println("Player picked " + firstPokemon.getNameOfCard());
                    System.out.println("Player is adding it to their hand and shuffling their deck");
                    System.out.println();

                    //Add the pokemon to the player's hand
                    playerWhoUsedCard.getHand().add(firstPokemon);

                    //Shuffle the player's deck
                    playerWhoUsedCard.getDeck().shuffle();

                }
            }else{

                //Else, the copin flip is tails

                //Inform the player
                System.out.println("The coin shows tails. Card use failed");
                System.out.println();
            }

            //Remove the card from the hand because it has been used and add it to the discardPile
            playerWhoUsedCard.getHand().remove(this);
            playerWhoUsedCard.addCardToDiscard(this);

        }else if(getNameOfCard().equals("X Speed")){

            //If the card is X Speed

            //Inform the player
            System.out.println("Player used X Speed");
            System.out.println();

            //Subtract one from the activePokemon retreat cost
            playerWhoUsedCard.getActivePokemon().subtractOneRetreatCost();

            //Remove the card from the hand because it has been used and add it to the discardPile
            playerWhoUsedCard.removeCardFromHand(this);
            playerWhoUsedCard.addCardToDiscard(this);

        }else if(getNameOfCard().equals("Professor's Letter")){

            //If the card is Professor's Letter

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

        }else if(getNameOfCard().equals("Professor's Research")){

            //If the card is Professor's Research

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

}
