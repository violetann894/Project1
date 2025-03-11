import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * The HypergeometricDistribution class handles the calculation of Hypergeometric distributions and all other
 * statistical values associated with Hypergeometric distributions.
 * @author Rachel Hussmann
 */
public class HypergeometricDistribution {

    /**
     * The hypergeometricDistribution method calculates the probability of an event occurring when the elements are
     * taken out without replacement.
     * @param N The total number of items in the population
     * @param n The number of successful events in the population
     * @param y The number of successful events in the sample
     * @param r The number of items in the sample
     * @return The probability of the event
     */
    public double hypergeometricDistribution(int N, int n, int y, int r){

        //Create the combination object
        Combination combination = new Combination();

        //Calculate the two numbers in the numerator
        int numerator1 = combination.getCombination(r, y);
        int numerator2 = combination.getCombination(N-r, n-y);

        //Calculate the denominator
        int denominator = combination.getCombination(N, n);

        //Calculate the numerator
        int numerator = numerator1*numerator2;

        //Return the probability of the event
        return (double) numerator/denominator;
    }

    /**
     * The hypergeometricDistribution method calculates the probability of an event occurring when the elements are
     * taken out without replacement.
     * @param N The total number of items in the population
     * @param n The number of successful events in the population
     * @param y The number of successful events in the sample
     * @param r The number of items in the sample
     * @return The probability of the event
     */
    public BigDecimal hypergeometricDistribution(BigInteger N, BigInteger n, BigInteger y, BigInteger r){

        //Create the combination object
        Combination combination = new Combination();

        //Calculate the two numbers in the numerator
        BigInteger numerator1 = combination.getCombination(r, y);
        BigInteger numerator2 = combination.getCombination(N.subtract(r), n.subtract(y));

        //Calculate the denominator
        BigDecimal denominator = new BigDecimal(combination.getCombination(N, n));

        //Calculate the numerator
        BigDecimal numerator = new BigDecimal(numerator1.multiply(numerator2));

        //Return the probability of the event
        return numerator.divide(denominator, 4, RoundingMode.UP);
    }

    /**
     * The expectedValue method calculates the expected value (mean) of the hypergeometric distribution.
     * @param n The number of successful events in the population
     * @param r The number of items in the sample
     * @param N The total number of items in the population
     * @return The expected value of the distribution
     */
    public double expectedValue(int n, int r, int N){
        return (double) n*r/N;
    }

    /**
     * The expectedValue method calculates the expected value (mean) of the hypergeometric distribution.
     * @param n The number of successful events in the population
     * @param r The number of items in the sample
     * @param N The total number of items in the population
     * @return The expected value of the distribution
     */
    public BigDecimal expectedValue(BigInteger n, BigInteger r, BigInteger N){

        //Convert n times r into a BigDecimal
        BigDecimal nr = new BigDecimal(n.multiply(r));

        //Convert N into a BigDecimal
        BigDecimal decimalN = new BigDecimal(N);

        //Return nr/N
        return nr.divide(decimalN, 4, RoundingMode.UP);
    }

    /**
     * The variance method calculates the variance of the hypergeometric distribution.
     * @param n The number of successful events in the population
     * @param r The number of items in the sample
     * @param N The total number of items in the population
     * @return The variance of the distribution
     */
    public double variance(int n, int r, int N){

        //Calculate the firstFraction of the formula
        double firstFraction = (double) r/N;

        //Calculate the secondFraction of the formula
        double secondFraction = (double) (N-r)/N;

        //Calculate the thirdFraction of the formula
        double thirdFraction = (double) (N-n)/(N-1);

        //Return the variance of the distribution
        return n*firstFraction*secondFraction*thirdFraction;
    }

    /**
     *The variance method calculates the variance of the hypergeometric distribution.
     *@param n The number of successful events in the population
     *@param r The number of items in the sample
     *@param N The total number of items in the population
     *@return The variance of the distribution
     */
    public BigDecimal variance(BigInteger n, BigInteger r, BigInteger N){

        //Convert the numbers for use with BigDecimals
        BigDecimal rDecimal = new BigDecimal(r);
        BigDecimal NDecimal = new BigDecimal(N);
        BigDecimal nDecimal = new BigDecimal(n);

        //Calculate the firstFraction of the formula
        BigDecimal firstFraction = rDecimal.divide(NDecimal, 5, RoundingMode.UP);

        //Calculate the secondFraction of the formula
        BigDecimal secondFraction = (NDecimal.subtract(rDecimal)).divide(NDecimal, 5, RoundingMode.UP);

        //Calculate the thirdFraction of the formula
        BigDecimal thirdFraction = (NDecimal.subtract(nDecimal)).divide(NDecimal.subtract(BigDecimal.ONE),
                5, RoundingMode.UP);

        //Return the variance of the distribution
        return nDecimal.multiply(firstFraction).multiply(secondFraction).multiply(thirdFraction);
    }

    /**
     * The standardDeviation method calculates the standard deviation of the hypergeometric distribution.
     * @param variance The variance of the hypergeometric distribution
     * @return The standard deviation of the distribution
     */
    public double standardDeviation(double variance){
        return Math.sqrt(variance);
    }

    /**
     * The standardDeviation method calculates the standard deviation of the hypergeometric distribution.
     * @param variance The variance of the hypergeometric distribution.
     * @return The standard deviation of the hypergeometric distribution.
     */
    public BigDecimal standardDeviation(BigDecimal variance){
        return variance.sqrt(MathContext.DECIMAL32);
    }

    /**
     * The testerOutput method shows an example output of the methods within the HypergeometricDistribution class.
     */
    public void testerOutput(){

        //Used problem 3.103 to test methods
        System.out.println("Hypergeometric distribution formula using N = 10, n = 5, y = 5 and r = 6: " +
                hypergeometricDistribution(10, 5, 5, 6));
        System.out.println("Expected value of the distribution: " + expectedValue(5, 6, 10));
        System.out.println("Variance of the distribution: " + variance(5, 6, 10));
        System.out.println("Standard deviation of the distribution: " + standardDeviation(variance(5, 6, 10)));

        System.out.println();

        //Used same problem but with BigInteger objects
        BigInteger N = BigInteger.valueOf(10);
        BigInteger n = BigInteger.valueOf(5);
        BigInteger y = BigInteger.valueOf(5);
        BigInteger r = BigInteger.valueOf(6);
        System.out.println("Hypergeometric distribution fomrula using BigInteger, N = 10, n = 5, y = 5 and r = 4: "
                + hypergeometricDistribution(N, n, y, r));
        System.out.println("Expected value of the distribution using BigInteger: " + expectedValue(n, r, N));
        System.out.println("Variance of the distribution using BigInteger: " + variance(n, r, N));
        System.out.println("Standard deviation of the distribution using BigInteger: " +
                standardDeviation(variance(n, r, N)));

        System.out.println();
    }
}
