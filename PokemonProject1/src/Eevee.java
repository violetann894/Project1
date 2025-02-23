import java.util.ArrayList;

/**
 * The Eevee class holds information about the pokemon Eevee for a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class Eevee extends Pokemon{

    /**
     * Deafult constructor
     */
    public Eevee(){

        setHp(50);
        setName("Eevee");
        ArrayList<Attack> attacks = new ArrayList<>();

        ArrayList<Energy> tackleAttackCost = new ArrayList<>();
        tackleAttackCost.add(new Energy());
        Attack claw = new Attack(tackleAttackCost, "Tackle", 10);

        ArrayList<Energy> biteCost = new ArrayList<>();
        biteCost.add(new Energy());
        biteCost.add(new Energy());
        Attack drillPeck = new Attack(biteCost, "Bite", 20);

        attacks.add(claw);
        attacks.add(drillPeck);

        setAttacks(attacks);
        setWeakness("Fighting");
        setType("Normal");
        setRetreatCost(1);

        setTypeOfCard("Pokemon");
        setPokemon(this);

    }

}
