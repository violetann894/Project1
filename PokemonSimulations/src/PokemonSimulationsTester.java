import java.util.ArrayList;

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
