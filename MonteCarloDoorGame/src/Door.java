/**
 * The Door class manages door objects to test the Monty Hall Door Problem.
 * @author Rachel Hussmann
 */
public class Door {

    private String behindDoor;

    /**
     * Default constructor
     * @param behindDoor A String of what is behind the door
     */
    public Door(String behindDoor){
        this.behindDoor = behindDoor;
    }

    /**
     * Getter for the behhindDoor variable
     * @return The string of what is behind the door
     */
    public String getBehindDoor(){
        return behindDoor;
    }

    /**
     * Setter for the behindDoor variable
     * @param behindDoor The new string of what is behind the door
     */
    public void setBehindDoor(String behindDoor){
        this.behindDoor = behindDoor;
    }

}
