package pract_lesson_.Input_Output;

import java.io.*;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public class BiteStreamExample implements Map<Integer,Location2> {
    private static Map<Integer, Location2> locations = new LinkedHashMap<>();

    public static void main(String[] args) throws IOException {
        //writing data in to a .dat file
        //both locations and directions in one file
        try(DataOutputStream locationFile = new DataOutputStream(new BufferedOutputStream(
                new FileOutputStream("src/pract_lesson_/Input_Output/locations.dat"))))
        {
            for(Location2 location : locations.values()){
                locationFile.writeInt(location.getLocationID());
                locationFile.writeUTF(location.getDescription());
                System.out.println("Writing location: " + location.getLocationID() + "-" +
                        location.getDescription());
                System.out.println("Writing " + (location.getExits().size() -1) + " exits.");
                locationFile.writeInt(location.getExits().size()-1); //???
                for(String direction : location.getExits().keySet()){
                    if(!direction.equalsIgnoreCase("Q")){
                        System.out.println("\t\t " + direction + "," + location.getExits().get(direction));
                        locationFile.writeUTF(direction);
                        locationFile.writeInt(location.getExits().get(direction));
                    }
                }
            }
        }
    }

    static{
        try(BufferedReader locationsDir = new BufferedReader(
                new FileReader("src/pract_lesson_/Input_Output/locations.txt"));
            BufferedReader directionsDir = new BufferedReader(
                    new FileReader("src/pract_lesson_/Input_Output/directions.txt"))
        ){
            String locationsLine,directionsLine;
            while((locationsLine = locationsDir.readLine()) != null){
                String [] locationsArray = locationsLine.split(", ");
                int locationInFile = Integer.parseInt(locationsArray[0]);
                String descriptionInFile = locationsArray[1];

                System.out.println("Imported location: " + locationInFile + "-" + descriptionInFile);

                Map<String,Integer> tempExit = new LinkedHashMap<>(); //creating empty hashmap for exits
                locations.put(locationInFile, new Location2(locationInFile,descriptionInFile,tempExit));
            }

            while((directionsLine = directionsDir.readLine()) != null){
                String [] directionsArray = directionsLine.split(", ");
                int locationInFile = Integer.parseInt(directionsArray[0]);
                String directionInFile = directionsArray[1];
                int destinationInFile = Integer.parseInt(directionsArray[2]);

                System.out.println("Imported exit: " + locationInFile + "-" + directionInFile
                        + "-" + destinationInFile);

                Location2 location = locations.get(locationInFile);
                location.addExit(directionInFile,destinationInFile);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }

    }

    @Override
    public int size() {
        return locations.size();
    }

    @Override
    public boolean isEmpty() {
        return locations.isEmpty();
    }

    @Override
    public boolean containsKey(Object key) {
        return locations.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return locations.containsValue(value);
    }

    @Override
    public Location2 get(Object key) {
        return locations.get(key);
    }

    @Override
    public Location2 put(Integer key, Location2 value) {
        return locations.put(key,value);
    }

    @Override
    public Location2 remove(Object key) {
        return locations.remove(key);
    }

    @Override
    public void putAll(Map<? extends Integer, ? extends Location2> m) {
        locations.putAll(m);
    }

    @Override
    public void clear() {
        locations.clear();
    }

    @Override
    public Set<Integer> keySet() {
        return locations.keySet();
    }

    @Override
    public Collection<Location2> values() {
        return locations.values();
    }

    @Override
    public Set<Entry<Integer, Location2>> entrySet() {
        return locations.entrySet();
    }
}
