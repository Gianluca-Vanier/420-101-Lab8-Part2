import java.util.ArrayList;
import java.util.Collections;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 7.1
 */

public class CommandWords
{
    // A constant array that holds all valid command words.
    private static final String[] validCommands = {
        "go", "quit", "help", "details"
    };
    
    private static final String[] validSubCommands = {
        "east", "west", "south", "north"
    };

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords()
    {

    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if it is, false if it isn't.
     */
    public boolean isCommand(String aString)
    {
        for(int i = 0; i < validCommands.length; i++) {
            if(validCommands[i].equals(aString)) {
                return true;
            }
        }
        // if we get here, the string was not found in the commands
        return false;
    }

    /**
     * Print all valid commands to System.out.
     */
    public String showAll() 
    {
        ArrayList<String> al = new ArrayList();
        for(String command: validCommands) {
            al.add(command);
        }
        Collections.sort(al);
        return al.toString().trim();
    }
    
    public static void commandDetails(){
        for(String command: validCommands){
            System.out.println(command);
            if(command == "go"){
                for(String subCommand: validSubCommands){
                    System.out.println(subCommand);
                }
            }
        }
    }
}
