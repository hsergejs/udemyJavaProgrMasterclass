package pract_lesson_.LinkedListChallenge;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class LinkedListChallenge {
    private final LinkedList<Town> townList;
    private final Scanner scanner = new Scanner(System.in);
    private boolean forward;
    public LinkedListChallenge() {
        this.townList = new LinkedList<>();
        addTown(new Town("Sydney", 0));
        addTown(new Town("Adelaide",1374));
        addTown(new Town("Alice Springs",2771));
        addTown(new Town("Brisbane",917));
        addTown(new Town("Darwin",3972));
        addTown(new Town("Melbourne",877));
        addTown(new Town("Perth",3923));
        townList.sort(new Comparator<>() {
            @Override
            public int compare(Town o1, Town o2) {
                return Integer.compare(o1.distance(), o2.distance());
            }
        });
    }

    public void startJourney(){
        String menu = """
                Available actions:
                (F)orward
                (B)ackward
                (L)ist places
                (M)enu
                (Q)uit""";

        System.out.println(menu);
        var iterator = townList.listIterator();
        Town town = iterator.next();
        forward = true;
        System.out.println("Currently in " + town.name() + " distance: " + town.distance());
        boolean flag = true;
        do{
            System.out.print("Enter value: ");
            String input = scanner.nextLine().trim().toLowerCase().substring(0,1);
            switch (input){
                case "f" -> goToNextTown(iterator);
                case "b" -> goToPreviousTown(iterator);
                case "l" -> displayTowns();
                case "m" -> System.out.println(menu);
                default -> flag = false;
            }
        }
        while(flag);
    }

    private void addTown(Town town){
//        //can be used but no check on case-sensitiveness
//        if(townList.contains(town)){
//            System.out.println("Already in the list!");
//            return;
//        }

        for(Town townInList : townList){
            if(townInList.name().equalsIgnoreCase(town.name())){
                System.out.println("Already in the list!");
                return;
            }
        }

//        //sort towns by distance
//        int matchIndex = 0;
//        for(var townInList : townList){
//            if(town.distance() < townInList.distance()){
//                townList.add(matchIndex,town);
//                return;
//            }
//            matchIndex++;
//        }

        townList.add(town);
    }

    private void goToNextTown(ListIterator<Town> iterator){
        Town town;
        if(!forward){ //adjusting cursor as movement stated to other direction
            forward = true;
            if(iterator.hasNext()){
                town = iterator.next();
            }
        }

        if(iterator.hasNext()){
            town = iterator.next();
            forward = true;
            System.out.println("Currently in " + town.name() + " distance: " + town.distance());
        }
        else{
            System.out.println("You are at the end of your journey!");
            forward = false;
        }
    }

    private void goToPreviousTown(ListIterator<Town> iterator){
        Town town = null;
        if(forward){ //adjusting cursor as movement stated to other direction
            forward = false;
            if(iterator.hasPrevious()){
                town = iterator.previous();
            }
        }

        if(iterator.hasPrevious()){
            town = iterator.previous();
            System.out.println("Currently in " + town.name() + " distance: " + town.distance());
        }
        else{
            System.out.println("You are at the beginning of your journey!");
            forward = true;
        }
    }

    private void displayTowns(){
        var iterator = townList.listIterator();
        while(iterator.hasNext()){
            Town tmp = iterator.next();
            System.out.println(tmp.name() + " distance: " + tmp.distance());
        }
    }
}
