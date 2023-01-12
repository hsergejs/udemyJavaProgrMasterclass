package pract_lesson_.Input_Output;

//code taken from adventure game lecture challenge
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Location2 {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location2(int locationID, String description, Map<String,Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        //LinkedHashMap guarantee ordering of the keys
        //checking on exits null allow to avoid code duplication and creating new constructor
        if(exits != null){
            this.exits = new LinkedHashMap<>(exits);
        }
        else{
            this.exits = new LinkedHashMap<>();
        }

        this.exits.put("Q", 0);
    }

    protected void addExit(String direction, int location){ //protected to save immutability
        this.exits.put(direction, location);
    }

    public int getLocationID() {
        return locationID;
    }

    public String getDescription() {
        return description;
    }

    public Map<String, Integer> getExits() {
        //this way return a copy, so original data is not changed
        return new LinkedHashMap<String, Integer>(exits);
    }

    public static void command(Map<Integer, Location2> locations){
        Scanner scanner = new Scanner(System.in);
        Map<String,String> vocabulary = new HashMap<String,String>();
        vocabulary.put("NORTH", "N");
        vocabulary.put("SOUTH", "S");
        vocabulary.put("WEST", "W");
        vocabulary.put("EAST", "E");
        vocabulary.put("QUIT", "Q");
        int locationValue = 1;
        while(true){
            System.out.println(locations.get(locationValue).getDescription());
            if(locationValue == 0){
                return;
            }

            System.out.print("Available exits are ");
            Map<String,Integer> exits = locations.get(locationValue).getExits();
            for(String exit : exits.keySet()){
                System.out.print(exit + ", ");
            }
            System.out.println();
            String direction = scanner.nextLine().toUpperCase();
            //check if input not a single letter
            if(direction.length() > 1){
                String[] array = direction.split(" ");
                for(String command : array){
                    if(vocabulary.containsKey(command)){
                        //returning a value from map by key
                        direction = vocabulary.get(command);
                        break;
                    }
                }
            }

            if(exits.containsKey(direction)){
                locationValue = exits.get(direction);
            }
            else{
                System.out.println("You cannot go in that direction");
            }
        }
    }
}
