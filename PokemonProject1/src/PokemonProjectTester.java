import java.util.ArrayList;

/**
 * The PokemonProjectTester class is responsible for testing the methods of the classes in the PokemonProject.
 * @author Rachel Hussmann
 */
public class PokemonProjectTester {
    public static void main(String[] args) {

        Simulations sTester = new Simulations();
        ArrayList<Double> percentages = new ArrayList<>();

        percentages = sTester.runMulliganSimulation(10000);

        System.out.println(percentages);

        percentages = sTester.runBrickSimulation(10000);

        System.out.println(percentages);

    }
}
