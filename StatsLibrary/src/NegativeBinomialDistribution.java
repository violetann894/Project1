import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * The NegativeBinomialDistribution class handles the calculation of Negative Binomial Distribution and all other
 * statistical values associated with Negative Binomial Distribution.
 * @author Rachel Hussmann
 */
public class NegativeBinomialDistribution {

    /**
     * The negativeBinomialDistribution method calculates the probability of an event based off of a negative
     * binomial distribution formula.
     * @param trialWithSuccess The trial number that had the successful result
     * @param numberOfSuccesses The total number of successful trials
     * @param probOfSuccess The probability of a successful trial
     * @return The probability of an event
     */
    public double negativeBinomialDistribution(int trialWithSuccess, int numberOfSuccesses, double probOfSuccess){

        //Create a new combination object to gain access to the combination method
        Combination combination = new Combination();

        //Get the combination of trialsWithSuccess minus one and numberOfSuccesses
        int comb = combination.getCombination(trialWithSuccess-1, numberOfSuccesses-1);

        //Find the probability of success raised to the number of successes
        double pR = Math.pow(probOfSuccess, numberOfSuccesses);

        //Find the probability of failure raised to the successful trial minus the number of successes
        double qYMinusR = Math.pow((1-probOfSuccess), trialWithSuccess-numberOfSuccesses);

        //Return the calculation
        return comb*pR*qYMinusR;
    }

    /**
     * The negativeBinomialDistribution method calculates the probability of an event based off of a negative
     *  binomial distribution formula.
     * @param trialWithSuccess The trial number that had the successful result
     * @param numberOfSuccesses The total number of successful trials
     * @param probOfSuccess The probability of a successful trial
     * @return The probability of an event
     */
    public BigDecimal negativeBinomialDistribution(BigInteger trialWithSuccess, BigInteger numberOfSuccesses,
                                                   BigDecimal probOfSuccess){
        //Create a new combination object to gain access to the combination method
        Combination combination = new Combination();

        //Get the combination of trialsWithSuccess minus one and numberOfSuccesses
        BigDecimal comb = new BigDecimal(combination.getCombination(trialWithSuccess.subtract(BigInteger.ONE),
                numberOfSuccesses.subtract(BigInteger.ONE)));

        //Find the probability of success raised to the number of successes
        BigDecimal pR = probOfSuccess.pow(numberOfSuccesses.intValue());

        //Find the probability of failure raised to the successful trial minus the number of successes
        BigDecimal qYMinusR = BigDecimal.ONE.subtract(probOfSuccess).pow(trialWithSuccess.subtract
                (numberOfSuccesses).intValue());

        //Return the calculation
        return comb.multiply(pR).multiply(qYMinusR);
    }

    /**
     * The expectedValue method calculates the expected value (mean) of a negative binomial distribution.
     * @param numberOfSuccesses The total number of successes
     * @param probOfSuccess The probability of a successful trial
     * @return The expected value (mean) of the negative binomial distribution
     */
    public double expectedValue(int numberOfSuccesses, double probOfSuccess){
        return numberOfSuccesses/probOfSuccess;
    }

    /**
     * The expectedValue method calculates the expected value (mean) of a negative binomial distribution.
     * @param numberOfSuccesses The total number of successes
     * @param probOfSuccess The probability of a successful trial
     * @return The expected value (mean) of the negative binomial distribution
     */
    public BigDecimal expectedValue(BigInteger numberOfSuccesses, BigDecimal probOfSuccess){
        BigDecimal numOfSuccess = new BigDecimal(numberOfSuccesses);

        return numOfSuccess.divide(probOfSuccess, 2, RoundingMode.UP);
    }

    /**
     * The variance method calculates the variance of a negative binomial distribution.
     * @param numberOfSuccesses The total number of successes
     * @param probOfSuccess The probability of a successful trial
     * @return The variance of the negative binomial distribution
     */
    public double variance(int numberOfSuccesses, double probOfSuccess){
        return numberOfSuccesses*(1-probOfSuccess)/Math.pow(probOfSuccess, 2);
    }

    /**
     * The variance method calculates the variance of a negative binomial distribution.
     * @param numberOfSuccesses The total number of successes
     * @param probOfSuccess The probability of a successful trial
     * @return The variance of the negative binomial distribution
     */
    public BigDecimal variance(BigInteger numberOfSuccesses, BigDecimal probOfSuccess){

        //Convert the BigInteger object into a BigDecimal object
        BigDecimal numOfSuccess = new BigDecimal(numberOfSuccesses);

        //Calculate the probability of failure
        BigDecimal probOfFail = BigDecimal.ONE.subtract(probOfSuccess);

        //Calculate the denominator
        BigDecimal denominator = probOfSuccess.pow(2);

        //Return the variance of the distribution
        return (numOfSuccess.multiply(probOfFail)).divide(denominator, 2, RoundingMode.UP);
    }

    /**
     * The standardDeviation method calculates the standard deviation of the negative binomial distribution.
     * @param variance The variance of the distribution
     * @return The standard deviation of the negative binomial distribution.
     */
    public double standardDeviation(double variance){
        return Math.sqrt(variance);
    }

    /**
     * The standardDeviation method calculates the standard deviation of the negative binomial distribution.
     * @param variance The variance of the negative binomial distribution.
     * @return The standard deviation of the negative binomial distribution.
     */
    public BigDecimal standardDeviation(BigDecimal variance){
        return variance.sqrt(MathContext.DECIMAL32);
    }

    /**
     * The testerOutput method displays an example output of the methods within the NegativeBinomialDistribution class.
     */
    public void testerOutput(){

        //Using problem 3.90 to test methods
        System.out.println("Negative Binomial Distribution formula using p = 0.4, r = 3, y = 10: " +
                negativeBinomialDistribution(10, 3, 0.4));
        System.out.println("Expected value for the distribution: " + expectedValue(3, 0.4));
        System.out.println("Variance for the distribution: " + variance(3, 0.4));
        System.out.println("Standard deviation for the distribution: " +
                standardDeviation(variance(3, 0.4)));

        System.out.println();

        BigInteger r = BigInteger.valueOf(3);
        BigInteger y = BigInteger.valueOf(10);
        BigDecimal p = BigDecimal.valueOf(0.4);
        System.out.println("Negative Binomial Distribution formula using BigInteger, BigDecimal, p = 0.4, r = 3, " +
                "y = 10: " + negativeBinomialDistribution(y, r, p));
        System.out.println("Expected value for the distribution using BigInteger & BigDecimal: " + expectedValue(r, p));
        System.out.println("Variance for the distribution using BigInteger & BigDecimal: " + variance(r, p));
        System.out.println("Standard deviation for the distribution using BigInteger & BigDecimal: " +
                standardDeviation(variance(r, p)));

        System.out.println();
    }

}
