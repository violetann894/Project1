/**
 * The StatsTester class is used to test the classes contained within the StatsLibrary project.
 * @author Rachel Hussmann
 */
public class StatsTester {

    public static void main(String[] args) {

        //Initialize all the classes
        StatsLibrary sTester = new StatsLibrary();
        Combination cTester = new Combination();
        Permutation pTester = new Permutation();
        ProbabilityCalculations probTester = new ProbabilityCalculations();
        SetOperations setTester = new SetOperations();
        BinomialDistribution bTester = new BinomialDistribution();
        GeometricDistribution gTester = new GeometricDistribution();
        NegativeBinomialDistribution nbTester = new NegativeBinomialDistribution();
        RandomVariableCalculations rvTester = new RandomVariableCalculations();
        HypergeometricDistribution hgTester = new HypergeometricDistribution();

        //Test the classes
        sTester.testerOutput();
        cTester.testerOutput();
        pTester.testerOutput();
        probTester.testerOutput();
        setTester.testerOutput();
        rvTester.testerOutput();
        bTester.testerOutput();
        gTester.testerOutput();
        nbTester.testerOutput();
        hgTester.testerOutput();
    }

}
