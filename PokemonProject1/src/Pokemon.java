import java.util.ArrayList;
/**
 * The Pokemon class holds information about a Pokemon including core stats about them.
 * @author Rachel Hussmann
 */
public class Pokemon extends Card{

    //Global variables for the class
    private int hp;
    private ArrayList<Attack> attacks;
    private String weakness;
    private String type;
    private int retreatCost;

    /**
     * The getHp method returns the value of the health points of the Pokemon.
     * @return The total health points of the Pokemon.
     */
    public int getHp() {
        return hp;
    }

    /**
     * The setHp method accepts a new value for the Pokemon's HP and sets it.
     * @param hp The new value for hp.
     */
    public void setHp(int hp) {
        this.hp = hp;
    }

    /**
     * The getAttacks method return an ArrayList of Attack objects of the pokemon.
     * @return ArrayList of Attack objects.
     */
    public ArrayList<Attack> getAttacks() {
        return attacks;
    }

    /**
     * The setAttacks method accepts an ArrayList of Attack objects to assign to the pokemon.
     * @param attacks An ArrayList of attack objects to set for the pokemon.
     */
    public void setAttacks(ArrayList<Attack> attacks) {
        this.attacks = attacks;
    }

    /**
     * The getWeakness method returns the type the pokemon is weak against.
     * @return The string of the type the pokemon is weak against.
     */
    public String getWeakness() {
        return weakness;
    }

    /**
     * The setWeakness method accepts a new type that the pokemon is weak against
     * @param weakness A string of the type the pokemon is weak against.
     */
    public void setWeakness(String weakness) {
        this.weakness = weakness;
    }

    /**
     * The getType method returns the type of the pokemon.
     * @return The type of the pokemon in a string.
     */
    public String getType() {
        return type;
    }

    /**
     * The setType method accepts a string of the new type for the pokemon.
     * @param type A string of the new type for the pokemon.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * The getRetreatCost returns the amount of energies required to let the pokemon retreat to the bench.
     * @return The number energies required to let the pokemon retreat.
     */
    public int getRetreatCost() {
        return retreatCost;
    }

    /**
     * The setRetreatCost accepts the new number of energies required to let the pokemon retreat to the bench.
     * @param retreatCost The new number of energies required to let the pokemon retreat.
     */
    public void setRetreatCost(int retreatCost) {
        this.retreatCost = retreatCost;
    }
}