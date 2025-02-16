import java.util.ArrayList;

/**
 * The Simulations class is used for different statistical probability simulations.
 * @author Rachel Hussmann
 */
public class Simulations {

    /**
     * The runMulliganSimulation method runs the mulligan simulation
     * @param numOfTrials The number of trials the user would like to run
     * @return An ArrayList of doubles that contains the chance of mulligans happening
     */
    public ArrayList<Double> runMulliganSimulation(int numOfTrials){

        //Initialize the ArrayList
        ArrayList<Double> percentages = new ArrayList<>();

        //Run through the trials
        for(int i = 1; i <= 60; i++){

            //Increment the number of pokemon in the deck as i increments
            int numOfPokemon = i;

            //Number of energies is equal to 60 (the total number of cards in the deck) minus i (the number of pokemon)
            int numOfEnergies = 60 - i;

            //Run the trial and add the percentage to the percentages ArrayList
            percentages.add((getMulliganChance(numOfPokemon, numOfEnergies, numOfTrials)));
        }

        //Return the ArrayList
        return percentages;
    }

    /**
     * The getMulliganChance method accepts numbers for the monte carlo simulation and runs a certain number of trials.
     * @param numOfPokemon The number of pokemon in the deck.
     * @param numOfEnergies The number of energies in the deck.
     * @param numOfTrials The number of trials to be run.
     * @return A double value of the percentage of mulligans that happen in the trials.
     */
    public double getMulliganChance(int numOfPokemon, int numOfEnergies, int numOfTrials){

        //Initializes the variables that will be used for the simulations
        int numberOfMulligans = 0;
        Deck d = new Deck();
        ArrayList<Card> hand = new ArrayList<>();

        //Run the simulation for the designated number of trials
        for (int i = 0; i < numOfTrials; i++){

            //Use the generateDeck method to create the deck needed for the trial
            d.generateDeck(numOfPokemon, numOfEnergies);

            //Use the shuffle method to shuffle the created deck
            d.shuffle();

            //For the number of cards in a hand
            for(int j = 0; j < 7; j++){

                //Pick the top card from the deck and add it to the hand
                hand.add(d.pickTopCard());
            }

            //Initialize the variable for checking the number of pokemon
            int countOfPokemonHand = 0;

            //Initialize the variable to check if the loop breaks
            boolean broke = false;

            //Run through the cards in the hand
            for(Card c: hand){

                //If one of the cards in the hand is a pokemon card
                if (c.getTypeOfCard().equals("Pokemon")){

                    //Set the broke variable equal to true and break the loop
                    broke = true;
                    break;
                }
            }

            //If the above loop never broke
            if(!broke){

                //Increment the numberOfMulligans variable
                numberOfMulligans++;
            }

            //Clear the hand
            hand.clear();

            //Clear the deck
            d.getDeckOfCards().clear();
        }

        //After all the trials have been run, return the percentage value of the number of mulligans
        return ((double)numberOfMulligans/numOfTrials)*100.00;
    }

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
            int numOfEnergies = 30 - i;

            //Number of pokemon to be added to the deck
            int numOfPokemon = 30;

            //Run the trial and add the percentage to the percentages ArrayList
            percentages.add(getBrickChance(numOfRareCandies, numOfPokemon, numOfEnergies, numOfTrials));
        }

        //Return the ArrayList
        return percentages;
    }

    /**
     *
     * @param numOfTrainer
     * @param numOfPokemon
     * @param numOfEnergies
     * @param numOfTrials
     * @return
     */
    public double getBrickChance(int numOfTrainer, int numOfPokemon, int numOfEnergies, int numOfTrials){

        //Initializes the variables that will be used for the simulations
        int numberOfBricks = 0;
        Deck d = new Deck();
        ArrayList<Card> hand = new ArrayList<>();
        Card tester = new Card();
        ArrayList<Card> prizePool = new ArrayList<>();

        //Run the simulation for the designated number of trials
        for (int i = 0; i < numOfTrials; i++){

            //Use the generateDeck method to create the deck needed for the trial
            d.generateDeck(numOfPokemon, numOfEnergies, numOfTrainer);

            //Use the shuffle method to shuffle the created deck
            d.shuffle();

            //For the number of cards in a hand
            for(int j = 0; j < 7; j++){

                //Pick the top card from the deck and add it to the hand
                hand.add(d.pickTopCard());
            }

            while(!tester.checkForMulligan(hand)){

                //Add the chosen cards back into the deck
                for(Card c : hand){
                    d.getDeckOfCards().add(c);
                }

                //Shuffle the deck again
                d.shuffle();

                //For the number of cards in a hand
                for(int j = 0; j < 7; j++){

                    //Pick the top card from the deck and add it to the hand
                    hand.add(d.pickTopCard());
                }
            }

            //
            for(int j = 0; j < 6; j++){
                prizePool.add(d.pickTopCard());
            }

            //Initialize the variable to check if the loop breaks
            boolean broke = false;


            //Check all code below to make sure it works to for the problem.

            //Run through the cards in the hand
            for(Card c: hand){

                //If one of the cards in the hand is a pokemon card
                if (!c.getT().getNameOfCard().equals("Rare Candy")){

                    //Set the broke variable equal to true and break the loop
                    broke = true;
                    break;
                }
            }

            //If the above loop never broke
            if(!broke){

                //Increment the numberOfMulligans variable
                numberOfBricks++;
            }

            //Clear the hand
            hand.clear();

            //Clear the deck
            d.getDeckOfCards().clear();
        }

        //After all the trials have been run, return the percentage value of the number of mulligans
        return ((double)numberOfBricks/numOfTrials)*100.00;
    }

}
