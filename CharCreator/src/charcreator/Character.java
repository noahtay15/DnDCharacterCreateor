
package charcreator;

import java.io.Serializable;

public class Character implements Serializable {
    //needed to serialize the object for storage
    private static final long serialVersionUID = 1L;
    //character values
    private String charName;
    private String charGender;
    private int charStrength;
    private int charDexterity;
    private int charConstitution;
    private int charIntelligence;
    private int charWisdom;
    private int charCharisma;
    private String charRace;
    private String charAlignment;
    private int charHeight;
    private int charWeight;
    private int charAge;
    
    /**
     * constructor, fills in values
     * 
     * @param name character name
     * @param gender character gender
     * @param race character race
     * @param alignment character alignment
     * @param abilities character abilities
     * @param age character age
     * @param height character height
     * @param weight character weight
     */
    public Character(String name, String gender, String race, String alignment, int[] abilities, int age, int height, int weight) {
        charName = name;
        charGender = gender;
        
        charStrength = abilities[0];
        charDexterity = abilities[1];
        charConstitution = abilities[2];
        charIntelligence = abilities[3];
        charWisdom = abilities[4];
        charCharisma = abilities[5];
        
        charRace = race;
        charAlignment = alignment;
        charAge = age;
        charHeight = height;
        charWeight = weight;
    }
    /**
     * displays all the values
     */
    public void display() {
        System.out.println("Name: " + getName() + "\nGender: " + getGender().toUpperCase() + "\nAbility Scores:" + "\nStrength: " + getStr() + "\nDexterity: " + getDex() + "\nConstitution: " + getCon() + "\nIntelligence: " + getInt() + "\nWisdom: " + getWis() + "\nCharisma: " + getCha() + "\nRace: " + getRace() + "\nAlignment: " + getAlignment() + "\nHeight: " + getHeight()/12 + "\'" + getHeight()%12 + "\"" + "\nWeight: " + getWeight() + " pounds" + "\nAge: " + getAge() + " years old");
    }
    
    //getters for all values
    
    public String getName() {
        return charName;
    }
    
    public String getGender() {
        return charGender;
    }
    
    public String getRace() {
        return charRace;
    }
    
    public String getAlignment() {
        return charAlignment;
    }
    
    public int getHeight() {
        return charHeight;
    }
    
    public int getWeight() {
        return charWeight;
    }
    
    public int getAge() {
        return charAge;
    }
    
    public int getStr() {
        return charStrength;
    }
    
    public int getDex() {
        return charDexterity;
    }
    
    public int getCon() {
        return charConstitution;
    }
    
    public int getInt() {
        return charIntelligence;
    }
    
    public int getWis() {
        return charWisdom;
    }
    
    public int getCha() {
        return charCharisma;
    }
}
