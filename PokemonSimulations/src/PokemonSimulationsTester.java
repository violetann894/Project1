import java.util.ArrayList;

/**
 * The PokemonSimulationsTester class is responsible for testing the two pokemon simulation classes: MulliganMonteCarlo
 * and BrickMonteCarlo. Class has a dependency on the PokemonProject1 classes.
 * @author Rachel Hussmann
 */
public class PokemonSimulationsTester {

    public static void main(String[] args) {
        MulliganMonteCarlo tester = new MulliganMonteCarlo();
        BrickMonteCarlo bTester = new BrickMonteCarlo();
        ArrayList<Double> percentages;

        percentages = tester.runMulliganSimulation(10000);

        System.out.println(percentages);

        percentages = bTester.runBrickSimulation(10000);

        System.out.println(percentages);
    }

}
