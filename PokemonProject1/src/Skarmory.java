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
        setHp(80);
        setName("Skarmory");
        ArrayList<Attack> attacks = new ArrayList<>();

        ArrayList<Energy> clawAttackCost = new ArrayList<>();
        clawAttackCost.add(new Steel());
        Attack claw = new Attack(clawAttackCost, "Claw", 20);

        ArrayList<Energy> drillPeckCost = new ArrayList<>();
        drillPeckCost.add(new Steel());
        drillPeckCost.add(new Energy());
        drillPeckCost.add(new Energy());
        Attack drillPeck = new Attack(drillPeckCost, "Drill Peck", 50);

        attacks.add(claw);
        attacks.add(drillPeck);

        setAttacks(attacks);
        setWeakness("Fire");
        setType("Steel");
        setRetreatCost(2);

        setTypeOfCard("Pokemon");
        setPokemon(this);
    }
}
