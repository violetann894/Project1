import java.util.ArrayList;
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

        //This method runs through all the available cards

        if(getNameOfCard().equals("Cynthia")){
            System.out.println("Player used Cynthia");
            System.out.println();

            ArrayList<Card> hand = playerWhoUsedCard.getHand();
            Deck playerDeck = playerWhoUsedCard.getDeck();

            playerDeck.returnHandToDeck(hand);
            hand.clear();

            for(int i = 0; i < 6; i++) {
                hand.add(playerDeck.pickTopCard());
            }

            playerWhoUsedCard.setHand(hand);
            playerWhoUsedCard.setDeck(playerDeck);

            playerWhoUsedCard.addCardToDiscard(this);
        }else if(getNameOfCard().equals("Poke Ball")){
            System.out.println("Player used Poke Ball");
            System.out.println();

            Random random = new Random();

            int coinFace = random.nextInt(0, 2);

            Deck deck = playerWhoUsedCard.getDeck();
            ArrayList<Card> deckArray = playerWhoUsedCard.getDeck().getDeckOfCards();
            ArrayList<Card> hand = playerWhoUsedCard.getHand();

            if(coinFace == 0){
                System.out.println("The coin shows heads");

                System.out.println("Searching deck for pokemon . . .");
                System.out.println();

                Pokemon firstPokemon = deck.findFirstPokemon();

                if (firstPokemon == null) {
                    System.out.println("You have no more pokemon left in your deck!");
                    System.out.println("Card discarded");
                    System.out.println();
                }else {

                    deckArray.remove(firstPokemon);

                    System.out.println("Player picked " + firstPokemon.getNameOfCard());

                    System.out.println("Player is adding it to their hand and shuffling their deck");
                    System.out.println();

                    hand.add(firstPokemon);
                    playerWhoUsedCard.setHand(hand);
                    playerWhoUsedCard.getDeck().setDeckOfCards(deckArray);
                    playerWhoUsedCard.getDeck().shuffle();

                }
            }else{
                System.out.println("The coin shows tails. Card use failed");
                System.out.println();
            }

            ArrayList<Card> discardPile = playerWhoUsedCard.getDiscardPile();
            hand.remove(this);
            discardPile.add(this);
            playerWhoUsedCard.setDiscardPile(discardPile);
        }else if(getNameOfCard().equals("X Speed")){
            System.out.println("Player used X Speed");
            System.out.println();

            int retreatCost = playerWhoUsedCard.getActivePokemon().getRetreatCost();
            retreatCost -= 1;
            playerWhoUsedCard.getActivePokemon().setRetreatCost(retreatCost);

            ArrayList<Card> hand = playerWhoUsedCard.getHand();
            ArrayList<Card> discardPile = playerWhoUsedCard.getDiscardPile();
            hand.remove(this);
            discardPile.add(this);
        }else if(getNameOfCard().equals("Professor's Letter")){
            System.out.println("Player used Professor's Letter");
            System.out.println();
            ArrayList<Card> hand = playerWhoUsedCard.getHand();

            Energy energyOne = playerWhoUsedCard.getDeck().findFirstEnergy();

            ArrayList<Card> deckArray = playerWhoUsedCard.getDeck().getDeckOfCards();

            deckArray.remove(energyOne);

            playerWhoUsedCard.getDeck().setDeckOfCards(deckArray);

            Energy energyTwo = playerWhoUsedCard.getDeck().findFirstEnergy();

            deckArray.remove(energyTwo);

            playerWhoUsedCard.getDeck().setDeckOfCards(deckArray);

            System.out.println("Player picked two energies: " + energyOne.getType() + " and " + energyTwo.getType());
            System.out.println();

            hand.add(energyOne);
            hand.add(energyTwo);

            hand.remove(this);
            ArrayList<Card> discardPile = playerWhoUsedCard.getDiscardPile();
            discardPile.add(this);

            playerWhoUsedCard.setDiscardPile(discardPile);
        }else if(getNameOfCard().equals("Professor's Research")){

            System.out.println("Player used Professor's Research");
            System.out.println();

            ArrayList<Card> hand = playerWhoUsedCard.getHand();
            ArrayList<Card> discardPile = playerWhoUsedCard.getDiscardPile();

            for(Card c : hand) {
                discardPile.add(c);
            }

            playerWhoUsedCard.setDiscardPile(discardPile);

            hand.clear();

            Deck deck = playerWhoUsedCard.getDeck();

            playerWhoUsedCard.createHand();

            playerWhoUsedCard.setDeck(deck);
        }
    }

}
