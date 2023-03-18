package pract_lesson_.GenericsChallenge.GenericsNew.Challenge;

import java.util.ArrayList;
import java.util.List;

public class Layer<T extends Mappable>{
    private List<T> listOfLocations;

    public Layer(T[] locations) {
        this.listOfLocations = new ArrayList<T>(List.of(locations));
    }

    public void addLocations(T... locations){
        listOfLocations.addAll(List.of(locations));
    }

    public void renderLayer(){
        for(T location : listOfLocations){
            location.render();
        }
    }
}
