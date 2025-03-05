import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

/**
 * The BinomialDistribution class handles the calculation of Binomial Distributions and all other statistical
 * values associated with Binomial Distributions.
 * @author Rachel Hussmann
 */
public class BinomialDistribution {

    /**
     * The binomialDistribution method calculates the probability of an event based off of a binomial distribution
     * formula.
     * @param numberOfTrials The number of trials to be run.
     * @param probOfSuccess The probability of a successful trial.
     * @param totalNumSuccess The total number of successes.
     * @return The probability of the event.
     */
    public double binomialDistribution(int numberOfTrials, double probOfSuccess, int totalNumSuccess){

        //Calculate the probability of a failed trial
        double probOfFail = 1 - probOfSuccess;

        //Create a new combination object to gain access to the combination method
        Combination combination = new Combination();

        //Get the combination of numberOfTrials and totalNumSuccess
        int comb = combination.getCombination(numberOfTrials, totalNumSuccess);

        //Find the probability of success raised to the total number of successes
        double py = Math.pow(probOfSuccess, totalNumSuccess);

        //Find the number of trials minus the total number of successes
        int nMinusY = numberOfTrials - totalNumSuccess;

        //Find the probability of failure raised to the number of trials minus the total number of successes
        double qNMinusY = Math.pow(probOfFail, nMinusY);

        //Return the calculation
        return comb*py*qNMinusY;

    }

    /**
     * The binomialDistribution method calculates the probability of an event based off of a binomial distribution
     * formula.
     * @param numberOfTrials The number of trials to be run.
     * @param probOfSuccess The probability of a successful trial.
     * @param totalNumSuccess The total number of successes.
     * @return The probability of the event.
     */
    public BigDecimal binomialDistribution(BigInteger numberOfTrials, double probOfSuccess, BigInteger totalNumSuccess){

        //Calculate the probability of a failed trial
        BigDecimal probOfFail = BigDecimal.valueOf(1 - probOfSuccess);

        //Create a new combination object to gain access to the combination method
        Combination combination = new Combination();

        //Get the combination of numberOfTrials and totalNumSuccess
        BigDecimal comb = new BigDecimal(combination.getCombination(numberOfTrials, totalNumSuccess));

        //Find the probability of success raised to the total number of successes
        BigDecimal py = BigDecimal.valueOf(Math.pow(probOfSuccess, totalNumSuccess.doubleValue()));

        //Find the number of trials minus the total number of successes
        BigInteger nMinusY = numberOfTrials.subtract(totalNumSuccess);

        //Find the probability of failure raised to the number of trials minus the total number of successes
        BigDecimal qNMinusY = BigDecimal.valueOf(Math.pow(probOfFail.doubleValue(), nMinusY.doubleValue()));

        //Return the calculation
        return comb.multiply(py).multiply(qNMinusY);
    }

    /**
     * The expectedValue method calculates the mean of a binomial distribution.
     * @param numberOfTrials The total number of trials.
     * @param probOfSuccess The probability of a successful trial.
     * @return The expected value (mean) of the binomial distribution.
     */
    public double expectedValue(int numberOfTrials, double probOfSuccess){
        return numberOfTrials*probOfSuccess;
    }

    /**
     * The expectedValue method calculates the mean of a binomial distribution.
     * @param numberOfTrials The total number of trials.
     * @param probOfSuccess The probability of a successful trial.
     * @return The expected value (mean) of the binomial distribution.
     */
    public BigDecimal expectedValue(BigInteger numberOfTrials, double probOfSuccess){

        //Convert the inputs into BigDecimals to be able to complete the calculation
        BigDecimal numOfTrials = new BigDecimal(numberOfTrials);
        BigDecimal probabilityOfSuccess = BigDecimal.valueOf(probOfSuccess);

        //Return the calculation
        return numOfTrials.multiply(probabilityOfSuccess);
    }

    /**
     * The variance method calculates the variance of a binomial distribution.
     * @param numberOfTrials The total number of trials.
     * @param probOfSuccess The probability of success for a trial.
     * @return The variance of the binomial distribution.
     */
    public double variance(int numberOfTrials, double probOfSuccess){

        //Calculate the probability of failure
        double probOfFailure = 1 - probOfSuccess;

        //Return the number of trials times the probability of success times the probability of failure
        return numberOfTrials*probOfSuccess*probOfFailure;
    }

    /**
     * The variance method calculates the variance of a binomial distribution.
     * @param numberOfTrials The total number of trials.
     * @param probOfSuccess The probability of success for a trial.
     * @return The variance of the binomial distribution.
     */
    public BigDecimal variance(BigInteger numberOfTrials, double probOfSuccess){

        //Convert the inputs into BigDecimals to be able to complete the calculation
        BigDecimal numOfTrials = new BigDecimal(numberOfTrials);
        BigDecimal probabilityOfSuccess = BigDecimal.valueOf(probOfSuccess);

        //Calculate the probability of failure
        BigDecimal probOfFail = BigDecimal.valueOf(1-probOfSuccess);

        //Return the number of trials times the probability of success times the probability of failure
        return numOfTrials.multiply(probabilityOfSuccess).multiply(probOfFail);
    }

    /**
     * The standardDeviation method calculates the standard deviation of the binomial distribution.
     * @param variance The variance of the binomial distribution.
     * @return The standard deviation of the binomial distribution.
     */
    public double standardDeviation(double variance){
        return Math.sqrt(variance);
    }

    /**
     * The standardDeviation method calculates the standard deviation of the binomial distribution.
     * @param variance The variance of the binomial distribution.
     * @return The standard deviation of the binomial distribution.
     */
    public BigDecimal standardDeviation(BigDecimal variance){
        return variance.sqrt(MathContext.UNLIMITED);
    }

    /**
     * The testerOutput method shows an example output of the methods within the BinomialDistribution class.
     */
    public void testerOutput(){

        System.out.println("Binomial Distribution for n = 3, p = 0.8 and x = 2: " +
                binomialDistribution(3, 0.8, 2));
        System.out.println("Expected value of the distribution: " +
                expectedValue(3, 0.8));
        System.out.println("Variance of the distribution: " + variance(3, 0.8));
        System.out.println("Standard deviation of the distribution: "
                + standardDeviation(variance(3, 0.8)));
        System.out.println();

    }
}
