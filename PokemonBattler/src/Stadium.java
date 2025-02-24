/**
 * The Stadium class is used to battle two Pokemon.
 * @author Rachel Hussmann
 */
public class Stadium {

    //This is an example of polymorphism

    /**
     * The battle method accepts two Pokemon objects, runs a simulation and prints out who won the battle
     * @param p1 One of the two Pokemon in the stadium
     * @param p2 The other Pokemon in the stadium
     */
    public void battle(Pokemon p1, Pokemon p2){
        //normally check speed first

        //Get each Pokemon's health
        int p1Health = p1.getHp();
        int p2Health = p2.getHp();

        //Check to see which pokemon is faster (faster pokemon goes first)
        if(p1.getSpeed() > p2.getSpeed()){

            //Pokemon1 goes first because it is faster

            //Run the loop until one of the pokemon's health reaches 0
            while(p1Health > 0 && p2Health > 0){

                 //Subtract from p2 health the difference between p1 attack and p2 defense
                 p2Health -= (p1.getAttack() - p2.getDefense());

                 //Subtract from p1 health the difference between p2 attack and p1 defense
                 p1Health -= (p2.getAttack() - p1.getDefense());
            }
        }else{

            //Pokemon2 goes first because it is faster

            //Run the loop until one of pokemon's health reaches 0
            while(p1Health > 0 && p2Health > 0){

                //Subtract from p1 health the difference between p2 attack and p1 defense
                p1Health -= (p2.getAttack() - p1.getDefense());

                //Subtract from p2 health the difference between p1 attack and p2 defense
                p2Health -= (p1.getAttack() - p2.getDefense());
            }
        }

        //If Pokemon1 is still alive
        if(p1Health > 0) {

            //Report who won and who lost
            System.out.println("P1 won the battle!");
            System.out.println("P2 was knocked out!");

          //else if Pokemon2 is still alive
        } else if (p2Health > 0) {

            //Report who won and who lost
            System.out.println("P2 won the battle!");
            System.out.println("P1 was knocked out!");
        }else{

            //Both lost (tie)
            System.out.println("P1 and P2 were knocked out!");
        }

    }

}
