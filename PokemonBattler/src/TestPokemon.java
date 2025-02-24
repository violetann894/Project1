/**
 * The TestPokemon class tests the Charmander, Pikachu, Pokemon and Stadium classes.
 * @author Rachel Hussmann
 */
public class TestPokemon {

    public static void main(String[] args) {

        //Initializing all the objects needed to run a battle
        Charmander charmanderSteve = new Charmander();
        Stadium tester = new Stadium();
        Pikachu ummhmm = new Pikachu();

        //Battle the pokemon
        tester.battle(ummhmm, charmanderSteve);

        System.out.println();

        //Testing the additional constructors
        Charmander hi = new Charmander(59, 12, 4, 20);
        Pikachu hello = new Pikachu(70, 10, 6, 40);

        //Battle the pokemon
        tester.battle(hi, hello);

    }
}
