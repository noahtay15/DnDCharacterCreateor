package charcreator;

/**
 * class to assign values to the instance variable in class Character
 * needs to run after character race has been established
 * @author Noah Taylor
 */
import java.util.Scanner;
public class CharacterAbilityScores {
    private int strength;
    private boolean isStrengthAssigned = false;
    private int dexterity;
    private boolean isDexterityAssigned = false;
    private int constitution;
    private boolean isConstitutionAssigned = false;
    private int intelligence;
    private boolean isIntelligenceAssigned = false;
    private int wisdom;
    private boolean isWisdomAssigned = false;
    private int charisma;
    private boolean isCharismaAssigned = false;
    private String userDiceChoice;
    private int currentDiceRollScore;
    
    
    /**
     * displays explanation of the abilities and the three methods of dice rolls
     */
    public void displayCharacterAbilityScoresExplanation()
    {
        System.out.println("Your character has six ability scores: Strength, Dexterity,");
        System.out.println("Constitution, Intelligence, Wisdom, and Charisma.");
        System.out.println("You have three different methods of choosing how to ");
        System.out.println("find each ability's stat value.\n");
        System.out.println("The first method is by rolling a D6 three times and ");
        System.out.println("assigning the sum of the three rolls to the ability of ");
        System.out.println("your choice. \n\nThe second method is rolling a D6 five ");
        System.out.println("times and similarly taking the sum of the top three rolls");
        System.out.println("and assigning the value to one of the abilities.\n");
        System.out.println("The third method is rolling a D6 five times and a D3 once,");
        System.out.println("taking the top three rolls of the D6 and adding the");
        System.out.println("roll from the D3 to it, then assigning it to the ability");
        System.out.println("of your choice. \nOnce you assign a stat value to an");
        System.out.println("ability, you can't reassign a value to it. \n");
    }
   
    /**
     * displays what the user should input based on which method of dice roll the 
     * user wants to use, then checks if the input is valid. If it isn't
     * it will show invalid input, then recall the method. After a valid input, it 
     * will assign the value to userDiceChoice instance variable
     */
    public void setUserDiceChoice() throws IllegalArgumentException
    {
       boolean run = true;
       while(run)
       {
        try {
             Scanner in = new Scanner(System.in);
             System.out.println("Which method of dice roll would you like to use?");
             System.out.println("Enter \"1\" for rolling the D6 three times. Enter");
             System.out.println("\"2\" for rolling the D6 five times. Enter \"3\" for");
             System.out.println("rolling the D6 five times and a D3 once.");
             String choice = in.next().trim();
             if(choice.equalsIgnoreCase("1") || choice.equalsIgnoreCase("2") || choice.equalsIgnoreCase("3"))
             {
                  this.userDiceChoice = choice;
                  run = false;
             }
             else
             {
                 throw new IllegalArgumentException("Invalid input");

             }
        }
        catch (IllegalArgumentException x)
        {
             System.out.println("Invalid input, please input \"1\", \"2\", or \"3\"");
             System.out.println("to determine which method you would like to use.");
        }
       }
    }
    
    /**
     * rolls dice based off user input and assigns the returned value to currentDiceRollScore
     * instance variable. AssignScore() will handle which ability score to assign the value 
     * of currentDiceRollScore to 
     */
    public void rollDice()
    {
       DiceRoller dice = new DiceRoller();
       if(userDiceChoice.equalsIgnoreCase("1"))
       {
           currentDiceRollScore = dice.roll3d6();
       }
       else if(userDiceChoice.equalsIgnoreCase("2"))
       {
           currentDiceRollScore = dice.roll5d6();
       }
       else if(userDiceChoice.equalsIgnoreCase("3")) 
       {
           currentDiceRollScore = dice.roll5d61d3();
       } 
    }
    /**
     * displays what the value of currentDiceRollScore and then tells the user
     * what they should input in assignScore()
     */
    public void displayAssignScore()
    {
        System.out.println("Which ability score would you like to assign the stat score ");
        System.out.print(currentDiceRollScore + " to? ");
        System.out.println("For example, if you want it to be assigned to strength, ");
        System.out.println("type \"1\".");
    }
    /**
     * displays which ability has not had a value assigned to it,
     * then asks the user which ability it would like the value of
     * currentDiceRollScore to be assigned to
     */
    public void assignScore()
    {
        if(isStrengthAssigned == false)
        {
            System.out.println("1 - Strength has not been assigned yet.");
        }
        if(isDexterityAssigned == false)
        {
            System.out.println("2 - Dexterity has not been assigned yet.");
        }
        if(isConstitutionAssigned == false)
        {
           System.out.println("3 - Constitution has not been assigned yet."); 
        }
        if(isIntelligenceAssigned == false)
        {
            System.out.println("4 - Intelligence has not been assigned yet.");
        }
        if(isWisdomAssigned == false)
        {
           System.out.println("5 - Wisdom has not been assigned yet.");
        }
        if(isCharismaAssigned == false)
        {
            System.out.println("6 - Charisma has not been assigned yet.");
        }
        Scanner in = new Scanner(System.in);
        String line = null;
        line = in.nextLine();
        line = line.trim();
        if(line.equalsIgnoreCase("1") && isStrengthAssigned == false)
        {
            strength = currentDiceRollScore;
            isStrengthAssigned = true;
        }
        else if(line.equalsIgnoreCase("2") && isDexterityAssigned == false)
        {
            dexterity = currentDiceRollScore;
            isDexterityAssigned = true;
        }
        else if(line.equalsIgnoreCase("3") && isConstitutionAssigned == false)
        {
            constitution = currentDiceRollScore;
            isConstitutionAssigned = true;
        }
        else if(line.equalsIgnoreCase("4") && isIntelligenceAssigned == false)
        {
            intelligence = currentDiceRollScore;
            isIntelligenceAssigned = true;
        }
        else if(line.equalsIgnoreCase("5") && isWisdomAssigned == false)
        {
            wisdom = currentDiceRollScore;
            isWisdomAssigned = true;
        }
        else if(line.equalsIgnoreCase("6") && isCharismaAssigned == false)
        {
            charisma = currentDiceRollScore;
            isCharismaAssigned = true;
        }
        else 
        {
            System.out.println("Invalid input, please input one of the unassigned abilities.");
            assignScore();
        }
    }
    
    /**
     * adjusts the characters ability scores based off of its race instance variable 
     * in that is stored in Character class
     * @param race is the character's established race
     */
    public void adjustAbilityScore(String race)
    {
        if(race.trim().equalsIgnoreCase("Elf"))
        {
           dexterity += 2;
           intelligence += 2;
           constitution -= 2;
        }
        if(race.trim().equalsIgnoreCase("Dwarf"))
        {
           strength += 2;
           constitution += 2;
           charisma += 2;
        }
        if(race.trim().equalsIgnoreCase("Gnome"))
        {
           dexterity += 2;
           constitution += 2;
           strength -= 2;
        }
        if(race.trim().equalsIgnoreCase("Halfling"))
        {
           dexterity += 2;
           wisdom += 2;
           strength -= 2;
        }
        
    }
    
    public int getStrength()
    {
        return strength;
    }
    
    public int getDexterity()
    {
        return dexterity;
    }
    
    public int getConstitution()
    {
        return constitution;
    }
    
    public int getIntelligence()
    {
        return intelligence;
    }
    
    public int getWisdom()
    {
        return wisdom;
    }
    
    public int getCharisma()
    {
        return charisma;
    }
}
