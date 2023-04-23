package charcreator;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class MainMenu {
    /**
     * main menu method, handles main menu choices
     * @throws IOException
     * @throws FileNotFoundException
     * @throws InterruptedException
     * @throws ClassNotFoundException 
     */
    public static void mainMenu() throws IOException, FileNotFoundException, InterruptedException, ClassNotFoundException {
        Scanner in = new Scanner(System.in);
        CharacterCreator x = new CharacterCreator();
        AccountCreator z = new AccountCreator();
        System.out.println("Main Menu");
        displayMenu();
        String i = "";
        while (!i.trim().equals("7")) {
            i = in.next();
                //create account
                if (i.trim().equals("1")) {
                    System.out.println("Time to create your account!");
                    
                    String email = z.setEmail();
                    String username = z.setUsername();
                    File ac = new File(username + ".acct");
                    try { //tries to load, if no account found an error is thrown
                        Storage.loadAcct(ac);
                        System.out.println("Account already exists! Input 2 to log in.");
                    }
                    catch (FileNotFoundException ex) { //error caught here, continues to create account
                        String pw = z.setPassword();

                        Account account = new Account(email, username, pw);
                        Storage.setCurrentAccount(account);

                        File write = new File(account.getUsername() + ".acct");
                        try {
                            Storage.saveAcct(account, write);
                        }
                        catch (IOException | ClassNotFoundException ex2) {
                            System.out.println("Save failed, please try again");
                        }

                        System.out.println("Account successfully created!");
                        displayMenu();
                    }
                }
                //load account
                else if (i.trim().equals("2")) {
                    System.out.println("Please enter your username: ");
                    String username = in.next().trim();
                    System.out.println("Please enter your password: ");
                    String password = in.next().trim();
                    
                    File read = new File(username + ".acct");
                    try {
                        Account load = Storage.loadAcct(read);
                        if (password.equals(load.getPassword())) { //checks if password is correct
                            Storage.setCurrentAccount(load);
                            System.out.println("Logged into " + username + "!");
                            displayMenu();
                        }
                        else {
                            System.out.println("Incorrect username or password, please try again (input 2 to start)");
                        }
                    }
                    catch (FileNotFoundException | NullPointerException ex) {
                        System.out.println("Account with username \"" + username + "\" not found. Try again by inputting 2.");
                    }
                    catch (IOException ex) {
                        System.out.println("IOException, please try again");
                    } 
                    catch (ClassNotFoundException ex) {
                        System.out.println("ClassNotFound, please try again");
                    }
                }
                //create character    
                else if (i.trim().equals("3")) {
                    if (Storage.getCurrentAccount() != null) {
                        System.out.println("Time to create your character!");
                        
                        String name = x.setCharName();
                        String gender = x.setGender();
                        String race = x.setRace();
                        String alignment = x.setAlignment();
                        int[] abilities = x.setAbilities(race);
                        System.out.println("Randomly generating age...");
                        TimeUnit.SECONDS.sleep(1);
                        int age = x.setCharAge();
                        
                        System.out.println("Randomly generating height...");
                        TimeUnit.SECONDS.sleep(1);                        
                        int height = x.setHeight();
                        
                        System.out.println("Randomly generating weight...");
                        TimeUnit.SECONDS.sleep(1);                        
                        int weight = x.setWeight();


                        Character character = new Character(name, gender, race, alignment, abilities, age, height, weight);
                        Storage.setCurrentCharacter(character);
                        System.out.println("Character successfully created! Input 4 to view stats.");
                        displayMenu();
                    }
                    else
                        System.out.println("No account logged in! Please input 1 to create an account or 2 to log in.");
                }
                //display character    
                else if (i.trim().equals("4")) {
                    if (Storage.getCurrentCharacter() != null) {
                        Character disp = Storage.getCurrentCharacter();
                        System.out.println(disp.getName() + "'s stats are:");
                        disp.display();
                        System.out.println();
                        displayMenu();
                    }
                    else {
                        System.out.println("No character loaded, please load a character (Input 6 to start).");
                    }
                }

                //save character
                else if (i.trim().equals("5")) {
                    if (Storage.getCurrentCharacter() != null) {
                        Character savec = Storage.getCurrentCharacter();
                        Account savea = Storage.getCurrentAccount();
                        File writec = new File(savec.getName().toLowerCase() + ".char");
                        File writea = new File(savea.getUsername() + ".acct");
                        
                        if (savea.getCharacters().contains(savec.getName())) { //checks to see if char already exists
                            System.out.println("Character already exists! Would you like to overwrite it? (Y/N)");
                            String answer = in.next();
                            if (answer.equalsIgnoreCase("Y")) {
                                try {
                                    Storage.saveChar(savec, writec);
                                    System.out.println("Save successful! Character saved to " + writec.getCanonicalPath() + "\n");
                                    Storage.saveAcct(savea, writea);
                                    displayMenu();
                                }
                                catch (IOException | ClassNotFoundException ex) {
                                    System.out.println("Save failed, please try again");
                                }
                            }
                            else {
                                System.out.println("Returning to main menu...");
                                displayMenu();
                            }
                        }
                        else {
                            try {
                                Storage.saveChar(savec, writec);
                                System.out.println("Save successful! Character saved to " + writec.getCanonicalPath() + "\n");
                                savea.addCharacter(savec);
                                Storage.saveAcct(savea, writea);
                                displayMenu();
                            }
                            catch (IOException | ClassNotFoundException ex) {
                                System.out.println("Save failed, please try again");
                            }
                        }
                    }
                    else
                        System.out.println("No character to save. Please create a character (Input 3 to start).");
                }

                //load character    
                else if (i.trim().equals("6")) {
                    if (Storage.getCurrentAccount() != null) {
                        System.out.println("Please enter the name (case-sensitive) of the character you would like to load: ");
                        Account current = Storage.getCurrentAccount();
                        if (!current.getCharacters().isEmpty()) {
                            for (String chr : current.getCharacters())
                                System.out.println(chr);
                            in.nextLine();
                            String name = in.nextLine().trim();
                            File read = new File(name + ".char");
                            if (current.getCharacters().contains(name)) {
                                try {
                                    Storage.setCurrentCharacter(Storage.loadChar(read));
                                    System.out.println("Character " + name + " found! Loading from " + read.getCanonicalPath() + "\n");
                                    displayMenu();
                                }
                                catch (FileNotFoundException ex3) {
                                    System.out.println("Character not found. Try again by inputting 6 or input 3 to create a character.");
                                } 
                                catch (IOException ex) {
                                    System.out.println("IOException, please try again");
                                } 
                                catch (ClassNotFoundException ex) {
                                    System.out.println("ClassNotFound, please try again");
                                }
                            }
                           else   
                                System.out.println("Character not found in current account. Please try again by inputting 6!");
                        }
                        else 
                            System.out.println("No characters available. Create some by inputting 3!");
                    }
                    else
                        System.out.println("No account logged in! Please input 1 to create an account or 2 to log in.");
                }
                else
                    if (!i.trim().equals("7"))
                        System.out.println("Invalid choice, please select a valid option (1-7).");
        }
        //reminds user to save
        if (Storage.getCurrentCharacter() != null) {
        System.out.println("Would you like to save the current character before exiting? (Y/N)");
        String answer = in.next();
        while (answer.equalsIgnoreCase("Y")) {
                Character save = Storage.getCurrentCharacter();
                File write = new File(save.getName() + ".char");
                try {
                    Storage.saveChar(save, write);
                    System.out.println("Save successful! Character saved to " + write.getCanonicalPath());
                    if (!Storage.getCurrentAccount().getCharacters().contains(Storage.getCurrentCharacter().getName()))
                        Storage.getCurrentAccount().addCharacter(save);
                    answer = "N";
                }
                catch (IOException | ClassNotFoundException ex) {
                    System.out.println("Save failed, try again?");
                    answer = in.next();
                }
            }
        }
        System.out.println("Exiting program. Thanks for playing!");
    }
    
    /**
     * displays main menu choices
     */
    private static void displayMenu() {
        System.out.println("1. Create User Account\n2. Load User Account\n3. Create Character\n4. Display Character\n5. Save Character\n6. Load Character\n7. Exit");
    }
}
