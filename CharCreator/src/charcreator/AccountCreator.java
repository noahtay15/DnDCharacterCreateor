
package charcreator;
import java.util.Scanner;

public class AccountCreator {
    //instance variables
    private String email;
    private String username;
    private String password;

    Scanner in = new Scanner(System.in);
/**
 * prompts for and sets email
 * @return the user email
 */
    public String setEmail(){
        boolean run = true;
        while(run)
        {
            try {
            System.out.println("Enter Email Address: ");
            String eml = in.nextLine();
            if(eml.trim().contains("@") && eml.trim().contains(".com")) {
                this.email = eml;
                run = false;
            }
            else
                throw new IllegalArgumentException("Invalid Input");
            }
            catch(IllegalArgumentException ex){
                System.out.println("Invalid Email Address, try again");
            }
        }
        return email;
        
    }
    /**
     * prompts for and sets username
     * @return the username
     */
    public String setUsername(){
        boolean run = true;
        while(run)
        {
            try{
            System.out.println("Create a Username with at least 6 characters: ");
            String usernm = in.nextLine();

            if(usernm.trim().length() > 5){
                this.username = usernm;
                run = false;
            }
            else
                throw new IllegalArgumentException("Invalid Input");
            }
            catch(IllegalArgumentException ex){
                System.out.println("Username did not meet the requirements, try again");
            }
        }
        return username;
    }
    /**
     * prompts for and sets password
     * @return the user password
     */
    public String setPassword()
    {
        boolean run = true;
        while(run)
        {
            try{
            System.out.println("Create a Password with at least 8 characters: ");
            String pw = in.nextLine();

            if(pw.trim().length() > 7) { 
                    this.password = pw;
                    run = false;
            }
            else
                    throw new IllegalArgumentException("Invalid Input");
            }
            catch(IllegalArgumentException ex){
                System.out.println("Password did not meet the requirements, Try Again");
            }
        }
        return password;
    }
}
