import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * The StatsLibrary class is a collection of statistical calculations that I have learned in my Probability and
 * Applied Statistics class.
 *
 * @author Rachel Hussmann
 */

public class StatsLibrary {

    /**
     * getMeanDouble accepts an array of doubles and finds the mean of the values.
     *
     * @param values This method accepts an array of doubles that the user would like the mean calculated for.
     * @return This method returns a double value equal to the mean of the parameter.
     */
    public double getMeanDouble(double[] values){

        //Initializes the sum variable
        double sum = 0.0;

        //Loops through the dataset and adds up all the values
        for(double value: values){
            sum += value;
        }

        //Divides the sum by the length of the dataset to find the mean
        double mean = (sum / values.length);

        //Method returns the mean value of the dataset
        return mean;
    }

    /**
     * getMeanInt accepts an array of integers and finds the mean of the values.
     *
     * @param values This method accepts an array of integers that the user would like the mean calculated for.
     * @return This method returns a double value equal to the mean of the parameter.
     */
    public double getMeanInt(int[] values){

        //Initializes the sum variable
        int sum = 0;

        //Loops through the dataset and adds up all the values
        for(int value: values){
            sum += value;
        }

        //Divides the sum by the length of the dataset to find the mean
        double mean = (double)(sum / values.length);

        //Method returns the mean value of the dataset
        return mean;
    }

    /**
     * getMeanDouble accepts an ArrayList of doubles and finds the mean of the values.
     *
     * @param values This method accepts an ArrayList of doubles that the user would like the mean calculated for.
     * @return This method returns a double value equal to the mean of the parameter.
     */
    public double getMeanDouble(ArrayList<Double> values){

        //Initializes the sum variable
        double sum = 0.0;

        //Loops through the dataset and adds up all the values
        for (double value: values){
            sum += value;
        }

        //Divides the sum by the size of the dataset to find the mean
        double mean = sum / values.size();

        //Method returns the mean value of the dataset
        return mean;
    }

    /**
     * getMeanInt accepts an ArrayList of integers and finds the mean of the values.
     *
     * @param values This method accepts an ArrayList of integers that the user would like the mean calculated for.
     * @return This method returns a double value equal to the mean of the parameter.
     */
    public double getMeanInt(ArrayList<Integer> values){

        //Initializes the sum variable
        int sum = 0;

        //Loops through the dataset and adds up all the values
        for(int value: values){
            sum += value;
        }

        //Divides the sum by the size of the dataset to find the mean
        double mean = (double)(sum / values.size());

        //Method returns the mean value of the dataset
        return mean;
    }

    /**
     * getMedianDouble accepts an array of doubles and finds the median of the values.
     *
     * @param values This method accepts an array of doubles that the user would like the median found for.
     * @return This method returns a double value equal to the median of the parameter.
     */
    public double getMedianDouble(double[] values){

        //Sorts the array before calculations are done
        //According to the JavaDocs for Arrays.sort(), a dual pivot quicksort used to put the values in order.
        Arrays.sort(values);

        //Checks to see if the length of the dataset is odd or even
        if(values.length % 2 == 1){

            //If dataset is odd

            //Find the index of the middle value, which is just the ceiling value of the dataset divided by 2
            int index = (int)Math.ceil(values.length / 2);

            //Grab the value of the median
            double median = values[index];

            //Method returns the median
            return median;
        }else {

            //If dataset is even

            //Find the index that will be used to find the first and second values
            int index = values.length / 2;

            //Find the first value
            double firstValue = values[index];

            //Find the second value
            double secondValue = values[index + 1];

            //Find the average of the two values to find the median
            double median = (firstValue + secondValue) / 2.0;

            //Method returns the median
            return median;
        }
    }

