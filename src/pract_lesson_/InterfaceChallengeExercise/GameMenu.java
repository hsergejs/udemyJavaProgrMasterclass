package pract_lesson_.InterfaceChallengeExercise;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GameMenu {
    private static Scanner scanner = new Scanner(System.in);
    private List<String> stringList;
    public GameMenu() {
        this.stringList = new ArrayList<String>();
    }

    private List<String> getValues(){
        boolean quit = true;
        int index = 0;

        while(quit){
            printMenu();
            int option = scanner.nextInt();
            scanner.nextLine();
            switch (option) {
                case 0:
                    quit = false;
                    break;
                case 1:
                    String input = scanner.nextLine();
                    stringList.add(index,input);
                    index++;
            }
        }

        return stringList;
    }

    private void printMenu(){
        System.out.println("Choose an option: ");
        System.out.println("0 - quit");
        System.out.println("1 - enter a string");
    }

    public void saveObject(ISaveable objectToSave){ //Important to note that use parent interface,
        // to use any object that implements this interface
        for(int i=0; i<objectToSave.write().size(); i++){
            System.out.println("Saving " + objectToSave.write().get(i) + " to storage device"); //getting each value at index i
        }
    }

    public void loadObject(ISaveable objectToLoad){
        List<String> values = getValues();
        objectToLoad.read(values);
    }
}
