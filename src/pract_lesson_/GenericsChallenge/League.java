package pract_lesson_.GenericsChallenge;

import java.util.ArrayList;
import java.util.Collections;

public class League <T extends Team>{
    private String name;
    private ArrayList<T> league;

    public League(String name) {
        this.name = name;
        this.league = new ArrayList<>();
    }

    public boolean addTeam(T team) {
        if(this.league.contains(team)){
            System.out.println("Team already in the list");
            return false;
        }

        this.league.add(team);
        return true;
    }

    public void showLeagueTable() {
        //sort arraylist, use compareTo method in the Team class;
        Collections.sort(this.league);
        for(T team : this.league){
            System.out.println(team.getName() + ": " + team.ranking());
        }
    }
}
