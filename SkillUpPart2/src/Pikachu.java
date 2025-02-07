/**
 * The Pikachu class is a subclass to the Pokemon class. It represents the pokemon Pikachu.
 * @author Rachel Hussmann
 */
public class Pikachu extends Pokemon{

    //Subclass, inherits the public interface

    /**
     * Default constructor for the Pikachu class.
     */
    public Pikachu(){
        setHp(35);
        setAttack(55);
        setDefense(30);
        setSpeed(90);
    }

    /**
     * Additional constructor for the Pikachu class
     * @param hp The total health points of the Pikachu
     * @param attack The number value of the attack stat for the Pikachu
     * @param defense The number value of the defense stat for the Pikachu
     * @param speed The number value of the speed stat for the Pikachu
     */
    public Pikachu(int hp, int attack, int defense, int speed){
        setHp(hp);
        setAttack(attack);
        setDefense(defense);
        setSpeed(speed);
    }

}
