package pract_lesson_.GenericsChallenge.GenericsNew;

public class GenericsNewMain {
    public static void main(String[] args) {
        var phillyAffiliation = new Affiliation("city", "Philadelphia, PA", "US");

        Team<BaseballPlayer,Affiliation> baseBallTeam1 = new Team<>("Philadelphia Phillies", phillyAffiliation);
        Team<BaseballPlayer,Affiliation> baseBallTeam2 = new Team<>("Houston Astros");
        scoreResults(baseBallTeam1,3,baseBallTeam2,5);

        var harper = new BaseballPlayer("B Harper", "Right fielder");
        var marsh = new BaseballPlayer("A Marsh","Right fielder");
        baseBallTeam1.addTeamMember(harper);
        baseBallTeam1.addTeamMember(marsh);
        baseBallTeam1.listTeamMembers();

        //because there's no upper bound type, it can be any object with upper java.lang.Object
        //Team<FootballPlayer,Affiliation> footBallTeam1 = new Team("Adelaide Crows");
        //and we use String as Affiliation
        Team<FootballPlayer,String> footBallTeam1 = new Team("Adelaide Crows","City of Adelaide, South Australia, in AU");
        var tex = new FootballPlayer("Tex Walker","Center");
        footBallTeam1.addTeamMember(tex);
        footBallTeam1.listTeamMembers();
    }

    public static void scoreResults(Team team1, int scoreTeam1, Team team2, int scoreTeam2){
        String msg = team1.setScore(scoreTeam1,scoreTeam2);
        team2.setScore(scoreTeam2,scoreTeam1);
        System.out.printf("%s %s %s %n", team1,msg,team2);
    }
}
