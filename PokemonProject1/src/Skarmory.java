import java.util.ArrayList;

/**
 * The Skarmory class holds information about the pokemon Skarmory for a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class Skarmory extends Pokemon{

    /**
     * Default constructor
     */
    public Skarmory(){

        //Setting up the hp and the name of the pokemon
        setHp(80);
        setNameOfCard("Skarmory");

        //Initializing the attacks ArrayList
        ArrayList<Attack> attacks = new ArrayList<>();

        //Setting up the claw attack
        ArrayList<Energy> clawAttackCost = new ArrayList<>();
        clawAttackCost.add(new Steel());
        Attack claw = new Attack(clawAttackCost, "Claw", 20);

        //Setting up the drill peck attack
        ArrayList<Energy> drillPeckCost = new ArrayList<>();
        drillPeckCost.add(new Steel());
        drillPeckCost.add(new Energy());
        drillPeckCost.add(new Energy());
        Attack drillPeck = new Attack(drillPeckCost, "Drill Peck", 50);

        //Adding the attacks to the ArrayList
        attacks.add(claw);
        attacks.add(drillPeck);

        //Setting the attacks, weakness, type, and retreatCost of the pokemon
        setAttacks(attacks);
        setWeakness("Fire");
        setType("Steel");
        setRetreatCost(2);

        //Setting the type of card and setting the Card variable, pokemon, to this object
        setTypeOfCard("Pokemon");
        setPokemon(this);
    }
}
