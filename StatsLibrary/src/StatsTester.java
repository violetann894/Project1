import java.math.BigInteger;
import java.sql.Array;
import java.util.ArrayList;

/**
 * The StatsTester class is used to test the class StatsLibrary and its associated methods.
 * @author Rachel Hussmann
 */
public class StatsTester {

    public static void main(String[] args) {
        //Initializes the even and odd length double arrays and ArrayLists
        double[] doubleValuesOdd = {1.1, 2.5, 3.7, 6.9, 7.4};
        double[] doubleValuesEven = {1.1, 2.5, 3.7, 6.9};
        ArrayList<Double> doubleArrayListOdd = new ArrayList<>();
        ArrayList<Double> doubleArrayListEven = new ArrayList<>();

        //Initializes the even and odd length integer arrays and ArrayLists
        int[] intValuesOdd = {1, 2, 3, 4, 5};
        int[] intValuesEven = {1, 2, 3, 4};
        ArrayList<Integer> intArrayListOdd = new ArrayList<>();
        ArrayList<Integer> intArrayListEven = new ArrayList<>();

        //Initializes the double array and ArrayList for checking the mode methods
        double[] doubleValuesMode = {1.1, 1.1, 3.5, 3.5, 6.2, 7.9, 10.3};
        ArrayList<Double> doubleArrayListMode = new ArrayList<>();

        //Initializes the integer array and ArrayList for checking the mode methods
        int[] intValuesMode = {1, 1, 2, 3, 3, 6, 7, 8, 9, 9};
        ArrayList<Integer> intArrayListMode = new ArrayList<>();

        //Adds values to the doubleArrayListOdd
        doubleArrayListOdd.add(1.1);
        doubleArrayListOdd.add(2.5);
        doubleArrayListOdd.add(3.7);
        doubleArrayListOdd.add(6.9);
        doubleArrayListOdd.add(7.4);

        //Adds values to the doubleArrayListEven
        doubleArrayListEven.add(1.1);
        doubleArrayListEven.add(2.5);
        doubleArrayListEven.add(3.7);
        doubleArrayListEven.add(6.9);

        //Adds values to the intArrayListOdd
        intArrayListOdd.add(1);
        intArrayListOdd.add(2);
        intArrayListOdd.add(3);
        intArrayListOdd.add(4);
        intArrayListOdd.add(5);

        //Adds values to the intArrayListEven
        intArrayListEven.add(1);
        intArrayListEven.add(2);
        intArrayListEven.add(3);
        intArrayListEven.add(4);

        //Adds values to the doubleArrayListMode
        doubleArrayListMode.add(1.1);
        doubleArrayListMode.add(1.1);
        doubleArrayListMode.add(3.5);
        doubleArrayListMode.add(3.5);
        doubleArrayListMode.add(6.2);
        doubleArrayListMode.add(7.9);
        doubleArrayListMode.add(10.3);

        //Adds values to the intArrayListMode
        intArrayListMode.add(1);
        intArrayListMode.add(1);
        intArrayListMode.add(2);
        intArrayListMode.add(3);
        intArrayListMode.add(3);
        intArrayListMode.add(6);
        intArrayListMode.add(7);
        intArrayListMode.add(8);
        intArrayListMode.add(9);
        intArrayListMode.add(9);

        //Creates an object of the StatsLibrary class for testing
        StatsLibrary tester = new StatsLibrary();

        //Prints out the results of the getMeanDouble() and getMeanInt() methods
        System.out.println("Result of mean (using double array): " + tester.getMeanDouble(doubleValuesOdd));
        System.out.println("Result of mean (using ArrayList<Double>): " + tester.getMeanDouble(doubleArrayListOdd));
        System.out.println("Result of mean (using int array): " + tester.getMeanInt(intValuesOdd));
        System.out.println("Result of mean (using ArrayList<Integer>): " + tester.getMeanInt(intArrayListOdd));

        System.out.println();

        //Prints out the results of the getMedianDouble() and getMedianInt() methods
        System.out.println("Result of median (using odd double array): " + tester.getMedianDouble(doubleValuesOdd));
        System.out.println("Result of median (using even double array): " + tester.getMedianDouble(doubleValuesEven));
        System.out.println("Result of median (using odd ArrayList<Double>): " +
                tester.getMedianDouble(doubleArrayListOdd));
        System.out.println("Result of median (using even ArrayList<Double>): " +
                tester.getMedianDouble(doubleArrayListEven));
        System.out.println("Result of median (using odd int array): " + tester.getMedianInt(intValuesOdd));
        System.out.println("Result of median (using even int array): " + tester.getMedianInt(intValuesEven));
        System.out.println("Result of median (using odd ArrayList<Integer>): " + tester.getMedianInt(intArrayListOdd));
        System.out.println("Result of median (using even ArrayList<Integer>): " + tester.getMedianInt(intArrayListEven));

        System.out.println();

        //Prints out the results of the getModeDouble() and getModeInt() methods
        System.out.println("Result of mode (using double array): " + tester.getModeDouble(doubleValuesMode));
        System.out.println("Result of mode (using ArrayList<Double>): " + tester.getModeDouble(doubleArrayListMode));
        System.out.println("Result of mode (using int array): " + tester.getModeInt(intValuesMode));
        System.out.println("Result of mode (using ArrayList<Integer>): " + tester.getModeInt(intArrayListMode));

        System.out.println();

        //Prints out the results of the getStandardDeviationDouble() and getStandardDeviationInt() methods
        System.out.println("Result of standard deviation (using double array): " +
                tester.getStandardDeviationDouble(doubleValuesOdd));
        System.out.println("Result of standard deviation (using ArrayList<Double>): " +
                tester.getStandardDeviationDouble(doubleArrayListOdd));
        System.out.println("Result of standard deviation (using int array) : " +
                tester.getStandardDeviationInt(intValuesOdd));
        System.out.println("Result of standard deviation (using ArrayList<Integer>): " +
                tester.getStandardDeviationInt(intArrayListOdd));

        System.out.println();

        //Initializes some BigInteger objects for test cases
        BigInteger n = BigInteger.valueOf(6);
        BigInteger r = BigInteger.valueOf(2);

        //Testing simple example to make sure that factorial, getPermutation and getCombination methods work
        System.out.println("Combinations of n = 6 and r = 2: " + tester.getCombination(6, 2));
        System.out.println("Combinations of n = 6 and r = 2 using BigInteger: " + tester.getCombination(n, r));
        System.out.println("Permutations of n = 6 and r = 2: " + tester.getPermutation(6, 2));
        System.out.println("Permutations of n = 6 and r = 2 using BigInteger: " + tester.getPermutation(n, r));

        //Testing out an example from the book
        //Example 2.8 - Pizza problem
        //According to the textbook, the problem is a permutation and the answer is 24360
        BigInteger f = BigInteger.valueOf(30);
        BigInteger g = BigInteger.valueOf(3);

        System.out.println("Testing example 2.8 from the book (answer should be 24360): " +
                tester.getPermutation(f, g));

        //Solve a problem from the textbook homework

        //Problem 2.57 "Two cards are drawn from a standard 52-card playing deck. What is the probability that the
        //draw will yield an ace and a face card?"
        BigInteger v = BigInteger.valueOf(52);
        BigInteger m = BigInteger.valueOf(2);

        //We are choosing one of the available aces. There are 4 aces in a deck of cards so we need to find the number
        //of combinations (since order doesn't matter) we can make from 4 choose 1.
        BigInteger aces = tester.getCombination(BigInteger.valueOf(4), BigInteger.valueOf(1));

        //We are choosing one of the available aces. There are 12 faces in a deck of cards so we need to find the number
        //of combinations (since order doesn't matter) we can make from 12 choose 1.
        BigInteger faces = tester.getCombination(BigInteger.valueOf(12), BigInteger.valueOf(1));

        //We need to find the total number of combinations we can find for 52 pick 2 (since order doesn't matter).
        BigInteger totalNumber = tester.getCombination(v, m);

        //Since we have two number of combinations, we need to multiply them together to find the total number of
        //combinations for those two situations specifically.
        BigInteger wantedOutcome = aces.multiply(faces);

        //We then divide the wantedOutcome by the totalNumber of outcomes to give us our probability.
        System.out.println("The probability of drawing an ace and a face card in the same draw is: " + wantedOutcome
                + "/" + totalNumber);

        //Confirmed answer with the answer in the back of the textbook (48/1326 or .0362)

        System.out.println();

        //Initializes the ArrayList that will hold the sample values
        ArrayList<String> sample = new ArrayList<>();

        //Adding the sample values to the sample ArrayList
        sample.add("Monday");
        sample.add("Tuesday");
        sample.add("Wednesday");
        sample.add("Thursday");
        sample.add("Friday");
        sample.add("Saturday");
        sample.add("Sunday");

        //Initializes the ArrayLists that will be used to test the union, intersect and complement methods
        ArrayList<String> array1 = new ArrayList<>();
        ArrayList<String> array2 = new ArrayList<>();

        //Adding values to array1
        array1.add("Monday");
        array1.add("Tuesday");
        array1.add("Wednesday");

        //Adding values to array2
        array2.add("Wednesday");
        array2.add("Thursday");
        array2.add("Friday");

        //Finds and prints out the union between array1 and array2
        System.out.println("Union: " + tester.union(array1, array2));

        //Finds and prints out the intersection between array1 and array2
        System.out.println("Intersect: " + tester.intersect(array1, array2));

        //Finds and prints out the ArrayList that is the complement to array1
        System.out.println("Complement: " + tester.complement(array1, sample));

        System.out.println();

        //Testing conditional probability
        System.out.println("Conditional Probability: " + tester.conditionalProbability(0.20,
                0.5));

        //Testing the different forms of independence
        System.out.println("Independence of P(A) = .40, P(B) = .37, P(A and B): " +
                tester.independence(.40, .37, .10));
        System.out.println("Independence of P(A) = .40 and P(A|B) = 0.27: " +
                tester.independence(0.27, .40));

        //Testing the mn rule
        System.out.println("mn rule for 1, 2, 3, 4, 5: " + tester.mnRule(intArrayListOdd));

        //Initialize the ArrayList of integers
        ArrayList<Integer> listOfNumbers = new ArrayList<>();

        //Adds numbers to the listOfNumbers
        listOfNumbers.add(6);
        listOfNumbers.add(4);

        //Initialize the ArrayList of BigIntegers
        ArrayList<BigInteger> listOfBigNumbers = new ArrayList<>();

        //Adds BigIntegers to the listOfBigNumbers
        listOfBigNumbers.add(BigInteger.valueOf(6));
        listOfBigNumbers.add(BigInteger.valueOf(4));


        //Testing multinomial coefficient
        System.out.println("Multinomial coefficient: " + tester.multinomialCoefficient(10, listOfNumbers));
        System.out.println("Multinomial coefficient: " + tester.multinomialCoefficient(BigInteger.valueOf(10),
                listOfBigNumbers));

        //Testing multiplicative rule
        System.out.println("Multiplicative rule (independent): " +
                tester.multiplicativeProbability(0.5, 0.16666667, 0.5));
        System.out.println("Multiplicative rule (dependent): " +
                tester.multiplicativeProbability(0.4, 0.286, 0.9));

        //Testing additive rule
        System.out.println("Additive rule (independent): " +
                tester.additiveProbability(0.5, 0.16666, 0.0));
        System.out.println("Additive rule (dependent): " +
                tester.additiveProbability(0.6, 0.1, 0.4));
    }

}
