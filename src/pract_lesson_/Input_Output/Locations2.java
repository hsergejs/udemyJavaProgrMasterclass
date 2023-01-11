package pract_lesson_.Input_Output;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Locations2 implements Map<Integer,Location2> {
    //implementing HashMap methods to customize loading content
    private static Map<Integer, Location2> locations = new HashMap<>();

    static{
        //defining location
        locations.put(0, new Location2(0, "You are sitting in front of a computer learning Java"));
        locations.put(1, new Location2(1, "You are standing at the end of a road before a small brick building"));
        locations.put(2, new Location2(2, "You are at the top of a hill"));
        locations.put(3, new Location2(3, "You are inside a building, a well house for a small spring"));
        locations.put(4, new Location2(4, "You are in a valley beside a stream"));
        locations.put(5, new Location2(5, "You are in the forest"));
        //defining exits for each location, break from the loop defined in constructor
        locations.get(1).addExit("W", 2);
        locations.get(1).addExit("E", 3);
        locations.get(1).addExit("S", 4);
        locations.get(1).addExit("N", 5);
        locations.get(2).addExit("N", 5);
        locations.get(3).addExit("W", 1);
        locations.get(4).addExit("N", 1);
        locations.get(4).addExit("W", 2);
        locations.get(5).addExit("S", 1);
        locations.get(5).addExit("W", 2);
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