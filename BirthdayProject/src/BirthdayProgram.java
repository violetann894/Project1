import java.util.ArrayList;
import java.util.Random;

/**
 * The BirthdayProgram class is responsible for calculating the probability that 2 people share the same birthday in a
 * class. It does this through running a configurable amount of trials.
 * @author Rachel Hussmann
 */
public class BirthdayProgram {

    //Initializes the variable that holds the total number of birthday matches
    private int countOfMatches;

    /**
     * The generatePeople method creates an ArrayList of people filled with Person objects, which all have randomized
     * birthdays and birth months.
     * @param numberOfPeople The number of people that need to be created.
     * @return An ArrayList of the newly generated people.
     */
    private ArrayList<Person> generatePeople(int numberOfPeople){

        //Initializes the ArrayList that will hold all the generated people
        ArrayList<Person> people = new ArrayList<>();

        //Initializes a random object to pick random integers for birthdays and birth months
        Random random = new Random();

        //loop until all people have been created and added to the list
        for(int i = 0; i < numberOfPeople; i++){

            //Picks a random number between 1 and 12 for birth month
            int birthMonth = random.nextInt(1, 13);

            //Initializes the birthday integer
            int birthday = 0;

            //Checks the month to change the bound of the randomly generated birthday
            if(birthMonth == 4 || birthMonth == 6 || birthMonth == 9 || birthMonth == 11){

                //If the birth month is april, june, september or november

                //Pick a random integer between 1 and 30
                birthday = random.nextInt(1, 31);
            }else if (birthMonth == 2){

                // if the birth month is february

                //Pick a random integer between 1 and 28
                birthday = random.nextInt(1, 29);
            }else{

                //Otherwise the month is a month that has 31 days

                //Pick a random integer between 1 and 31
                birthday = random.nextInt(1, 32);
            }

            //Add the newly created person to the people ArrayList
            people.add(new Person(birthday, birthMonth));

        }

        //Return the list of people
        return people;
    }


    /**
     * The runTrials method runs the configurable number of trials and figures out the percentage of birthday matches in
     * a class.
     * @param trials The number of trials to be run.
     * @param people The number of people in the class.
     * @return The decimal percentage of birthday matches.
     */
    public double runTrials(int trials, int people){

        //Run through the number of trials
        for(int i = 0; i < trials; i++){

            //Generate a new list of people for each trial
            ArrayList<Person> listOfPeople = generatePeople(people);

            //Initialize a boolean variable to check if we broke out of the inner loop
            boolean broke = false;

            /* For loops to iterate through the list two people at a time to compare them. The first for the loop is the
            person that is compared to the whole list. The second for loop is used to compare each element in the list
            to the person in the first loop.*/
            for(int x = 0; x < listOfPeople.size(); x++){
                for (Person person2 : listOfPeople) {

                    //Initialize a variable to hold the person from the first loop
                    Person person1 = listOfPeople.get(x);

                    //Run the checkForBirthday method to check if person 1 and person 2 share a birthday
                    if (checkForBirthday(person1, person2)) {

                        //If they do

                        //Increment the count of matches by one
                        countOfMatches++;

                        //Set the broke variable to true
                        broke = true;

                        //break out of the second loop
                        break;
                    }

                }

                //Check if the broke variable is true
                if(broke){

                    //If it is

                    //Break out of the first loop
                    break;
                }
            }

        }

        //Calculate the percentage of matches birthdays and return it
        return calculatePercentage(countOfMatches, trials);
    }

    /**
     * The checkForBirthday method checks to see if two Person objects share the same birthday.
     * @param person1 A Person object to compare against person2.
     * @param person2 A Person object to compare against person1.
     * @return True - if the two Person objects share the same birthday (Month and Day) False - if the two objects do
     * not share a birthday
     */
    public boolean checkForBirthday(Person person1, Person person2){

        //Make sure they are not the same Person object
        if(person1 != person2){

            //Check to see if they have the same birthday and birth month
            if(person1.getBirthday() == person2.getBirthday() &&
                    person1.getBirthMonth() == person2.getBirthMonth()){

                //If they have the same birthday and birth month, return true
                return true;
            }
        }

        //Otherwise return false;
        return false;
    }


    /**
     * The calculatePercentage method accepts the number of matches birthdays, the number of trials and the size of
     * the class to figure out the percentage of times two people had the same birthday in the same class.
     * @param matchedBirthdays The number of times two people had the same birthday in a class.
     * @param numberOfTrials The number of trials run.
     * @return The decimal percentage of the number of times two people had the same birthday.
     */
    private double calculatePercentage(int matchedBirthdays, int numberOfTrials){

        return (double)matchedBirthdays / (double)(numberOfTrials);

    }
}
