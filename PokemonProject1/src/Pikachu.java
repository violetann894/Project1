import java.util.ArrayList;

/**
 * The Pikachu class holds information about the pokemon Pikachu for a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class Pikachu extends Pokemon{

    /**
     * Default constructor
     */
    public Pikachu(){

        //Setting up the hp and the name of the pokemon
        setHp(60);
        setNameOfCard("Pikachu");

        //Initializing the attacks ArrayList
        ArrayList<Attack> attacks = new ArrayList<>();

        //Setting up the pika punch attack
        ArrayList<Energy> pikaPunchCost = new ArrayList<>();
        pikaPunchCost.add(new Steel());
        Attack pikaPunch = new Attack(pikaPunchCost, "Pika Punch", 10);

        //Setting up the double voltage attack
        ArrayList<Energy> doubleVoltageCost = new ArrayList<>();
        doubleVoltageCost.add(new Electric());
        doubleVoltageCost.add(new Electric());
        doubleVoltageCost.add(new Energy());
        Attack doubleVoltage = new Attack(doubleVoltageCost, "Double Voltage", 40);

        //Adding the attacks to the ArrayList
        attacks.add(pikaPunch);
        attacks.add(doubleVoltage);

        //Setting the attacks, weakness, type, and retreatCost of the pokemon
        setAttacks(attacks);
        setWeakness("Fighting");
        setType("Electric");
        setRetreatCost(1);

        //Setting the type of card and setting the Card variable, pokemon, to this object
        setTypeOfCard("Pokemon");
        setPokemon(this);

    }

}
