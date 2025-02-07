/**
 * The StandardDeviation class is an exercise that we started in class that eventually turned into StatsLibrary
 * @author Rachel Hussmann
 */
public class StandardDeviation {

    /**
     * standardDeviation accepts an array of doubles and returns the standard deviation of the data.
     *
     * @param e This method accepts an array of doubles that the user would like the standard deviation found for.
     * @return This method returns a double value equal to standard deviation of the data set.
     */
    public double standardDeviation(double[] e){
        //initializes the sum variable which will be used to find the mean
        double sum = 0.0;

        //for loop iterates through the list to find the sum
        for (int i = 0; i < e.length; i++){
            sum += e[i];
        }

        //initializes the mean variable, which calculates the mean of the dataset
        double mean = sum/e.length;

        //for loop iterates through the array to find the deviation of each value from the mean
        for (int i = 0; i < e.length; i++){
            e[i] = e[i] - mean;
        }

        //for loop iterates through the array to square each value for the next step
        for (int i = 0; i < e.length; i++){
            e[i] = e[i]*e[i];
        }

        //Initializes the sumOfSquares variable which will be used to find the variance
        double sumOfSquares = 0.0;

        //for loop iterates through the list to add all the squared deviations
        for (int i = 0; i < e.length; i++){
            sumOfSquares += e[i];
        }

        //Initializes the variable variance, which is found by taking the sum of the squares and dividing
        //by one less than the number of values in the array
        double variance = sumOfSquares / (e.length - 1);

        //Initializes the variable standardDev, which is the calculation of the array's standard deviation
        double standardDev = Math.sqrt(variance);

        return standardDev;
    }
}
