/**
 * The Pokemon class holds information about a Pokemon including core stats about them.
 * @author Rachel Hussmann
 */
public class Pokemon {

    //Global variable for the class
    private int hp;
    private int attack;
    private int defense;
    private int speed;

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
     * The getAttack method returns the value of the attack stat of the Pokemon.
     * @return The value of the attack stat.
     */
    public int getAttack() {
        return attack;
    }

    /**
     * The setAttack method accepts a new value for the Pokemon's attack stat and sets it.
     * @param attack The new value of the attack stat.
     */
    public void setAttack(int attack) {
        this.attack = attack;
    }

    /**
     * The getDefense method returns the value of the defense stat of the Pokemon.
     * @return The value of the defense stat.
     */
    public int getDefense() {
        return defense;
    }

    /**
     * The setDefense method accepts a new value for the Pokemon's defense stat and sets it.
     * @param defense The new value of the defense stat.
     */
    public void setDefense(int defense) {
        this.defense = defense;
    }

    /**
     * The getSpeed method returns the value of the speed stat of the Pokemon.
     * @return The value of the speed stat.
     */
    public int getSpeed() {
        return speed;
    }

    /**
     * The setSpeed method accepts a new value for the Pokemon's speed stat and sets it.
     * @param speed The new value of the speed stat.
     */
    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
