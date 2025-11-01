/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  For each existing exit, the room 
 * stores a reference to the neighboring room.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 7.1
 */
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 * A class representing a room in an adventure game.
 * Each room has a description, exits, and can contain multiple items.
 */
public class Room
{
    private String description;
    private HashMap<String, Room> exits;
    private ArrayList<Item> items;

    /**
     * Create a room described by "description". Initially, it has no exits and no items.
     * @param description The room's description.
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<>();
        items = new ArrayList<>();
    }

    /**
     * Define an exit from this room.
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * @return The short description of the room (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return the room that is reached if we go from this room in direction "direction".
     * If there is no room in that direction, return null.
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /**
     * Return a string describing the room's exits, for example "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        StringBuilder returnString = new StringBuilder("Exits:");
        Set<String> keys = exits.keySet();
        for (String exit : keys) {
            returnString.append(" ").append(exit);
        }
        return returnString.toString();
    }

    /**
     * Add an item to this room.
     * @param item The item to be added.
     */
    public void addItem(Item item)
    {
        items.add(item);
    }

    /**
     * @return A list of items in this room.
     */
    public ArrayList<Item> getItems()
    {
        return items;
    }

    /**
     * @return A string describing all the items in this room.
     */
    private String getItemString()
    {
        if (items.isEmpty()) {
            return "There are no items here.";
        }

        StringBuilder sb = new StringBuilder("You see the following items here:");
        for (Item item : items) {
            sb.append("\n - ").append(item.getLongDescription());
        }
        return sb.toString();
    }

    /**
     * @return A long description of this room, including its exits and items.
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString() + "\n" + getItemString();
    }
}

