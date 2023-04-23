package charcreator;

import java.util.Scanner;

public class CharacterCreator {
    //holder variables used in other methods
    private String race = "not set";
    private String alignment = "not set";
    private String gender = "not set";
    private int[] abilities = new int[6];
    
    Scanner in = new Scanner(System.in);
    /**
     * prompts the user to input character name
     * @return name the name to be used
     */
    public String setCharName() {
        System.out.println("Please enter your character's name: ");
        return in.next();
    }
    /**
     * prompts the user to input character gender
     * @return gender the gender to be used
     * @throws IllegalArgumentException 
     */
    public String setGender() throws IllegalArgumentException {
        boolean run = true;
        while(run)
        {
            try {
                System.out.println("Please enter your character's gender (M/F): ");
                String gender = in.next();
                gender.trim();
                if (gender.equalsIgnoreCase("M") || gender.equalsIgnoreCase("F")) {
                    this.gender = gender.toUpperCase();
                    run = false;
                    return gender;
                }
                else {
                    throw new IllegalArgumentException("Gender must be M or F!");
                }
            }
            catch (IllegalArgumentException x) {
                System.out.println("Gender must be M or F!");
            }
        }
        return gender;
    }
    /**
     * sets ability scores using CharacterAbilityScores
     * @param race race used for adjusting
     * @return abilities the array of abilities
     */
    public int[] setAbilities(String race) {
        CharacterAbilityScores c = new CharacterAbilityScores();
        c.displayCharacterAbilityScoresExplanation();
        c.setUserDiceChoice();
        for (int i = 0; i < 6; i++) {
            c.rollDice();
            c.displayAssignScore();
            c.assignScore();
        }
        c.adjustAbilityScore(race);
        
        abilities[0] = c.getStrength();
        abilities[1] = c.getDexterity();
        abilities[2] = c.getConstitution();
        abilities[3] = c.getIntelligence();
        abilities[4] = c.getWisdom();
        abilities[5] = c.getCharisma();
        
        return abilities;
        
    }
    /**
     * prompts the user to input character race
     * @return race the race to be used
     * @throws IllegalArgumentException 
     */
    public String setRace() throws IllegalArgumentException {
        boolean run = true;
        while(run)
        {
            try {
                System.out.println("Please choose a race: ");
                int count = 0;
                for (String racex : Races.getRaces()) {
                    count++;
                    System.out.println(count + " - " + racex);
                }
                System.out.println("Your choice of race will affect your ability scores.");
                System.out.println("Human – No change \n" + "Elf – Dex+2, Int+2, Con-2 \n" + "Dwarf – Str+2, Con+2, Cha-2 \n" + "Gnome – Dex+2, Con+2, Str-2 \n" + "Halfling – Dex+2, Wis+2, Str-2");
                String i = in.next();
                i.trim();
                /**
                 * Human
                 * Elf
                 * Dwarf
                 * Gnome
                 * Halfling
                 */

                if (i.equalsIgnoreCase("1")){
                    race = "Human";
                    run = false;
                    return race;
                }
                else if (i.equalsIgnoreCase("2")) {
                    race = "Elf";
                    run = false;
                    return race;
                }
                else if (i.equalsIgnoreCase("3")) {
                    race = "Dwarf";
                    run = false;
                    return race;
                }
                else if (i.equalsIgnoreCase("4")) {
                    race = "Gnome";
                    run = false;
                    return race;
                }
                else if (i.equalsIgnoreCase("5")) {
                    race = "Halfling";
                    run = false;
                    return race;
                }
                else {
                    throw new IllegalArgumentException("invalid race entered");
                }

            }
            catch (IllegalArgumentException x) {
                System.out.println("Please choose a valid race!");
            }
        }
        return race;
    } 
    
    /**
     * prompts the user to input character alignment
     * @return the alignment chosen
     */
    public String setAlignment() {
        boolean run = true;
        while(run)
        {
            try {
                String alignment = "not set";
                int count = 0;
                System.out.println("Please choose an alignment: ");
                for (String align : Alignments.getAlignments()) {
                    count++;
                    System.out.println(count + " - " + align);
                }
                String align = in.next(); //issue here
                /**
                 * Lawful Good 
                 * Lawful Evil 
                 * Neutral Good 
                 * Neutral Evil 
                 * Chaotic Good 
                 * Chaotic Evil 
                 */
                    if (align.equalsIgnoreCase("1")) {
                        alignment = "Lawful Good";
                        run = false;
                        return alignment;
                    }
                    else if (align.equalsIgnoreCase("2")) {
                        alignment = "Lawful Evil";
                        run = false;
                        return alignment;
                    }
                    else if (align.equalsIgnoreCase("3")) {
                        alignment = "Neutral Good";
                        run = false;
                        return alignment;
                    }
                    else if (align.equalsIgnoreCase("4")) {
                        alignment = "Neutral Evil";
                        run = false;
                        return alignment;
                    }
                    else if (align.equalsIgnoreCase("5")) {
                        alignment = "Chaotic Good";
                        run = false;
                        return alignment;
                    }
                    else if (align.equalsIgnoreCase("6")) {
                        alignment = "Chaotic Evil";
                        run = false;
                        return alignment;
                    }
                    else {
                        throw new IllegalArgumentException("invalid alignment");
                    }
            }
            catch (IllegalArgumentException x) {
                System.out.println("Please choose a valid alignment!");
            }
        }
        return alignment;
    }

    /**
     * sets character age using the Age class
     * @return the generated age
     */
    public int setCharAge() {
        Age a = new Age();
        return a.calcRandom(race, gender);
    }

    /**
     * sets character height using the Height class
     * @return the generated height
     */
    public int setHeight() {
        Height h = new Height();
        return h.calcRandom(race, gender);
    }

    /**
     * sets character weight using the weight class
     * @return the generated weight
     */
    public int setWeight() {
        Weight w = new Weight();
        return w.calcRandom(race, gender);
    }

}
