/**
 * The StandardDeviationTester class is used to test the StandardDeviation class.
 * @author Rachel Hussmann
 */
public class StandardDeviationTester {

    public static void main(String[] args) {

        //Initialize the array of doubles
        double[] doubleValues = {2.1, 5.9, 11.6, 15.9, 20.3};

        //Initialize the StandardDeviation tester object
        StandardDeviation tester = new StandardDeviation();

        System.out.println("The standard deviation of the doubleValues array is: " +
                tester.standardDeviation(doubleValues));
    }
}