    /**
     * getMedianInt accepts an array of integers and returns the median of the values.
     *
     * @param values This method accepts an array of integers that the user would like the median calculated for.
     * @return This method returns a double value equal to the median of the parameter.
     */
    public double getMedianInt(int[] values){

        //Sorts the array before calculations are done
        //According to the JavaDocs for Arrays.sort(), a dual pivot quicksort is used to put the values in order.
        Arrays.sort(values);

        //Checks to see if the length of the dataset is odd or even
        if(values.length % 2 == 1){

            //If dataset is odd

            //Find the index of the middle value, which is just the ceiling value of the dataset divided by 2
            int index = (int)Math.ceil(values.length / 2);

            //Grab the value of the median
            double median = values[index];

            //Method returns the median
            return median;
        }else{

            //If dataset is even

            //Find the index that will be used to find the first and second values
            int index = values.length / 2;

            //Find the first value
            double firstValue = values[index];

            //Find the second value
            double secondValue = values[index + 1];

            //Find the average of the two values to find the median
            double median = (firstValue + secondValue) / 2.0;

            //Method returns the median
            return median;
        }
    }

    /**
     * getMedianDouble accepts an ArrayList of doubles and returns the median of the values.
     *
     * @param values This method accepts an ArrayList of doubles that the user would like the median calculated for.
     * @return This method returns a double value equal to the median of the parameter.
     */
    public double getMedianDouble(ArrayList<Double> values){

        //Sorts the ArrayList before performing calculations
        /* According to the JavaDocs for list.sort(), the interface Collections is built on,
           a merge sort is used to put the values in order. */
        Collections.sort(values);

        //Checks to see if the length of the dataset is odd or even
        if(values.size() % 2 == 1){

            //If dataset is odd

            //Find the index of the middle value, which is just the ceiling value of the dataset divided by 2
            int index = (int)Math.ceil(values.size() / 2);

            //Grab the value of the median
            double median = values.get(index);

            //Method returns the median
            return median;
        }else{

            //If dataset is even

            //Find the index that will be used to find the first and second values
            int index = values.size() / 2;

            //Find the first value
            double firstValue = values.get(index);

            //Find the second value
            double secondValue = values.get(index + 1);

            //Find the average of the two values to find the median
            double median = (firstValue + secondValue) / 2.0;

            //Method returns the median
            return median;
        }

    }

    /**
     * getMedianInt accepts an ArrayList of integers and returns the median of the values.
     *
     * @param values This method accepts an ArrayList of integers that the user would like the median calculated for.
     * @return This method returns a double value equal to the median of the parameter.
     */
    public double getMedianInt(ArrayList<Integer> values){

        //Sorts the ArrayList before performing calculations
        /* According to the JavaDocs for list.sort(), the interface Collections is built on,
           a merge sort is used to put the values in order. */
        Collections.sort(values);

        //Checks to see if the length of the dataset is odd or even
        if(values.size() % 2 == 1){

            //If dataset is odd

            //Find the index of the middle value, which is just the ceiling value of the dataset divided by 2
            int index = (int)Math.ceil(values.size() / 2);

            //Grab the value of the median
            double median = values.get(index);

            //Method returns the median
            return median;
        }else{

            //If dataset is even

            //Find the index that will be used to find the first and second values
            int index = values.size() / 2;

            //Find the first value
            double firstValue = values.get(index);

            //Find the second value
            double secondValue = values.get(index + 1);

            //Find the average of the two values to find the median
            double median = (firstValue + secondValue) / 2.0;

            //Method returns the median
            return median;
        }
    }

