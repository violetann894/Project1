import java.util.Random;
import java.util.Scanner;

/**
 * The PokemonCardGame class is responsible for creating and running a Pokemon TCG game between two players. It holds
 * all the core methods and game state variables.
 */
public class PokemonCardGame {

    private Player player1;
    private Player player2;
    private Scanner userInput = new Scanner(System.in);
    private boolean firstTurnCheck;
    private String whoGoesFirst;

    /**
     *
     */
    public void startGame(){
        System.out.println("Starting game . . .");

        player1 = new Player();
        player2 = new Player();

        player1.createHand();
        player2.createHand();

        player1.pickPrizeDeck();
        player2.pickPrizeDeck();

        firstTurnCheck = true;
    }

    /***
     *
     * @return
     */
    public String coinFlip(){
        Random random = new Random();

        int coinFace = random.nextInt(0, 2);

        if(coinFace == 0){
            return "Heads";
        }else{
            return "Tails";
        }
    }

    /**
     *
     */
    public void mulligan(){

    }

    /**
     *
     */
    public void player1Turn(){

    }

    /**
     *
     */
    public void player2Turn(){

    }

    /**
     *
     */
    public void runGame(){

    }

}
