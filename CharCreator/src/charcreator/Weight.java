
package charcreator;
import java.util.Random;
/**
 * randomly generates weight
 * @author Alex
 */

public class Weight implements RandomGenerator {
    //instance variables to be used for the random numbers
   private int max;
   private int min;
   Random rand=new Random();
   //interface method
   public int calcRandom(String race, String gender) 
   {
           {    
               //initializes randWeight
               int randWeight=0;
               //if statement to check the gender
               if(gender.equalsIgnoreCase("m"))
               {
                   //if statement to check the race
                   if(race.equalsIgnoreCase("human"))
                    {
                    //sets the range for the random numbers
                    max=260;
                    min=90;
                    //keeps the random numbers in the right range
                    randWeight=rand.nextInt(max-min)+min;
                    //returns randWeight
                    return randWeight;
                    }
                   //same if statement but for elf
                   if(race.equalsIgnoreCase("elf"))
                   {
                       max=130;
                       min=70;
                       randWeight=rand.nextInt(max-min)+min;
                       return randWeight;
                   }
                   //same if statement but for dwarf
                   if(race.equalsIgnoreCase("dwarf"))
                   {
                       max=230;
                       min=150;
                       randWeight=rand.nextInt(max-min)+min;
                       return randWeight;
                   }
                   //same if statement but for gnome
                   if(race.equalsIgnoreCase("gnome"))
                   {
                       max=60;
                       min=40;
                       randWeight=rand.nextInt(max-min)+min;
                       return randWeight; 
                   }
                   //same if statement but for halfling
                   if(race.equalsIgnoreCase("halfling"))
                   {
                       max=80;
                       min=55;
                       randWeight=rand.nextInt(max-min)+min;
                       return randWeight;
                   }
                   
               }
               //if statement to check the gender
               if(gender.equalsIgnoreCase("f"))
               {
                   //same if statement from the male section with values change for female characters
                   if(race.equalsIgnoreCase("human"))
                    {
                    max=200;
                    min=75;
                    randWeight=rand.nextInt(max-min)+min;
                    return randWeight;
                    }
                   //same if statement from the male section with values change for female characters
                   if(race.equalsIgnoreCase("elf"))
                   {
                       max=100;
                       min=65;
                       randWeight=rand.nextInt(max-min)+min;
                       return randWeight;
                   }
                   //same if statement from the male section with values change for female characters
                   if(race.equalsIgnoreCase("dwarf"))
                   {
                       max=180;
                       min=125;
                       randWeight=rand.nextInt(max-min)+min;
                       return randWeight;
                   }
                   //same if statement from the male section with values change for female characters
                   if(race.equalsIgnoreCase("gnome"))
                   {
                       max=55;
                       min=35;
                       randWeight=rand.nextInt(max-min)+min;
                       return randWeight;
                       
                   }
                   //same if statement from the male section with values change for female characters
                   if(race.equalsIgnoreCase("halfling"))
                   {
                       max=70;
                       min=45;
                       randWeight=rand.nextInt(max-min)+min;
                       return randWeight;
                   }
               }
               //return the random weight
               return randWeight;
           

    
    }
   }
}