    /**
     * getModeDouble accepts an array of doubles and finds the mode(s).
     *
     * @param values This method accepts an array of doubles that the user would like the mode(s) found for.
     * @return This method returns an ArrayList of doubles that contains the mode(s) of the data.
     */
    public ArrayList<Double> getModeDouble(double[] values){

        //Sorts the array before calculations are done
        //According to the JavaDocs for Arrays.sort(), a dual pivot quicksort is used to put the values in order.
        Arrays.sort(values);

        //Initializes the ArrayList that will hold the mode(s) of the dataset
        ArrayList<Double> modes = new ArrayList<>();

        //Initializes the variable that will be used to hold the number previous to the current one
        double previousNum = 0.0;

        //Initializes the variable that will be used to count the highest number of occurrences seen so far
        int highestNumOfOccur = 1;

        //Initializes the variable that will be used to count the current number of occurrences of the same number
        int currentNumOccur = 0;

        //Iterate through the values array
        for(double value : values) {

            //if the current value is larger than the previous one
            if (value > previousNum) {

                //Check the previous number's number of occurrences
                //If the previous number's number of occurrences is equal to the highest number of occurrences
                if (currentNumOccur == highestNumOfOccur) {

                    //Add the previous number to the list of modes for the dataset
                    modes.add(previousNum);

                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                } else if (currentNumOccur > highestNumOfOccur) {

                    /* else if the current number of occurrences of the previous number is higher than the highest
                    number of occurrences */

                    //Clear the list of modes. Those values are not the most frequent anymore
                    modes.clear();

                    //Add the previous number to the list of modes
                    modes.add(previousNum);

                    //Set the highest number of occurrences equal to the previous number's number of occurrences
                    highestNumOfOccur = currentNumOccur;

                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                } else {
                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                }
            }
            /* If the value is not greater than the previous number,
            we can assume it is the same since this dataset is already sorted. */

            //Increase the number of occurrences of the current number
            currentNumOccur++;

            //Set the previous number to the value we just used since we are moving on to another value
            previousNum = value;
        }

        //Repeat of code above to check the last value in the array
        //If the previous number's number of occurrences is equal to the highest number of occurrences
        if (currentNumOccur == highestNumOfOccur) {

            //Add the previous number to the list of modes for the dataset
            modes.add(previousNum);
        } else if (currentNumOccur > highestNumOfOccur) {

            /* else if the current number of occurrences of the previous number is higher than the highest
                    number of occurrences */

            //Clear the list of modes. Those values are not the most frequent anymore
            modes.clear();

            //Add the previous number to the list of modes
            modes.add(previousNum);
        }

        //Method returns the list of modes
        return modes;
    }

    /**
     * getModeInt accepts and array of integers and finds the mode(s).
     *
     * @param values This method accepts an array of integers that the user would like the mode(s) found for.
     * @return This method returns an ArrayList of doubles that contains the mode(s) of the data.
     */
    public ArrayList<Integer> getModeInt(int[] values) {

        //Sorts the array before calculations are done
        //According to the JavaDocs for Arrays.sort(), a dual pivot quicksort is used to put the values in order.
        Arrays.sort(values);

        //Initializes the ArrayList that will hold the mode(s) of the dataset
        ArrayList<Integer> modes = new ArrayList<>();

        //Initializes the variable that will be used to hold the number previous to the current one
        int previousNum = 0;

        //Initializes the variable that will be used to count the highest number of occurrences seen so far
        int highestNumOfOccur = 1;

        //Initializes the variable that will be used to count the current number of occurrences of the same number
        int currentNumOccur = 0;

        //Iterate through the values array
        for(int value : values) {

            //if the current value is larger than the previous one
            if (value > previousNum) {

                //Check the previous number's number of occurrences
                //If the previous number's number of occurrences is equal to the highest number of occurrences
                if (currentNumOccur == highestNumOfOccur) {

                    //Add the previous number to the list of modes for the dataset
                    modes.add(previousNum);

                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                } else if (currentNumOccur > highestNumOfOccur) {

                    /* else if the current number of occurrences of the previous number is higher than the highest
                    number of occurrences */

                    //Clear the list of modes. Those values are not the most frequent anymore
                    modes.clear();

                    //Add the previous number to the list of modes
                    modes.add(previousNum);

                    //Set the highest number of occurrences equal to the previous number's number of occurrences
                    highestNumOfOccur = currentNumOccur;

                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                } else {
                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                }
            }
            /* If the value is not greater than the previous number,
            we can assume it is the same since this dataset is already sorted. */

            //Increase the number of occurrences of the current number
            currentNumOccur++;

            //Set the previous number to the value we just used since we are moving on to another value
            previousNum = value;
        }

        //Repeat of code above to check the last value in the array
        //If the previous number's number of occurrences is equal to the highest number of occurrences
        if (currentNumOccur == highestNumOfOccur) {

            //Add the previous number to the list of modes for the dataset
            modes.add(previousNum);
        } else if (currentNumOccur > highestNumOfOccur) {

            /* else if the current number of occurrences of the previous number is higher than the highest
                    number of occurrences */

            //Clear the list of modes. Those values are not the most frequent anymore
            modes.clear();

            //Add the previous number to the list of modes
            modes.add(previousNum);
        }

        //Method returns the list of modes
        return modes;
    }

