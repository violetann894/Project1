import java.util.ArrayList;

/**
 * The Simulations class is used for different statistical probability simulations.
 * @author Rachel Hussmann
 */
public class Simulations {


    public ArrayList<Double> runMulliganSimulation(int numOfTrials){
        ArrayList<Double> percentages = new ArrayList<>();

        for(int i = 1; i <= 60; i++){
            int numOfPokemon = i;
            int numOfEnergies = 60 - i;

            percentages.add((getMulliganChance(numOfPokemon, numOfEnergies, numOfTrials)));
        }

        return percentages;
    }

    public double getMulliganChance(int numOfPokemon, int numOfEnergies, int numOfTrials){

        int numberOfMulligans = 0;

        Deck d = new Deck();

        ArrayList<Card> hand = new ArrayList<>();
        for (int i = 0; i < numOfTrials; i++){
            d.generateDeck(numOfPokemon, numOfEnergies);
            d.shuffle();

            for(int j = 0; j < 7; j++){
                hand.add(d.pickTopCard());
            }

            int countOfPokemonHand = 0;

            for(Card c: hand){
                if (c.getTypeOfCard().equals("Pokemon")){
                    countOfPokemonHand++;
                }
            }

            if(countOfPokemonHand == 0){
                numberOfMulligans++;
            }
            hand.clear();
            d.getDeckOfCards().clear();
        }


        return ((double)numberOfMulligans/numOfTrials)*100.00;
    }


}
