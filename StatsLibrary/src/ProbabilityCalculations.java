import java.math.BigInteger;
import java.util.ArrayList;

public class ProbabilityCalculations {

    /**
     * The conditionalProbability method finds the probability of A given B.
     * @param probAandB The probability of A and B occurring at the same time.
     * @param probB  The probability of B.
     * @return The probability of A given B.
     */
    public double conditionalProbability(double probAandB, double probB){
        return probAandB/probB;
    }

    /**
     * The independence method checks to see if the two events are independent.
     * @param probA The probability of event A.
     * @param probB The probability of event B.
     * @param probAandB The probability of event A and B occurring at the same time.
     * @return True - if the two events are independent, false - if the events are dependent
     */
    public boolean independence(double probA, double probB, double probAandB){
        return probA*probB == probAandB;
    }

    /**
     * The independence method checks to see if the two events are independent.
     * @param probAgivenB The probability of event A given B happened.
     * @param probA The probability of event A.
     * @return True - if the two events are independent, false - if the events are dependent
     */
    public boolean independence(double probAgivenB, double probA){
        return probAgivenB == probA;
    }

    /**
     * The mnRule method finds the total number of simple events given a set of numbers.
     * @param listOfNumbers The list of numbers to be multiplied.
     * @return The total number of simple events.
     */
    public int mnRule(ArrayList<Integer> listOfNumbers){

        //Initialize the total variable
        int total = 1;

        //Loop through the list of numbers
        for(int i : listOfNumbers){

            //Multiply the number by the total
            total = total*i;
        }

        //Return the total
        return total;
    }

    /**
     * The multinomialCoefficient method finds the number of possible groups of objects into multiple different
     * groups.
     * @param n The number of objects.
     * @param listOfSets The list of groups.
     * @return The number of groups that can be made.
     */
    public int multinomialCoefficient(int n, ArrayList<Integer> listOfSets){

        //Initialize the numerator with the factorial of n
        int numerator = factorial(n);

        //Initialize the denominator
        int denominator = 1;

        //Loop through the list of groups
        for(Integer i : listOfSets){

            //Find the factorial of i and then add it to the denominator
            denominator = denominator*factorial(i);
        }

        //Return the double value of the numerator divided by the denominator
        return numerator/denominator;
    }

    /**
     * The multinomialCoefficient method finds the number of possible groups of objects into multiple different
     * groups.
     * @param n The number of objects.
     * @param listOfSets The list of groups.
     * @return The number of groups that can be made.
     */
    public BigInteger multinomialCoefficient(BigInteger n, ArrayList<BigInteger> listOfSets){

        //Initialize the numerator with the factorial of n
        BigInteger numerator = factorial(n);

        //Initialize the denominator
        BigInteger denominator = BigInteger.valueOf(1);

        //Loop through the list of groups
        for(BigInteger i : listOfSets){

            //Find the factorial of i and then add it to the denominator
            denominator = denominator.multiply(factorial(i));
        }

        //Return the BigInteger value of the numerator divided by the denominator
        return numerator.divide(denominator);
    }

    /**
     * The multiplicativeProbability method finds the probability of A and B, depending on if they are independent
     * or not.
     * @param probA The probability of event A.
     * @param probB The probability of event B.
     * @param probAgivenB The probability of event A given B.
     * @return The probability of A and B
     */
    public double multiplicativeProbability(double probA, double probB, double probAgivenB){

        //Check to see if the events are independent
        if (independence(probAgivenB, probA)){

            //if they are return the probability of A times the probability of B
            return probA*probB;
        }

        //Else return the probability of B times the probability of A given B
        return probB*probAgivenB;
    }

    /**
     * The additiveProbability method finds the probability of A or B, depending on if they are independent or not.
     * @param probA The probability of event A.
     * @param probB The probability of event B.
     * @param probAandB The probability of A and B.
     * @return The probability of A or B.
     */
    public double additiveProbability(double probA, double probB, double probAandB){

        //Check to see if the probability of A and B is zero
        if(probAandB == 0){

            //if it is

            //Return the probability of A times the probability of B
            return probA + probB;
        }

        //Else return the probability of A time the probability of B minus the probability of A and B
        return probA + probB - probAandB;
    }

    /**
     * The factorial method calculates the number equal to 1 * 2 * 3 * . . . * n-1 * n (noted usually as n!).
     * @param n The number to find the factorial of.
     * @return The number equal to the factorial of n as an integer.
     */
    public int factorial(int n){

        //Create the starting point for the calculation
        int f = 1;

        //Use for loop to multiply the variable f by all the numbers in front of it up to and including n.
        for(int j = 1; j <= n; j++){

            //Multiply f by the current number in the loop
            f = f * j;
        }

        //Return the factorial of n
        return f;
    }

    /**
     * The factorial method calculates the number equal to 1 * 2 * 3 * . . . * n-1 * n (noted usually as n!).
     * @param n The BigInteger object to find the factorial of.
     * @return A BigInteger object equal to the factorial of n.
     */
    public BigInteger factorial(BigInteger n){

        //Create the starting point for the calculation
        BigInteger f = BigInteger.valueOf(1);

        //Create the count variable for the while loop used later
        BigInteger count = BigInteger.valueOf(1);

        //Use the loop to multiply the variable f by all the numbers in front of it up to and including n.
        while(count.compareTo(n) < 1){

            //Multiply f by the current number in the loop
            f = f.multiply(count);

            //Increment the loop counter
            count = count.add(BigInteger.valueOf(1));
        }

        //Return the BigInteger object equal to the factorial of n
        return f;
    }

}
