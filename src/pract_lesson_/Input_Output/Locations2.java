package pract_lesson_.Input_Output;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Locations2 implements Map<Integer,Location2> {
    //implementing HashMap methods to customize loading content
    private static Map<Integer, Location2> locations = new HashMap<>();

//    public static void main(String[] args) throws IOException {
//        //to create files with locations and directions
//        //old approach before java 7, without try with resources
////        FileWriter fileWriter = null;
////        try{
////            fileWriter = new FileWriter("src/pract_lesson_/Input_Output/locations.txt");
////            for(Location2 location : locations.values()){
////                fileWriter.write(location.getLocationID() + ", " + location.getDescription() + "\n");
////            }
////        }
////        //as we specify in method declaration exception we can remove catch block
//////        catch(IOException e){ //IOException is checked exception it will not allow to compile
//////            e.printStackTrace();
//////        }
////        finally{ //but since we required to close reader at any situation finally stay
////            //same as we specify exception in method declaration, can be completely removed
//////            try{
////                if(fileWriter != null){
////                    fileWriter.close();
////                }
//////            }
//////            catch(IOException e){
//////                e.printStackTrace();
//////            }
////        }
//
//        //from java 7 try with try resources approach
//        //finally block is removed, as it's automatically ensures that file writer is closed!!!!
//        try(
//                FileWriter locationFile = new FileWriter("src/pract_lesson_/Input_Output/locations.txt");
//                FileWriter directionFile = new FileWriter("src/pract_lesson_/Input_Output/directions.txt")
//            ){
//            for(Location2 location : locations.values()){
//                locationFile.write(location.getLocationID() + ", " + location.getDescription() + "\n");
//                for(String direction : location.getExits().keySet()){
//                    directionFile.write(location.getLocationID() + ", " + direction + ", "
//                            + location.getExits().get(direction) + "\n");
//                }
//            }
//        }
//    }

    static{
//        //defining location to create files
//        locations.put(0, new Location2(0, "You are sitting in front of a computer learning Java"));
//        locations.put(1, new Location2(1, "You are standing at the end of a road before a small brick building"));
//        locations.put(2, new Location2(2, "You are at the top of a hill"));
//        locations.put(3, new Location2(3, "You are inside a building, a well house for a small spring"));
//        locations.put(4, new Location2(4, "You are in a valley beside a stream"));
//        locations.put(5, new Location2(5, "You are in the forest"));
//        //defining exits for each location, break from the loop defined in constructor
//        locations.get(1).addExit("W", 2);
//        locations.get(1).addExit("E", 3);
//        locations.get(1).addExit("S", 4);
//        locations.get(1).addExit("N", 5);
//        locations.get(2).addExit("N", 5);
//        locations.get(3).addExit("W", 1);
//        locations.get(4).addExit("N", 1);
//        locations.get(4).addExit("W", 2);
//        locations.get(5).addExit("S", 1);
//        locations.get(5).addExit("W", 2);

        //old approach before java 7, without try with resources
        //reading locations.txt
        Scanner scanner = null;
        try{
            scanner = new Scanner(new FileReader("src/pract_lesson_/Input_Output/locations.txt"));
            scanner.useDelimiter(", ");
            while(scanner.hasNextLine()){
                int locationInFile = scanner.nextInt();
                scanner.skip(scanner.delimiter()); //skip delimiter which is ,_ not adding it to the description
                String description = scanner.nextLine();
                System.out.println("Imported location: " + locationInFile + "-" + description);
                Map<String,Integer> tempExit = new HashMap<>(); //creating empty hashmap for exits
                locations.put(locationInFile, new Location2(locationInFile,description,tempExit));
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
        finally{
            if(scanner != null){
                scanner.close(); //also close FileReader, so not adding additional code
            }
        }

        //reading directions.txt
        //using bufferedreader, as it's more efficient, it will take approx 1 reading of the file, to get all data
        //from a file, placing all characters in to buffer and then manipulate it
        try{
            scanner = new Scanner(new BufferedReader(
                    new FileReader("src/pract_lesson_/Input_Output/directions.txt")));
            scanner.useDelimiter(", ");
            while(scanner.hasNextLine()){
//                int locationInFile = scanner.nextInt();
//                scanner.skip(scanner.delimiter()); //skip first delimiter, which is ,_
//                String directionInFile = scanner.next();
//                scanner.skip(scanner.delimiter()); //skip second delimiter, which is ,_
//                int destinationInFile = Integer.parseInt(scanner.nextLine());
                //more efficient way to read whole line in one go
                String input = scanner.nextLine();
                String [] data = input.split(", ");
                int locationInFile = Integer.parseInt(data[0]);
                String directionInFile = data[1];
                int destinationInFile = Integer.parseInt(data[2]);

                System.out.println("Imported exit: " + locationInFile + "-" + directionInFile
                        + "-" + destinationInFile);
                Location2 location = locations.get(locationInFile);
                location.addExit(directionInFile,destinationInFile);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        finally {
            if(scanner != null){
                scanner.close(); //also close FileReader as it's implements Closeable interface
            }
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