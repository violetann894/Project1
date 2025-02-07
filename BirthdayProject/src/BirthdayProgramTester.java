/**
 * The BirthdayProgramTester class is used to run trials to figure out the probability that two people in the same class
 * share a birthday.
 * @author Rachel Hussmann
 */
public class BirthdayProgramTester {
    public static void main(String[] args) {

        /*

        Finding significant digits

        Number of Trials: 10
        Class size: 33
        Range of probabilities: 70% - 100%
        Significant digit: Tens place
        Number of significant digits: 1

        Number of Trials: 100
        Class size: 33
        Range of probabilities: 75% - 86%
        Significant digit: Tens and ones place
        Number of significant digits: 2

        Number of Trials: 1000
        Class size: 33
        Range of probabilities: 76.2% - 79.4%
        Significant digit: Tens, ones and tenths place
        Number of significant digits: 3

        Number of Trials: 10000
        Class size: 33
        Range of probabilities: 77.41% - 78.38%
        Significant digit: Tens, ones, tenths and hundredths place
        Number of significant digits: 4

        Number of Trials: 100000
        Class size: 33
        Range of probabilities: 77.337% - 77.556%
        Significant digit: Tens, ones, tenths, hundredths and thousandths place
        Number of significant digits: 5

        Conclusion: As the trials increase, the accuracy of the probabilities and the number of significant digits
        increase.

        */
        //Initializes the tester object for the BirthdayProgram
        BirthdayProgram tester = new BirthdayProgram();

        //Initialize the classSize
        int classSize = 33;

        //Print out a formatted string of the probability that two people share a birthday in the same class
        System.out.printf("The probability that two people share a birthday in a %d person sized class: %.3f", classSize,
                tester.runTrials(100000, classSize)*100);


    }
}
