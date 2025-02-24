import java.util.ArrayList;

/**
 * The PokemonProjectTester class is responsible for testing the methods of the classes in the PokemonProject.
 * @author Rachel Hussmann
 */
public class PokemonProjectTester {
    public static void main(String[] args) {

        MulliganMonteCarlo tester = new MulliganMonteCarlo();
        BrickMonteCarlo bTester = new BrickMonteCarlo();
        ArrayList<Double> percentages;

        //percentages = tester.runMulliganSimulation(10000);

        //System.out.println(percentages);

        //percentages = bTester.runBrickSimulation(10000);

        //System.out.println(percentages);

        System.out.println();

        PokemonCardGame pokemonTester = new PokemonCardGame();
        pokemonTester.startGame();
    }
}
