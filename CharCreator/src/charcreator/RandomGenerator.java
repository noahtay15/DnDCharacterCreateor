package charcreator;

/**
 * interface used for generating height, weight, and age
 * @author Alex
 */
public interface RandomGenerator {
    //method with race and gender parameter to be used for calculating random numbers
    public int calcRandom(String race, String gender);  
}
