import java.util.ArrayList;

/**
 * The Charmander class holds information about the pokemon Charmander for a Pokemon TCG game.
 */
public class Charmander extends Pokemon{

    /**
     * Default constructor
     */
    public Charmander(){

        setHp(50);

        ArrayList<Attack> attacks = new ArrayList<>();

        ArrayList<Energy> scratchAttackCost = new ArrayList<>();
        scratchAttackCost.add(new Energy());
        Attack claw = new Attack(scratchAttackCost, "Scratch", 10);

        ArrayList<Energy> emberCost = new ArrayList<>();
        emberCost.add(new Fire());
        emberCost.add(new Energy());
        Attack ember = new Attack(emberCost, "Ember", 30);

        attacks.add(claw);
        attacks.add(ember);

        setAttacks(attacks);
        setWeakness("Water");
        setType("Fire");
        setRetreatCost(1);

        setTypeOfCard("Pokemon");
        setPokemon(this);
    }

}
