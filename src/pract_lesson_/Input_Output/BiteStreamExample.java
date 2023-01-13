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
                locationFile.writeInt(location.getExits().size()-1); //??? writing to a file, to have var for loop
                //when will be getting data from the binary file
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
        //reading data from a binary file with try with resources
        try(DataInputStream locationFile = new DataInputStream(new BufferedInputStream(
                new FileInputStream("src/pract_lesson_/Input_Output/locations.dat")))
        ){
            boolean endOfFileFlag = false; //to catch exception when end of file is reached and terminate loop
            try{
                while(!endOfFileFlag){
                    Map<String, Integer> exits = new LinkedHashMap<>();
                    int locationId = locationFile.readInt(); //we need to know in prior sequence of primitives
                    //in this example from writing a file and in prior data structure int,String and int,String,int
                    String description = locationFile.readUTF();
                    int numOfExits = locationFile.readInt();
                    System.out.println("Location id: " + locationId + "-" + description);
                    System.out.println("Number of exits: " + numOfExits);
                    for(int i=0; i<numOfExits; i++){
                        String direction = locationFile.readUTF();
                        int destination = locationFile.readInt();
                        exits.put(direction,destination);
                        System.out.println("\t\t " + direction + "-" + destination);
                    }
                    locations.put(locationId, new Location2(locationId,description,exits));
                }
            }
            catch(EOFException e){
                endOfFileFlag = true;
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
