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
}
