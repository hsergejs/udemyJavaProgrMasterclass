package pract_lesson_.InterfaceChallengeExercise.NewInterfaceChallenge;

import java.util.ArrayList;
import java.util.List;

public class MainNewInterfaceChallenge {
    public static void main(String[] args) {
        List<Mappable> mappables = new ArrayList<>();
        mappables.add(new Building("Riga Town Hall", UsageType.GOVERNMENT));
        mappables.add(new Building("Riga National Opera", UsageType.ENTERTAINMENT));
        mappables.add(new Building("Inbox Ice Hall", UsageType.SPORT));

        mappables.add(new UtilityLine("Moscow House", UtilityType.FIBER_OPTIC));
        mappables.add(new UtilityLine("89 vsk", UtilityType.WATER));

        for(var mappableFromList : mappables){
            Mappable.mapIp(mappableFromList);
        }
    }
}
