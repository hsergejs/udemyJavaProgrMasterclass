package pract_lesson_.GenericsChallenge;

import java.util.ArrayList;

public class Team<T extends Player> implements Comparable<Team<T>> {
    //as we don't want to compare same teams (football and football) we set generic Team
    private String name;
    int played = 0;
    int won = 0;
    int lost = 0;
    int tie = 0;

    private ArrayList<T> members = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addPlayer(T player) {
        if(this.members.contains(player)){
            System.out.println(player.getName() + " player in the team already");
            return false;
        }

        this.members.add(player);
        System.out.println(player.getName() + " is assigned to the team " + this.name);
        return true;
    }

    public int numPlayers() {
        return this.members.size();
    }

    public void matchResutl(Team<T> opponent, int ourScore, int theirScore){
        String msg;
        if(ourScore > theirScore){
            this.won++;
            msg = " beat ";
        }
        else if(ourScore < theirScore){
            this.lost++;
            msg = " lost to ";
        }
        else{
            msg = " drew with ";
            this.tie++;
        }

        this.played++;

        if(opponent != null){
            System.out.println(this.getName() + msg + opponent.getName());
            //renewing matchResult for opponents straightaway
            //passing null, not to enter if() again
            matchResutl(null, theirScore, ourScore);
        }
    }

    public int ranking(){
        return (this.won * 2) + this.tie;
    }

    @Override
    public int compareTo(Team<T> team) {
        if(this.ranking() < team.ranking()){
            return -1;
        }
        else if(this.ranking() < team.ranking()){
            return 1;
        }
        else{
            return 0;
        }
    }
}
