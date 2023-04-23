package charcreator;

import java.io.FileNotFoundException;
import java.io.IOException;

public class CharCreator {

    public static void main(String[] args) throws IOException, InterruptedException, FileNotFoundException, ClassNotFoundException {
        System.out.println("Welcome to the HackStreet Boys' Character Creator!\n");
        System.out.println("Please create an account or log in to begin.\n");
        
        MainMenu.mainMenu();
        
        }
    }
