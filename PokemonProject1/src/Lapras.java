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

        //Setting up hp and the name of the pokemon
        setHp(100);
        setNameOfCard("Lapras");

        //Initializing the attacks ArrayList
        ArrayList<Attack> attacks = new ArrayList<>();

        //Setting up the surf attack
        ArrayList<Energy> surfAttackCost = new ArrayList<>();
        surfAttackCost.add(new Water());
        surfAttackCost.add(new Energy());
        surfAttackCost.add(new Energy());
        surfAttackCost.add(new Energy());
        Attack surf = new Attack(surfAttackCost, "Surf", 70);

        //Adding the attack to the ArrayList
        attacks.add(surf);

        //Setting the attacks, weakness, type, and retreatCost of the pokemon
        setAttacks(attacks);
        setWeakness("Steel");
        setType("Water");
        setRetreatCost(2);

        //Setting the type of card and setting the Card variable, pokemon, to this object
        setTypeOfCard("Pokemon");
        setPokemon(this);

    }

}
