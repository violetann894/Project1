import java.util.Random;

/**
 * The PokeBall class is a trainer card that can be used in a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class PokeBall extends Trainer{

    /**
     * Default constructor
     */
    public PokeBall(){
        setNameOfCard("Poke Ball");
        setTypeOfCard("Trainer");
        setTypeOfTrainerCard("Item");
        setDescriptionOfCard("Flip a coin. If heads, search your deck for a Pokemon, reveal it, and put it into your" +
                "hand. Then, shuffle your deck.");
        setTrainer(this);
    }

    /**
     * The useAbility method uses Poke Ball's special ability of "Flip a coin. If heads, search your deck for a Pokemon,
     * reveal it, and put it into your hand. Then, shuffle your deck."
     * @param playerWhoUsedCard The player who used the card.
     */
    @Override
    public void useAbility(Player playerWhoUsedCard){
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

            //Else, the coin flip is tails

            //Inform the player
            System.out.println("The coin shows tails. Card use failed");
            System.out.println();
        }

        //Remove the card from the hand because it has been used and add it to the discardPile
        playerWhoUsedCard.getHand().remove(this);
        playerWhoUsedCard.addCardToDiscard(this);
    }
}