    /**
     * getModeDouble accepts an ArrayList of doubles and finds the mode(s).
     *
     * @param values This method accepts an ArrayList of doubles that the user would like the mode(s) found for.
     * @return This method returns an ArrayList of doubles that contains the mode(s) of the data.
     */
    public ArrayList<Double> getModeDouble(ArrayList<Double> values){

        //Sorts the ArrayList before performing calculations
        /* According to the JavaDocs for list.sort(), the interface Collections is built on,
           a merge sort is used to put the values in order. */
        Collections.sort(values);

        //Initializes the ArrayList that will hold the mode(s) of the dataset
        ArrayList<Double> modes = new ArrayList<>();

        //Initializes the variable that will be used to hold the number previous to the current one
        double previousNum = 0.0;

        //Initializes the variable that will be used to count the highest number of occurrences seen so far
        int highestNumOfOccur = 1;

        //Initializes the variable that will be used to count the current number of occurrences of the same number
        int currentNumOccur = 0;

        //Iterate through the values ArrayList
        for(double value : values) {

            //if the current value is larger than the previous one
            if (value > previousNum) {

                //Check the previous number's number of occurrences
                //If the previous number's number of occurrences is equal to the highest number of occurrences
                if (currentNumOccur == highestNumOfOccur) {

                    //Add the previous number to the list of modes for the dataset
                    modes.add(previousNum);

                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                } else if (currentNumOccur > highestNumOfOccur) {

                    /* else if the current number of occurrences of the previous number is higher than the highest
                    number of occurrences */

                    //Clear the list of modes. Those values are not the most frequent anymore
                    modes.clear();

                    //Add the previous number to the list of modes
                    modes.add(previousNum);

                    //Set the highest number of occurrences equal to the previous number's number of occurrences
                    highestNumOfOccur = currentNumOccur;

                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                } else {
                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                }
            }
            /* If the value is not greater than the previous number,
            we can assume it is the same since this dataset is already sorted. */

            //Increase the number of occurrences of the current number
            currentNumOccur++;

            //Set the previous number to the value we just used since we are moving on to another value
            previousNum = value;
        }

        //Repeat of code above to check the last value in the array
        //If the previous number's number of occurrences is equal to the highest number of occurrences
        if (currentNumOccur == highestNumOfOccur) {

            //Add the previous number to the list of modes for the dataset
            modes.add(previousNum);
        } else if (currentNumOccur > highestNumOfOccur) {

            /* else if the current number of occurrences of the previous number is higher than the highest
                    number of occurrences */

            //Clear the list of modes. Those values are not the most frequent anymore
            modes.clear();

            //Add the previous number to the list of modes
            modes.add(previousNum);
        }

        //Method returns the list of modes
        return modes;
    }

    /**
     * getModeInt accepts an ArrayList of integers and finds the mode(s).
     *
     * @param values This method accepts an ArrayList of integers that the user would like the mode(s) found for.
     * @return This method returns an ArrayList of doubles that contains the mode(s) of the data.
     */
    public ArrayList<Integer> getModeInt(ArrayList<Integer> values){

        //Sorts the ArrayList before performing calculations
        /* According to the JavaDocs for list.sort(), the interface Collections is built on,
           a merge sort is used to put the values in order. */
        Collections.sort(values);

        //Initializes the ArrayList that will hold the mode(s) of the dataset
        ArrayList<Integer> modes = new ArrayList<>();

        //Initializes the variable that will be used to hold the number previous to the current one
        int previousNum = 0;

        //Initializes the variable that will be used to count the highest number of occurrences seen so far
        int highestNumOfOccur = 1;

        //Initializes the variable that will be used to count the current number of occurrences of the same number
        int currentNumOccur = 0;

        //Iterate through the values ArrayList
        for(int value : values) {

            //if the current value is larger than the previous one
            if (value > previousNum) {

                //Check the previous number's number of occurrences
                //If the previous number's number of occurrences is equal to the highest number of occurrences
                if (currentNumOccur == highestNumOfOccur) {

                    //Add the previous number to the list of modes for the dataset
                    modes.add(previousNum);

                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                } else if (currentNumOccur > highestNumOfOccur) {

                    /* else if the current number of occurrences of the previous number is higher than the highest
                    number of occurrences */

                    //Clear the list of modes. Those values are not the most frequent anymore
                    modes.clear();

                    //Add the previous number to the list of modes
                    modes.add(previousNum);

                    //Set the highest number of occurrences equal to the previous number's number of occurrences
                    highestNumOfOccur = currentNumOccur;

                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                } else {
                    //Reset the current number of occurrences since we are moving on to a new number
                    currentNumOccur = 0;
                }
            }
            /* If the value is not greater than the previous number,
            we can assume it is the same since this dataset is already sorted. */

            //Increase the number of occurrences of the current number
            currentNumOccur++;

            //Set the previous number to the value we just used since we are moving on to another value
            previousNum = value;
        }

        //Repeat of code above to check the last value in the array
        //If the previous number's number of occurrences is equal to the highest number of occurrences
        if (currentNumOccur == highestNumOfOccur) {

            //Add the previous number to the list of modes for the dataset
            modes.add(previousNum);
        } else if (currentNumOccur > highestNumOfOccur) {

            /* else if the current number of occurrences of the previous number is higher than the highest
                    number of occurrences */

            //Clear the list of modes. Those values are not the most frequent anymore
            modes.clear();

            //Add the previous number to the list of modes
            modes.add(previousNum);
        }

        //Method returns the list of modes
        return modes;
    }

