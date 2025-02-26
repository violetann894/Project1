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

        //Setting the hp and name of the pokemon
        setHp(50);
        setNameOfCard("Eevee");

        //Initializing the attacks ArrayList
        ArrayList<Attack> attacks = new ArrayList<>();

        //Setting up the tackle attack
        ArrayList<Energy> tackleAttackCost = new ArrayList<>();
        tackleAttackCost.add(new Energy());
        Attack tackle = new Attack(tackleAttackCost, "Tackle", 10);

        //Setting up the bite attack
        ArrayList<Energy> biteCost = new ArrayList<>();
        biteCost.add(new Energy());
        biteCost.add(new Energy());
        Attack bite = new Attack(biteCost, "Bite", 20);

        //Adding the attacks to the arraylist
        attacks.add(tackle);
        attacks.add(bite);

        //Setting the attacks, weakness, type, and retreatCost of the pokemon
        setAttacks(attacks);
        setWeakness("Fighting");
        setType("Normal");
        setRetreatCost(1);

        //Setting the type of card and setting the Card variable, pokemon, to this object
        setTypeOfCard("Pokemon");
        setPokemon(this);

    }

}
