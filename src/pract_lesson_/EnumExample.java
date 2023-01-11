package pract_lesson_;

import java.util.Random;

public enum EnumExample {
    MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY;

    public EnumExample getRandomDay(){
        int randomInt = new Random().nextInt(7); //upper bound not including -> 0 to 6
        var allDays = EnumExample.values(); //return array of all enum values
        return allDays[randomInt];
    }

    public void switchForDayOfTheWeek(EnumExample dayOfTheWeek){
        int weekDayNumber = dayOfTheWeek.ordinal() + 1;
        switch (dayOfTheWeek){
            //even if we use this switch from main, it still will have access to constants as case by name
            //using switch(this) and using from inside an enum
            case WEDNESDAY -> System.out.println("Wednesday is the week day number: " + weekDayNumber);
            case FRIDAY -> System.out.println("Friday is the week day number: " + weekDayNumber);
            default -> System.out.println(dayOfTheWeek.name().charAt(0)
                    + dayOfTheWeek.name().substring(1).toLowerCase()
                    + " is a day and number is: " + weekDayNumber);
        }

    }
}