    /**
     * getStandardDeviationDouble accepts an array of doubles and returns the standard deviation of the data.
     *
     * @param values This method accepts an array of doubles that the user would like the standard deviation found for.
     * @return This method returns a double value equal to standard deviation of the data set.
     */
    public double getStandardDeviationDouble(double[] values){

        //Initializes the variable and calls the getMeanDouble() method to find the mean of the dataset
        double mean = getMeanDouble(values);

        //Initializes the variable that will hold the sum of squared values
        double sumOfSquares = 0.0;

        //Iterates through the array
        for (double value : values){

            //Subtract the mean from the value
            value -= mean;

            //Find the square of the value
            value = value*value;

            //Add the value to the sumOfSquares variable
            sumOfSquares += value;
        }

        /* Finds the variance of the dataset by taking the sum of the squares
           and dividing it by one less than the total number of values */
        double variance = sumOfSquares / (values.length - 1);

        //Returns the square root of the variance, which is the standard deviation of the dataset
        return Math.sqrt(variance);
    }

    /**
     * getStandardDeviationInt accepts an array of integers and returns the standard deviation of the data.
     *
     * @param values This method accept an array of integers that the user would like the standard deviation found for.
     * @return This method returns a double value equal to the standard deviation of the data set.
     */
    public double getStandardDeviationInt(int[] values){

        //Initializes the variable and calls the getMeanInt() method to find the mean of the dataset
        double mean = getMeanInt(values);

        //Initializes the variable that will hold the sum of squared values
        double sumOfSquares = 0.0;

        //Iterates through the array
        for (int value : values){

            //Subtract the mean from the value
            value -= mean;

            //Find the square of the value
            value = value*value;

            //Add the value to the sumOfSquares variable
            sumOfSquares += value;
        }

        /* Finds the variance of the dataset by taking the sum of the squares
           and dividing it by one less than the total number of values */
        double variance = sumOfSquares / (values.length - 1);

        //Returns the square root of the variance, which is the standard deviation of the dataset
        return Math.sqrt(variance);
    }

    /**
     * getStandardDeviationDouble accepts an ArrayList of doubles and returns the standard deviation of the data.
     *
     * @param values This method accept an ArrayList of doubles that the user would like the standard deviation
     *               found for.
     * @return This method returns a double value equal to the standard deviation of the data set.
     */
    public double getStandardDeviationDouble(ArrayList<Double> values){

        //Initializes the variable and calls the getMeanDouble() method to find the mean of the dataset
        double mean = getMeanDouble(values);

        //Initializes the variable that will hold the sum of squared values
        double sumOfSquares = 0.0;

        //Iterates through the ArrayList
        for (double value : values){

            //Subtract the mean from the value
            value -= mean;

            //Find the square of the value
            value = value*value;

            //Add the value to the sumOfSquares variable
            sumOfSquares += value;
        }

        /* Finds the variance of the dataset by taking the sum of the squares
           and dividing it by one less than the total number of values */
        double variance = sumOfSquares / (values.size() - 1);

        //Returns the square root of the variance, which is the standard deviation of the dataset
        return Math.sqrt(variance);
    }

