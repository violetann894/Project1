/**
 * The StatsTester class is used to test the class StatsLibrary and its associated methods.
 * @author Rachel Hussmann
 */
public class StatsTester {

    public static void main(String[] args) {

        StatsLibrary sTester = new StatsLibrary();
        Combination cTester = new Combination();
        Permutation pTester = new Permutation();
        ProbabilityCalculations probTester = new ProbabilityCalculations();
        SetOperations setTester = new SetOperations();
        BinomialDistribution bTester = new BinomialDistribution();
        GeometricDistribution gTester = new GeometricDistribution();

        sTester.tester();
        cTester.tester();
        pTester.tester();
        probTester.tester();
        setTester.tester();
        bTester.tester();
        gTester.tester();
    }

}
