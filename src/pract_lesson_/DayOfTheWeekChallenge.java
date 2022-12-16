package pract_lesson_;

public class DayOfTheWeekChallenge {
    public static void printDayOfTheWeek(int day) {
        switch (day) {
            case 0:
                System.out.println("Sunday");
                break;
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3: case 4: case 5: case 6:
                System.out.println("From Wednesday till Saturday");
                break;
             default:
                 System.out.println("Invalid day");
                 break;
        }
    }

    public String printDayOfTheWeekReturnStringMethod(int day){
        switch (day) {
            case 0:
                System.out.println("Sunday");
                return "Sunday";
            case 1:
                System.out.println("Monday");
                return "Monday";
            case 2:
                System.out.println("Tuesday");
                return "Tuesday";
            case 3: case 4: case 5: case 6:
                System.out.println("From Wednesday till Saturday");
                return "From Wednesday till Saturday";

        }

        return "None";
    }

    public void printDayOfWeekEnhancedSwitch(int day){
        //return or print
//        switch(day){
//            case 1 -> System.out.println("Monday");
//        };

        String dayOfWeek = switch(day){
            case 1 -> { yield "Monday"; }
            case 2 -> "Tuesday";
            case 3 -> "Wednesday";
            case 4 -> "Thursday";
            case 5 -> "Friday";
            case 6 -> "Sunday";
            case 7 -> "Saturday";
            default -> { //use code block if required manipulations
                System.out.println("Invalid day");
                yield "Invalid day";
            }
        };

        System.out.println("Day of the week: " + dayOfWeek);
    }
}