    /**
     * getStandardDeviationDouble accepts an ArrayList of integers and returns the standard deviation of the data.
     *
     * @param values This method accept an ArrayList of integers that the user would like the standard deviation
     *               found for.
     * @return This method returns a double value equal to the standard deviation of the data set.
     */
    public double getStandardDeviationInt(ArrayList<Integer> values){

        //Initializes the variable and calls the getMeanInt() method to find the mean of the dataset
        double mean = getMeanInt(values);

        //Initializes the variable that will hold the sum of squared values
        double sumOfSquares = 0.0;

        //Iterates through the ArrayList
        for (int value : values){

            //Subtract the mean from the value
            value -= mean;

            //Find the square of the value
            value = value*value;

            //Add the value to the sumOfSquares variable
            sumOfSquares += value;
        }

        /* Finds the variance of the dataset by taking the sum of the squares
           and dividing it by one less than the total number of values */
        double variance = sumOfSquares / (values.size() - 1);

        //Returns the square root of the variance, which is the standard deviation of the dataset
        return Math.sqrt(variance);
    }

    /**
     * The union method accepts two ArrayLists of strings and returns distinct strings that are shared
     * between the two inputted ArrayLists.
     *
     * @param array1 This parameter accepts an ArrayList of strings to be joined with array2.
     * @param array2 This parameter accepts an ArrayList of strings to be joined with array1.
     * @return This method returns an ArrayList of the distinct strings of both ArrayLists.
     */
    public ArrayList<String> union(ArrayList<String> array1, ArrayList<String> array2){
        //Initializes the ArrayLists needed to find the union
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> holder = new ArrayList<>();

        //Adds the ArrayLists to the result ArrayList
        holder.addAll(array1);
        holder.addAll(array2);

        //Sorts the set for easier duplicate removal
        Collections.sort(holder);

        //Looks at the previous string
        String previousValue = "";

        //Sets the highest number of occurrences allowed
        int highestNumOfOccur = 1;

        //Tracker of the number of occurrences of the current value
        int currentNumOfOccur = 0;

        //Iterates through the holder list
        for(String value : holder){

            //If the value is not the same as the previous value
            if(!value.equals(previousValue)){

                //Add the value to the list
                result.add(value);

                //Reset the number of occurrences
                currentNumOfOccur = 1;

            }else{
                //Otherwise

                //Increase the number of occurrences, since it is the same value
                currentNumOfOccur ++;

                //If the current number of occurrences is less than or equal to the highest number allowed
                if(currentNumOfOccur <= highestNumOfOccur){

                    //Add it to the results
                    result.add(value);
                }
            }
            //Set the previous value
            previousValue = value;
        }

        //Method returns the result of the union between array1 and array2
        return result;
    }

    /**
     * The intersect method accepts two ArrayLists of strings and returns the strings that are only in both ArrayLists.
     *
     * @param array1 This parameter accepts an ArrayList of strings to compare to array2.
     * @param array2 This parameter accepts and ArrayList of strings to compare to array1.
     * @return This method returns an ArrayList of strings that are only in both ArrayLists.
     */
    public ArrayList<String> intersect(ArrayList<String> array1, ArrayList<String> array2){
        //Initializes the ArrayLists needed to find the intersection
        ArrayList<String> result = new ArrayList<>();
        ArrayList<String> holder = new ArrayList<>();

        //Loops through the two lists to see what values both have; adds them to the result ArrayList
        for(String value1: array1){
            for(String value2: array2){
                if(value1.equals(value2)){
                    holder.add(value1);
                }
            }
        }

        //Sorts the set for easier duplicate removal
        Collections.sort(holder);

        //Looks at the previous string
        String previousValue = "";

        //Sets the highest number of occurrences allowed
        int highestNumOfOccur = 1;

        //Tracker of the number of occurrences of the current value
        int currentNumOfOccur = 0;

        //Iterates through the holder list
        for(String value : holder){

            //If the value is not the same as the previous value
            if(!value.equals(previousValue)){

                //Add the value to the list
                result.add(value);

                //Reset the number of occurrences
                currentNumOfOccur = 1;

            }else{
                //Otherwise

                //Increase the number of occurrences, since it is the same value
                currentNumOfOccur ++;

                //If the current number of occurrences is less than or equal to the highest number allowed
                if(currentNumOfOccur <= highestNumOfOccur){

                    //Add it to the results
                    result.add(value);
                }
            }
            //Set the previous value
            previousValue = value;
        }

        //Method returns the result of the intersection between array1 and array2
        return result;
    }

