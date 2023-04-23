package charcreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class Storage {
    //current character and account
    private static Character currentChar;   
    private static Account currentAcct;
    
    /**
     * loads character from a file
     * @param file the character file
     * @return the loaded character
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static Character loadChar(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        Character x = null;
            try {
                FileInputStream fis = new FileInputStream(file);
                ObjectInputStream ois = new ObjectInputStream(fis);

                x = (Character) ois.readObject();
                currentChar = x;

            }
            catch (FileNotFoundException ex) {
                throw new FileNotFoundException("Character not found! Please try again or re-enter the name correctly");
            }
         return x;
    }
    
    /**
     * saves a given character to a given file
     * @param c the character to be saved
     * @param file the file name
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static void saveChar(Character c, File file) throws IOException, ClassNotFoundException {
        try {
            FileOutputStream fos =  new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(c);
            oos.flush();
        }
        catch (IOException x) {
            throw new IOException("IOException");
        }
    }
    
    /**
     * sets the currentChar static variable to the given character
     * @param c the character to be set
     */
    public static void setCurrentCharacter(Character c) {
        currentChar = c;
    }
    
    /**
     * gets the current character
     * @return currentChar the current character
     */
    public static Character getCurrentCharacter() {
        return currentChar;
    }
    /**
     * saves the given account to the given file
     * @param a the account to be saved
     * @param file the file to save account to
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static void saveAcct(Account a, File file) throws IOException, ClassNotFoundException {
        try {
            FileOutputStream fos =  new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(a);
            oos.flush();
        }
        catch (IOException x) {
            throw new IOException("IOException");
        }
    }
    
    /**
     * loads an account object from a given file
     * @param file the file to load from
     * @return the loaded account object
     * @throws FileNotFoundException
     * @throws IOException
     * @throws ClassNotFoundException 
     */
    public static Account loadAcct(File file) throws FileNotFoundException, IOException, ClassNotFoundException {
        Account y = null;
        try {
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);

            y = (Account) ois.readObject();
            //currentAcct = y;

        }
        catch (FileNotFoundException ex) {
            throw new FileNotFoundException("Account not found");
        }
        return y;
        
    }
    
    /**
     * sets the current account to given account a
     * @param a the account to be set
     */
    public static void setCurrentAccount(Account a) {
        currentAcct = a;
    }
    
    /**
     * gets the current account
     * @return currentAcct
     */
    public static Account getCurrentAccount() {
        return currentAcct;
    }
    
}
