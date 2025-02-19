/**
 * The Person class holds information about a person, such as their birthday.
 * @author Rachel Hussmann
 */
public class Person {

    //Initializes the birthday variable to hold the birthday of the person
    private int birthday;

    //Initializes the birthMonth variable to hold the birth month of the person
    private int birthMonth;

    /**
     * Constructor for the Person class
     * @param birthday The birth day of the person
     * @param birthMonth the birth month of the person
     */
    public Person(int birthday, int birthMonth){
        this.birthday = birthday;
        this.birthMonth = birthMonth;
    }

    /**
     * The getBirthday method returns the birthday of the person in integer form.
     * @return The birthday of the person in integer form.
     */
    public int getBirthday() {
        return birthday;
    }

    /**
     * The setBirthday method accepts an integer that replaces the original birthday of the person.
     * @param birthday The new birthday of the person in integer form.
     */
    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    /**
     * The getBirthMonth method returns the birth month of the person in integer form.
     * @return The birth month of the person in integer form.
     */
    public int getBirthMonth() {
        return birthMonth;
    }

    /**
     * The setBirthMonth method accepts an integer that replaces the original birth moth of the person.
     * @param birthMonth The new birth month of the person in integer form.
     */
    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }

}
