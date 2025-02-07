/**
 * The Charmander class is a subclass to the Pokemon class. It represents the pokemon Charmander.
 * @author Rachel Hussmann
 */
public class Charmander extends Pokemon{

    //Subclass, inherits the public interface

    /**
     * Default constructor for the Charmander class
     */
    public Charmander(){
        setHp(39);
        setAttack(52);
        setDefense(43);
        setSpeed(65);
    }

    /**
     * Additional constructor for the Charmander class
     * @param hp The total health points of the Charmander
     * @param attack The number value of the attack stat for the Charmander
     * @param defense The number value of the defense stat for the Charmander
     * @param speed The number value of the speed stat for the Charmander
     */
    public Charmander(int hp, int attack, int defense, int speed){
        setHp(hp);
        setAttack(attack);
        setDefense(defense);
        setSpeed(speed);
    }

}
