
package charcreator;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author noah
 */
public class Account implements Serializable {
    //needed to serialize
    private static final long serialVersionUID = 1L;
    //values
    private String email;
    private String username;
    private String password;
    //arraylist of type string to hold the name of characters made under this account
    private ArrayList<String> characters = new ArrayList<String>();
    /**
     * account constructor
     * @param email email to be used
     * @param username username for account
     * @param password password for account
     */
    public Account(String email, String username, String password){
        this.email = email;
        this.username = username;
        this.password = password;
    }
    /**
     * displays the account info
     */
    public void displayInfo(){
        System.out.println("Email: " + email + "\nUsername: " + username + "\nPassword: " + password);
    }
    //getters 
    
    public String getEmail(){
        return email;
    }
    
    public String getUsername(){
        return username;
    }
    public String getPassword(){
        return password;
    }
    
    /**
     * adds a character to the arraylist of character names
     * @param c the character to be added
     */
    public void addCharacter(Character c) {
        characters.add(c.getName());
    }
    
    /**
     * gets the character array, used in loading
     * @return characters<>
     */
    public ArrayList<String> getCharacters() {
        return characters;
    }
    
}
