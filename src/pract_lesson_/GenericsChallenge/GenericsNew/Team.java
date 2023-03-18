package pract_lesson_.GenericsChallenge.GenericsNew;

import java.util.ArrayList;
import java.util.List;

public class Team<T extends Player, S> {
    private String name;
    private List<T> teamMembers = new ArrayList<>();
    private int totalWins = 0;
    private int totalLosses = 0;
    private int totalTies = 0;

    private S affiliation;

    public Team(String name) {
        this.name = name;
    }

    public Team(String name, S affiliation) {
        this.name = name;
        this.affiliation = affiliation;
    }

    public void addTeamMember(T player){
        if(!teamMembers.contains(player)){
            teamMembers.add(player);
        }
    }

    public void listTeamMembers(){
        System.out.print(name + " Roster: ");
        System.out.println(affiliation == null ? "" : "AFFILIATION: " + affiliation);
        for(T t : teamMembers){
            System.out.println(t.name());
        }
    }

    public int ranking(){
        return (totalLosses * 2) + totalTies + 1;
    }

    public String setScore(int thisTeamScore, int opponentTeamScore){
        String msg = "lost to";
        if(thisTeamScore > opponentTeamScore){
            msg = "beat";
            totalWins++;
        }
        else if(thisTeamScore == opponentTeamScore){
            msg = "tied";
            totalTies++;
        }
        else{
            totalLosses++;
        }

        return msg;
    }

    @Override
    public String toString() {
        return name + " (Ranked: " + ranking() + ")";
    }
}
