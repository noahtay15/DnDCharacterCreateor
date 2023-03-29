
package charcreator;

import java.util.Random;
/**
 *
 * @author Alex
 */

public class Height implements RandomGenerator{
    //instance variables to be used for random generator
        private int max;
        private int min;
        Random rand=new Random();
        //interface method
        public int calcRandom(String race, String gender)
        {
            //initialize randHeight variable
            int randHeight=0;
            //if statement to check the gender
            if(gender.equalsIgnoreCase("m"))
               {
                   //if statment to check the race
                   if(race.equalsIgnoreCase("human"))
                    {
                    // sets the range for the random numbers
                    max=90;
                    min=54;
                    //keeps the random numbers in the right range
                    randHeight=rand.nextInt(max-min)+min;
                    //returns randHeight
                    return randHeight;
                    
                    }
                   //same if statment but for elf
                    if(race.equalsIgnoreCase("elf"))
                   {
                       max=67;
                       min=48;
                       randHeight=rand.nextInt(max-min)+min;
                       return randHeight;
                   }
                    //same if statment but for dwarf
                   if(race.equalsIgnoreCase("dwarf"))
                   {
                       max=49;
                       min=48;
                       randHeight=rand.nextInt(max-min)+min;
                       return randHeight;
                   }
                   if(race.equalsIgnoreCase("gnome"))
                   {
                       max=42;
                       min=31;
                       randHeight=rand.nextInt(max-min)+min;
                       return randHeight;
                   }
                   //same if statment but for elf
                   if(race.equalsIgnoreCase("halfling"))
                   {
                       max=52;
                       min=38;
                       randHeight=rand.nextInt(max-min)+min;
                       return randHeight;
                   }
                   //if statment to check the gender
                   if(gender.equalsIgnoreCase("f"))
                   {
                    //same if statment from the male section with values change for female characters
                   if(race.equalsIgnoreCase("human"))
                    {
                    max=80;
                    min=52;
                    randHeight=rand.nextInt(max-min)+min;
                    return randHeight;
                    }
                   //same if statment from the male section with values change for female characters
                   if(race.equalsIgnoreCase("elf"))
                   {
                       max=65;
                       min=46;
                       randHeight=rand.nextInt(max-min)+min;
                       return randHeight;
                   }
                   //same if statment from the male section with values change for female characters
                   if(race.equalsIgnoreCase("dwarf"))
                   {
                       max=56;
                       min=46;
                       randHeight=rand.nextInt(max-min)+min;
                       return randHeight;
                   }
                   //same if statment from the male section with values change for female characters
                   if(race.equalsIgnoreCase("gnome"))
                   {
                       max=40;
                       min=29;
                       randHeight=rand.nextInt(max-min)+min;
                       return randHeight;
                       
                   }
                   //same if statment from the male section with values change for female characters
                   if(race.equalsIgnoreCase("halfling"))
                   {
                       max=49;
                       min=25;
                       randHeight=rand.nextInt(max-min)+min;
                       return randHeight;
                   }
                }
               }  
                    //returns random height
                   return randHeight;
        }
}
    

