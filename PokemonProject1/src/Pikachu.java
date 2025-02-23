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

        setHp(60);
        ArrayList<Attack> attacks = new ArrayList<>();

        ArrayList<Energy> pikaPunchCost = new ArrayList<>();
        pikaPunchCost.add(new Steel());
        Attack pikaPunch = new Attack(pikaPunchCost, "Pika Punch", 10);

        ArrayList<Energy> doubleVoltageCost = new ArrayList<>();
        doubleVoltageCost.add(new Electric());
        doubleVoltageCost.add(new Electric());
        doubleVoltageCost.add(new Energy());
        Attack doubleVoltage = new Attack(doubleVoltageCost, "Double Voltage", 40);

        attacks.add(pikaPunch);
        attacks.add(doubleVoltage);

        setAttacks(attacks);
        setWeakness("Fighting");
        setType("Electric");
        setRetreatCost(1);

        setTypeOfCard("Pokemon");
        setPokemon(this);

    }

}
