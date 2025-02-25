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
    private ArrayList<Energy> energiesAttached;

    /**
     * Default constructor
     */
    public Pokemon(){
        energiesAttached = new ArrayList<>();
    }

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

    /**
     * The addOneRetreatCost method adds one to the retreatCost variable. Used after the player uses an X Speed trainer
     * card to make the retreatCost return to normal.
     */
    public void addOneRetreatCost(){
        retreatCost++;
    }

    /**
     * Getter for the energiesAttached variable
     * @return The ArrayList of energies attached to the pokemon
     */
    public ArrayList<Energy> getEnergiesAttached() {
        return energiesAttached;
    }

    /**
     * Setter for the energiesAttached variable
     * @param energiesAttached The new ArrayList of energies attached to the pokemon
     */
    public void setEnergiesAttached(ArrayList<Energy> energiesAttached) {
        this.energiesAttached = energiesAttached;
    }

    /**
     * The checkIfAttackIsValid method checks to see if the player can use that attack by checking the number and type
     * of energies required for the attack.
     * @return true - if the attack is valid and the pokemon has the correct energies and number of energies to
     * initiate the attack false - if the attack is not valid and the pokemon either does not have enough energies or
     * the right type of energies to attack
     */
    public boolean checkIfAttackIsValid(Attack attack, ArrayList<Energy> energiesAttached){

        //Initialize the ArrayLists that will hold all the energy states
        ArrayList<Energy> cardsRequired = new ArrayList<>();
        ArrayList<Energy> cardsGiven = new ArrayList<>();

        //Make a copy of the ArrayLists from above so we do not change them in any way
        cardsRequired.addAll(attack.getCostOfAttack());
        cardsGiven.addAll(energiesAttached);

        //Add actually checking here

        cardsRequired.clear();

        //If cardsRequired.isEmpty, then return true because all the requirements have been met for the attack
        if(cardsRequired.isEmpty()){
            return true;
        }else {
            return false;
        }
    }

    /**
     * The battle method manages a battle between two pokemon.
     * @param attackingPokemon The attacking pokemon.
     * @param pokemonAttack The Attack the attacking pokemon will use.
     * @param defendingPokemon The defensing pokemon that will be losing HP.
     */
    public void battle(Pokemon attackingPokemon, Attack pokemonAttack, Pokemon defendingPokemon){

        String type = attackingPokemon.getType();

        int damage = pokemonAttack.getDamage();
        int hp = defendingPokemon.getHp();

        //
        if(type.equals(defendingPokemon.getWeakness())){
            damage = damage * 2;
        }

        //
        hp -= damage;
        defendingPokemon.setHp(hp);
    }

    /**
     * The attachEnergy method accepts an energy card the that player would like to attack to a pokemon.
     * @param cardToAttach The energy to attach to the pokemon.
     */
    public void attachEnergy(Energy cardToAttach){
        energiesAttached.add(cardToAttach);
    }

}