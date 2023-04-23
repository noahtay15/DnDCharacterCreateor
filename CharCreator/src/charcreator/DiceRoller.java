package charcreator;

import java.util.Arrays;
import java.util.Random;

public class DiceRoller {
    private int diceRoll;
    private Random rand = new Random();
    /**
     * acts like the user rolls a 6 sided dice 3 times, then takes the sum of 
     * the three rolls
     * @return returns the sum of the three rolls
     */
    public int roll3d6()
	{
		int sum; 
		int first = rand.nextInt(6) + 1;
		int second = rand.nextInt(6) + 1;
		int third =  rand.nextInt(6) + 1;
                // print statements are for testing
                //System.out.println("First: " + first);
                //System.out.println("Second: " + second);
                //System.out.println("Third: " + third);
                sum = first + second + third;
		return sum;
	}
    /**
     * acts like the user rolls a 6 sided dice 5 times, then takes the sum of 
     * the highest three rolls 
     * @return returns the sum of the highest three rolls
     */
    public int roll5d6()
	{
		int sum;
		int first;
		int second;
		int third;
		int[] randomInts = new int[5];
                for(int i = 0; i < randomInts.length; i++)
                {
                    randomInts[i] = rand.nextInt(6) + 1;
                }
                Arrays.sort(randomInts);
                first = randomInts[randomInts.length - 3];
                second = randomInts[randomInts.length - 2];
                third = randomInts[randomInts.length - 1];
		sum = first + second + third;
                // print statements are for testing
                //System.out.println("Highest: " + first);
                //System.out.println("Second highest: "+ second);
                //System.out.println("Third highest: " + third);
                //System.out.println("sum " + sum);
		return sum;
	}
    /**
     * acts like the user rolls a 6 sided dice 5 times and then a 3 sided dice 
     * once, then adds up the highest three rolls from the 6 sided dice and the 
     * roll from the 3 sided dice
     * @return returns the sum of the highest three rolls from the 6 sided dice
     *         and the single roll from the 3 sided dice
     */
    public int roll5d61d3() 
	{
		int sum;
		int first; 
		int second;
		int third;
		int d3Result;
		int[] randomInts = new int[5];
		for(int i = 0; i < randomInts.length; i++)
		{
                    randomInts[i] = rand.nextInt(6) + 1;
		}
                Arrays.sort(randomInts);
                first = randomInts[randomInts.length - 3];
                second = randomInts[randomInts.length - 2];
                third = randomInts[randomInts.length - 1];
		d3Result = rand.nextInt(4)+1;
		sum = first + second + third + d3Result;
                // print statements are for testing
                //System.out.println("Highest: " + first);
                //System.out.println("Second highest: "+ second);
                //System.out.println("Third highest: " + third);
                //System.out.println("d3 result: " + d3Result);
                //System.out.println("sum " + sum);
		return sum;
	}
}
