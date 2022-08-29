package pract_lesson_.AdventureGameLectureChallenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Locations {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Locations(int locationID, String description) {
        this.locationID = locationID;
        this.description = description;
        this.exits = new HashMap<String, Integer>();
        this.exits.put("Q", 0);
    }

    public void addExit(String direction, int location){
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
        return new HashMap<String, Integer>(exits);
    }

    public static void command(Map<Integer,Locations> locations){
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
