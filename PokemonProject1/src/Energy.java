import java.util.ArrayList;
import java.util.Scanner;

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
        setTypeOfCard("Energy");
        setNameOfCard("Colorless Energy");
        setEnergy(this);
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

    /**
     * The useEnergy method allows the player to use an energy and add it to one of their pokemon (either active or
     * benched)
     * @param player The player who placed the energy
     */
    public void useEnergy(Player player){
        //Ask the player which pokemon they want to give it to
        System.out.println("What pokemon do you want to add the energy to?");

        //Show the player their active pokemon and the pokemon in their bench
        System.out.println("Active pokemon: " + player.getActivePokemon() + " Benched pokemon: " +
                player.getBench());

        //Create an ArrayList that holds all the pokemon in the player's active slot and in their bench
        ArrayList<Card> allPokemon = new ArrayList<>();
        allPokemon.add(player.getActivePokemon());
        allPokemon.addAll(player.getBench());


        //Set a flag and initialize variable to hold the card when found
        boolean broke = false;
        Pokemon pokemonToBeUsed = null;

        //Loop until the player gives a valid response
        while (true) {

            //Accept user input
            Scanner userInput = new Scanner(System.in);
            String cardToFind = userInput.nextLine();

            //Loop through all the pokemon the player has placed
            for (Card card : allPokemon) {

                //Check to see if the card the player wants to use is in the list
                if (card.getNameOfCard().equalsIgnoreCase(cardToFind)) {

                    //If the name is equal to the player's input

                    //Grab the index of the card
                    int indexOfCard = allPokemon.indexOf(card);

                    //Assign the card to the temp variable created above
                    pokemonToBeUsed = (Pokemon) allPokemon.get(indexOfCard);

                    //Set the flag to true and break out of the loop
                    broke = true;
                    break;
                }
            }

            //Since we are in a double loop, check the flag variable
            if (broke) {

                //If the flag is true

                //Break out of the loop again
                break;
            }

            //If the player reached this point, it means they did not pick a card available

            //Inform the player
            System.out.println("You did not pick a valid option, please pick another card");
            System.out.println();
        }

        //Use the attachEnergy method to add the energy to the pokemon card chosen
        pokemonToBeUsed.attachEnergy(this);

        //Remove the energy card from the player's hand
        player.removeCardFromHand(this);

        //Inform the player of the action
        System.out.println("Added " + this.getNameOfCard() + " to " +
                pokemonToBeUsed.getNameOfCard());
        System.out.println();
    }

}
