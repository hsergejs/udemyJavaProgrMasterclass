package pract_lesson_.GenericsChallenge.GenericsNew.AdvancedGenericsAndChallenge.Model;

import pract_lesson_.GenericsChallenge.GenericsNew.AdvancedGenericsAndChallenge.util.QueryItem;

import java.util.Random;

public class Student implements QueryItem, Comparable<Student> {
    private String name;
    private String course;
    private int yearStarted;

    private static int LAST_ID = 10000;
    private int studentId;

    protected static Random randomNumber = new Random();
    private static String[] fNames = {"Roma", "Galina", "Ekaterina", "Sergej", "Janis", "Alexander"};
    private static String[] courses = {"Java","Web","AI",};

    public Student() {
        int lastNameIndex = randomNumber.nextInt(65,91); //A to Z letters (65-A -- 90-Z as upper bound exclusive)
        name = fNames[randomNumber.nextInt(6)] + " " + (char) lastNameIndex;
        course = courses[randomNumber.nextInt(3)];
        yearStarted = randomNumber.nextInt(2000,2024); // from 2000 to 2023 as upper bound exclusive
        studentId = LAST_ID++;
    }

    @Override
    public String toString() {
        return "%d %-15s %-15s %d".formatted(studentId,name,course,yearStarted);
    }

    public int getYearStarted() {
        return yearStarted;
    }

    @Override
    public boolean matchFieldValues(String fieldName, String value) {
        String fName = fieldName.toUpperCase();
        return switch (fName){
            case "NAME" -> name.equalsIgnoreCase(value);
            case "COURSE" -> course.equalsIgnoreCase(value);
            case "YEARSTARTED" -> yearStarted == Integer.parseInt(value);
            default -> false;
        };
    }

    @Override
    public int compareTo(Student o) {
        return Integer.valueOf(studentId).compareTo(Integer.valueOf(o.studentId));
    }
}
