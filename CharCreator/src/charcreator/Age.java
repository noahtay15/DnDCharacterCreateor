
package charcreator;
import java.util.Random;
/**
 *
 * @author Alex
 */

public class Age implements RandomGenerator {
    //instance variables for the random generator
    private int max;
    private int min;
    Random rand = new Random();
    //interface method
    public int calcRandom(String race, String gender)
    {
        //initializes the randAge variable
        int randAge=0;
        //checks to see if the race is human
        if(race.equalsIgnoreCase("human"))
        {
          //variables used to set the range for the random numbers
           max=30;
           min=15;
           //calculates the random number and keeps it in ange
           randAge=rand.nextInt(max-min)+min;
           //returns the random age
           return randAge; 
        }
        //checks to see if the race is elf
        if(race.equalsIgnoreCase("Elf"))
        {
           max=180;
           min=80;
           randAge=rand.nextInt(max-min) + min;
           return randAge;
           
        }
        //checks to see if the race is dwarf
        if(race.equalsIgnoreCase("Dwarf"))
        {
            max=70;
            min=40;
            randAge = rand.nextInt(max-min) + min;
            return randAge;
            
        }    
        //checks to see if the race is gnome
        if(race.equalsIgnoreCase("Gnome"))
        {
           max=60;
           min=30;
           randAge = rand.nextInt(max-min) + min;
           return randAge;
           
        }
        //checks to see if the race is halfling
        if(race.equalsIgnoreCase("Halfling"))
        {
           max=50;
           min=30;
           randAge = rand.nextInt(max-min) + min;
           return randAge;
           
        }
        //returns the random age
        return randAge;
        
    }
}
    

