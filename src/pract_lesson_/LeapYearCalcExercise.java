package pract_lesson_;

public class LeapYearCalcExercise {
    /*
    To determine whether a year is a leap year, follow these steps:
    1. If the year is evenly divisible by 4, go to step
    2. Otherwise, go to step 5.2. If the year is evenly divisible by 100, go to step
    3. Otherwise, go to step 4.3. If the year is evenly divisible by 400, go to step
    4. Otherwise, go to step 5.4. The year is a leap year (it has 366 days). The method isLeapYear needs to return true.
    5. The year is not a leap year (it has 365 days). The method isLeapYear needs to return false.

    The following years are not leap years:
    1700, 1800, 1900, 2100, 2200, 2300, 2500, 2600
    This is because they are evenly divisible by 100 but not by 400.

    The following years are leap years:
    1600, 2000, 2400
    This is because they are evenly divisible by both 100 and 400.
     */
    boolean isLeapYear(int year){
        if(year >= 1 && year <= 9999){
            if((year % 400 == 0) || (year % 100 != 0 && year % 4 == 0)){
                System.out.println("Is Leap Year");
                return true;
            }
        }
        System.out.println("Not Leap Year");
        return false;
    }
}
