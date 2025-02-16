import java.util.ArrayList;

public class PokemonCardGame {

    private ArrayList<Card> player1;

    private ArrayList<Card> player2;

    /**
     *
     */
    public PokemonCardGame(){

        //
        Deck player1Deck = new Deck();

        //
        player1Deck.generateDeck(20, 30, 10);

        //
        this.player1 = player1Deck.getDeckOfCards();

        //
        Deck player2Deck = new Deck();

        //
        player2Deck.generateDeck(20,30,10);

        //
        this.player2 = player2Deck.getDeckOfCards();
    }

    /**
     *
     * @param playerDeck
     */
    public PokemonCardGame(ArrayList<Card> playerDeck){
        player1 = playerDeck;

        //
        Deck player2Deck = new Deck();

        //
        player2Deck.generateDeck(20,30,10);

        //
        this.player2 = player2Deck.getDeckOfCards();

    }

    /**
     *
     * @param player1Deck
     * @param player2Deck
     */
    public PokemonCardGame(ArrayList<Card> player1Deck, ArrayList<Card> player2Deck){
        player1 = player1Deck;
        player2 = player2Deck;
    }

    /**
     *
     * @param hand
     * @return
     */
    public boolean checkForMulligan(ArrayList<Card> hand){

        boolean broke = false;

        //Run through the cards in the hand
        for(Card c: hand){

            //Check to see if a pokemon card is in the hand
            if (c.getTypeOfCard().equals("Pokemon")){

                //
                broke = true;
                break;
            }
        }

        //
        if(broke){
            return true;
        }

        //
        return false;
    }

    /**
     *
     * @return
     */
    public ArrayList<Card> getPlayer1() {
        return player1;
    }

    /**
     *
     * @param player1
     */
    public void setPlayer1(ArrayList<Card> player1) {
        this.player1 = player1;
    }

    /**
     *
     * @return
     */
    public ArrayList<Card> getPlayer2() {
        return player2;
    }

    /**
     *
     * @param player2
     */
    public void setPlayer2(ArrayList<Card> player2) {
        this.player2 = player2;
    }

}
