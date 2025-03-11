import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;

/**
 * The GeometricDistribution class handles the calculation of Geometric Distributions and all other statistical values
 * associated with Geometric Distributions.
 * @author Rachel Hussmann
 */
public class GeometricDistribution {

    /**
     * The geometricDistribution method calculates the probability of an event based off of a geometric distribution
     * formula.
     * @param probOfSuccess The probability of a successful trial
     * @param numberOfFirstSuccess The trial where the first success happens
     * @return The probability of the event
     */
    public double geometricDistribution(double probOfSuccess, int numberOfFirstSuccess){

        //Calculate the probability of failure
        double probOfFail = 1.0 - probOfSuccess;

        //Find the probability of failure raised to the number of the trial with the first success minus one
        double qYMinusOne = Math.pow(probOfFail, numberOfFirstSuccess-1);

        //Return the value of the above calculation multiplied by the probability of success
        return qYMinusOne*probOfSuccess;

    }

    /**
     * The geometricDistribution method calculates the probability of an event based off of a geometric distribution
     * formula.
     * @param probOfSuccess The probability of a successful trial
     * @param numberOfFirstSuccess The trial where the first success happens
     * @return The probability of the event
     */
    public BigDecimal geometricDistribution(BigDecimal probOfSuccess, BigInteger numberOfFirstSuccess){

        //Calculate the probability of failure
        BigDecimal probOfFail = BigDecimal.ONE.subtract(probOfSuccess);

        //Find the probability of failure raised to the number of the trial with the first success minus one
        BigDecimal qYMinusOne = probOfFail.pow(numberOfFirstSuccess.subtract(BigInteger.ONE).intValue());

        //Return the value of the above calculation multiplied by the probability of success
        return qYMinusOne.multiply(probOfSuccess);
    }

    /**
     * The expectedValue method calculates the expected value (mean) of a geometric distribution.
     * @param probOfSuccess The probability of a successful trial
     * @return The expected value (mean) of the geometric distribution
     */
    public double expectedValue(double probOfSuccess){
        return 1/probOfSuccess;
    }

    /**
     * The expectedValue method calculates the expected value (mean) of a geometric distribution.
     * @param probOfSuccess The probability of a successful trial
     * @return The expected value (mean) of the geometric distribution
     */
    public BigDecimal expectedValue(BigDecimal probOfSuccess){
        return BigDecimal.ONE.divide(probOfSuccess, 2, RoundingMode.UP);
    }

    /**
     * The variance method calculates the variance of a geometric distribution.
     * @param probOfSuccess The probability of a successful trial
     * @return The variance of the geometric distribution
     */
    public double variance(double probOfSuccess){
        return (1-probOfSuccess)/Math.pow(probOfSuccess, 2);
    }

    /**
     * The variance method calculates the variance of a geometric distribution.
     * @param probOfSuccess The probability of a successful trial
     * @return The variance of the geometric distribution
     */
    public BigDecimal variance(BigDecimal probOfSuccess){
        BigDecimal probOfFail = BigDecimal.ONE.subtract(probOfSuccess);

        BigDecimal denominator = probOfSuccess.pow(2);

        return probOfFail.divide(denominator, 2, RoundingMode.UP);
    }

    /**
     * The standardDeviation method calculates the standard deviation of a geometric distribution.
     * @param variance The variance of the geometric distribution
     * @return The standard deviation of the geometric distribution
     */
    public double standardDeviation(double variance){
        return Math.sqrt(variance);
    }

    /**
     * The standardDeviation method calculates the standard deviation of the geometric distribution.
     * @param variance The variance of the geometric distribution.
     * @return The standard deviation of the geometric distribution.
     */
    public BigDecimal standardDeviation(BigDecimal variance){
        return variance.sqrt(MathContext.DECIMAL32);
    }

    /**
     * The testerOutput method displays an example output of the methods within the GeometricDistribution class.
     */
    public void testerOutput() {

        //Using problem 3.67 from the book to test methods
        System.out.println("Geometric distribution formula using p = 0.3 and y = 5: " +
                geometricDistribution(0.3, 5));
        System.out.println("Expected value of the distribution: " + expectedValue(0.3));
        System.out.println("Variance of the distribution: " + variance(0.3));
        System.out.println("Standard deviation of the distribution: " + standardDeviation(variance(0.3)));

        System.out.println();

        //Testing same problem with BigInteger and BigDecimal values
        BigInteger y = BigInteger.valueOf(5);
        BigDecimal p = BigDecimal.valueOf(0.3);
        System.out.println("Geometric distribution formula using BigInteger, BigDecimal, p = 0.3 and y = 5: "
                + geometricDistribution(p, y));
        System.out.println("Expected value of the distribution using BigDecimal: " + expectedValue(p));
        System.out.println("Variance of the distribution using BigDecimal: " + variance(p));
        System.out.println("Standard deviation of the distribution using BigDecimal: " +
                standardDeviation(variance(p)));

        System.out.println();

    }

}
