import java.util.ArrayList;
/**
 * The Attack class holds information about the Pokemon's attack.
 * @author Rachel Hussmann
 */
public class Attack {

    private ArrayList<Energy> costOfAttack;
    private String attackName;
    private int damage;

    /**
     * Additional constructor for Attack class
     * @param costToAttack ArrayList of energies needed to activate the attack.
     * @param nameOfAttack The name of the attack.
     * @param damageDone How much damage is done when the attack hits.
     */
    public Attack(ArrayList<Energy> costToAttack, String nameOfAttack, int damageDone){
        costOfAttack = costToAttack;
        attackName = nameOfAttack;
        damage = damageDone;
    }

    /**
     * The getCostOfAttack method returns how many energies are needed to activate the attack.
     * @return ArrayList of Energy objects
     */
    public ArrayList<Energy> getCostOfAttack() {
        return costOfAttack;
    }

    /**
     * The setCostOfAttack method accepts a new ArrayList of energies that represent the cost of an attack.
     * @param costOfAttack An ArrayList of energies.
     */
    public void setCostOfAttack(ArrayList<Energy> costOfAttack) {
        this.costOfAttack = costOfAttack;
    }

    /**
     * The getAttackName method returns the name of the attack.
     * @return The name of the attack.
     */
    public String getAttackName() {
        return attackName;
    }

    /**
     * The setAttackName accepts a new name for an attack.
     * @param attackName A string of the new attack name.
     */
    public void setAttackName(String attackName) {
        this.attackName = attackName;
    }

    /**
     * The getDamage method returns the amount of damage the attack does.
     * @return The amount of damage the attack does.
     */
    public int getDamage() {
        return damage;
    }

    /**
     * The setDamage method accepts a new values for how much damage the attack does.
     * @param damage The amount of damage the attack does.
     */
    public void setDamage(int damage) {
        this.damage = damage;
    }
}
