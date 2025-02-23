import java.util.ArrayList;

/**
 * The BrickMonteCarlo class is responsible for running simulations about how likely a player will get stuck (brick)
 * when all of their rare candies are in their prize pile.
 * @author Rachel Hussmann
 */
public class BrickMonteCarlo {

    /**
     * The runBrickSimulation runs the simulation to find out what percentage of the time the player gets stuck without
     * a rare candy in their hand.
     * @param numOfTrials The number of trials.
     * @return An ArrayList of doubles equal to the percentages of getting stuck.
     */
    public ArrayList<Double> runBrickSimulation(int numOfTrials){

        //Initialize the ArrayList
        ArrayList<Double> percentages = new ArrayList<>();

        //Run through the trials
        for(int i = 1; i <= 4; i++){

            //Increment the number of rare candies in the deck as i increments
            int numOfRareCandies = i;

            //Number of energies is equal to 30 (the total number of cards in the deck) minus i (the number of candies)
            int numOfEnergies = 30;

            //Number of pokemon to be added to the deck
            int numOfPokemon = 30 - i;

            //Run the trial and add the percentage to the percentages ArrayList
            percentages.add(getBrickChance(numOfRareCandies, numOfPokemon, numOfEnergies, numOfTrials));
        }

        //Return the ArrayList
        return percentages;
    }

    /**
     * The getBrickChance method calculates how many times the player's gets stuck when all rare candies are in their
     * prize pool.
     * @param numOfTrainer The number of trainer (rare candy) cards to put in the deck.
     * @param numOfPokemon The number of pokemon cards to be put in the deck.
     * @param numOfEnergies The number of energy cards to be put in the deck.
     * @param numOfTrials The number of trials to be run.
     * @return The percentage of times the player got stuck with all rare candy cards being in the prize pool.
     */
    public double getBrickChance(int numOfTrainer, int numOfPokemon, int numOfEnergies, int numOfTrials){

        //Initializes the variables that will be used for the simulations
        int numberOfBricks = 0;
        Deck d = new Deck();
        Card tester = new Card();

        //Run the simulation for the designated number of trials
        for (int i = 0; i < numOfTrials; i++){

            //Use the generateDeckRareCandy method to create the deck needed for the trial
            d.generateDeckRareCandy(numOfPokemon, numOfEnergies, numOfTrainer);

            //Use the shuffle method to shuffle the created deck
            d.shuffle();

            ArrayList<Card> hand = new ArrayList<>();
            //For the number of cards in a hand
            for(int j = 0; j < 7; j++){

                //Pick the top card from the deck and add it to the hand
                hand.add(d.pickTopCard());
            }

            //Checks for a mulligan
            while(!tester.checkForMulligan(hand)){

                //Add the chosen cards back into the deck
                for(Card c : hand){
                    d.getDeckOfCards().add(c);
                }

                //Shuffle the deck again
                d.shuffle();

                hand.clear();

                //For the number of cards in a hand
                for(int j = 0; j < 7; j++){

                    //Pick the top card from the deck and add it to the hand
                    hand.add(d.pickTopCard());
                }

            }

            ArrayList<Card> prizePool = new ArrayList<>();
            //Add cards to the prize pool
            for(int j = 0; j < 6; j++){
                prizePool.add(d.pickTopCard());
            }

            //Initialize the variable to count how many rare candies are in the prize pool
            int candiesInPrize = 0;

            //Iterate through the prizepool
            for (Card c: prizePool){

                String type = c.getTypeOfCard();

                //Check if the current card is a trainer card
                if(type.equals("Trainer")){

                    Trainer t = c.getTrainer();

                    String nameOfCard = t.getNameOfCard();

                    //Check if the trainer card is a Rare Candy
                    if(nameOfCard.equals("Rare Candy")){

                        //If it is, increment the candiesInPrize variable by one
                        candiesInPrize++;
                    }
                }
            }

            //If the number of candies in the prize pool are the same as the number of trainer cards (which are all
            // rare candies)
            if (candiesInPrize == numOfTrainer){

                //Then increment the numberofBricks variable because the player is stuck
                numberOfBricks++;
            }

        }

        //After all the trials have been run, return the percentage value of the number of bricks
        return ((double)numberOfBricks/numOfTrials)*100.00;
    }

}
