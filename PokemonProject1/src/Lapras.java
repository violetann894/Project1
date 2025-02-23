import java.util.ArrayList;

/**
 * The Lapras class holds information about the pokemon Lapras for a Pokemon TCG game.
 * @author Rachel Hussmann
 */
public class Lapras extends Pokemon{

    /**
     * Default constructor
     */
    public Lapras(){

        setHp(100);
        setName("Lapras");
        ArrayList<Attack> attacks = new ArrayList<>();

        ArrayList<Energy> surfAttackCost = new ArrayList<>();
        surfAttackCost.add(new Water());
        surfAttackCost.add(new Energy());
        surfAttackCost.add(new Energy());
        surfAttackCost.add(new Energy());
        Attack surf = new Attack(surfAttackCost, "Surf", 70);

        attacks.add(surf);

        setAttacks(attacks);
        setWeakness("Steel");
        setType("Water");
        setRetreatCost(2);

        setTypeOfCard("Pokemon");
        setPokemon(this);

    }

}