    /**
     * The complement method accepts two ArrayLists of strings, a subset and the sample, and returns strings that
     * are not in the subset.
     *
     * @param subset This parameter accepts an ArrayList of strings that contains a part of the full dataset.
     * @param sample This parameter accepts an ArrayList of strings that is a sample of the full dataset.
     * @return This method returns an ArrayList of strings that contains all the values not in the given subset.
     */
    public ArrayList<String> complement(ArrayList<String> subset, ArrayList<String> sample){
        //Loops through the subset to remove the value from the sample
        for(String value: subset){
            sample.remove(value);
        }

        //Method returns the sample which has had all the subset values removed
        return sample;
    }

    /**
     * The getCombination method uses the Combination formula and integers to calculate the number of combinations that
     * are possible.
     * @param n The size of the set to choose from.
     * @param r The number of choices to be made from the set.
     * @return The total number of combinations that can be made from n and k as an integer.
     */
    public int getCombination(int n, int r){

        //This method follows the formula for combinations n!/r!(n-r)!

        //Find the numerator for the fraction
        int numerator = factorial(n);

        //Find the denominator of the fractions
        int denominator = factorial(r)*factorial(n-r);

        //Return the number that results from dividing the numerator by the denominator
        return numerator/denominator;
    }

    /**
     * The getCombination method uses the Combination formula and BigInteger objects to calculate the number of
     * combinations that are possible.
     * @param n The size of the set to choose from.
     * @param r The number of choices to be made from the set.
     * @return The total number of combinations that can be made from n and k as a BigInteger object.
     */
    public BigInteger getCombination(BigInteger n, BigInteger r){

        //This method follows the formula for combinations n!/r!(n-r)!

        //Find the numerator for the fraction
        BigInteger numerator = factorial(n);

        //Find the denominator of the fractions
        BigInteger denominator = factorial(r).multiply(factorial(n.subtract(r)));

        //Return the number that results from dividing the numerator by the denominator
        return numerator.divide(denominator);
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

    /**
     * The getPermutation method uses the Permutation formula and integers to calculate the number of groups that
     * are possible.
     * @param n The size of the set to choose from.
     * @param r The number of choices to be made from the set.
     * @return The total number of groups that can be made from n and k as an integer.
     */
    public int getPermutation(int n, int r){

        //This method follows the formula for combinations n!/(n-r)!

        //Find the numerator for the fraction
        int numerator = factorial(n);

        //Find the denominator of the fractions
        int denominator = factorial(n-r);

        //Return the number that results from dividing the numerator by the denominator
        return numerator/denominator;
    }

    /**
     * The getPermutation method uses the Permutation formula and BigInteger objects to calculate the number of groups
     * that are possible.
     * @param n The size of the set to choose from.
     * @param r The number of choices to be made from the set.
     * @return The total number of groups that can be made from n and k as a BigInteger object.
     */
    public BigInteger getPermutation(BigInteger n, BigInteger r){

        //This method follows the formula for combinations n!/(n-r)!

        //Find the numerator for the fraction
        BigInteger numerator = factorial(n);

        //Find the denominator of the fractions
        BigInteger denominator = factorial(n.subtract(r));

        //Return the number that results from dividing the numerator by the denominator
        return numerator.divide(denominator);
    }

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
    public double multinomialCoefficient(int n, ArrayList<Integer> listOfSets){

        //Initialize the numerator with the factorial of n
        int numerator = factorial(n);

        //Initialize the denominator
        int denominator = 0;

        //Loop through the list of groups
        for(Integer i : listOfSets){

            //Find the factorial of i and then add it to the denominator
            denominator += factorial(i);
        }

        //Return the double value of the numerator divided by the denominator
        return (double)numerator/denominator;
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
        BigInteger denominator = new BigInteger("0");

        //Loop through the list of groups
        for(BigInteger i : listOfSets){

            //Find the factorial of i and then add it to the denominator
            denominator = denominator.add(i);
        }

        //Return the double value of the numerator divided by the denominator
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
}
