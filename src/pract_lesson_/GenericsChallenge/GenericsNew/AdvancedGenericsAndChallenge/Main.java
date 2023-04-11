package pract_lesson_.GenericsChallenge.GenericsNew.AdvancedGenericsAndChallenge;

import pract_lesson_.GenericsChallenge.GenericsNew.AdvancedGenericsAndChallenge.Model.LPAStudent;
import pract_lesson_.GenericsChallenge.GenericsNew.AdvancedGenericsAndChallenge.Model.LPAStudentComparator;
import pract_lesson_.GenericsChallenge.GenericsNew.AdvancedGenericsAndChallenge.Model.Student;
import pract_lesson_.GenericsChallenge.GenericsNew.AdvancedGenericsAndChallenge.util.QueryList;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int count = 10;
        List<Student> studentList = new ArrayList<>();
        for(int i=0; i<count;i++){
            studentList.add(new Student());
        }
        printListWithWildCardBounded(studentList);

        List<LPAStudent> lpaStudentList = new ArrayList<>();
        for(int i=0; i<count;i++){
            lpaStudentList.add(new LPAStudent());
        }
        printListWithWildCardBounded(lpaStudentList);

        System.out.println("*".repeat(30));

        testList(new ArrayList<String>(List.of("String","Another String","Third String")));
        testList(new ArrayList<Integer>(List.of(1,2,3)));

        System.out.println("*".repeat(30));

        var queryList = new QueryList<>(lpaStudentList);
        var matches = queryList.getMatches("Course","Java");
        printListWithWildCardBounded(matches);

        //call to a static method, overloaded
        var students2022 = QueryList.getMatches(studentList,"yearStarted", "2022");
        printListWithWildCardBounded(students2022);
        //when type can't be inferred, we can specify it, before the static method call in chaining
        //it means that new list created in getMatches method will be of type Student
        //specifying a type argument for a generic method, which is a static method on a class
        var students2021 = QueryList.<Student>getMatches(new ArrayList<>(),"yearStarted", "2021");
        printListWithWildCardBounded(students2021);

        System.out.println("*".repeat(30));

        QueryList<LPAStudent> challengeQueryList = new QueryList<>();
        for(int i=5; i<25; i++){
            challengeQueryList.add(new LPAStudent());
        }
        challengeQueryList.sort(Comparator.naturalOrder());
        printListWithWildCardBounded(challengeQueryList);

        //since getMatches return QueryList we can chain more queries
        var challengeMatches = challengeQueryList
                .getMatches("complete", "50")
                .getMatches("course","java");
        printListWithWildCardBounded(challengeMatches);

        //using comparator interface to sort list
        challengeMatches.sort(new LPAStudentComparator());
        printListWithWildCardBounded(challengeMatches);
    }

    public static <T extends Student> void printListGenericMethodParamBounded(List<T> students){
        for(var student : students){
            System.out.println(student.getYearStarted() + " : " + student);
        }
        System.out.println();
    }

    public static void printListWithWildCardBounded(List<? extends Student> students){
        //best solution in case when no manipulations are require with list, like inserting, or replacing
        //as method don't really know type of the elements in the list, that have been passed to it
        //can't really tell if it's the list of only students, or lpaStudents or both
        // and to use it required to use instanceof check
        for(var student : students){
            System.out.println(student.getYearStarted() + " : " + student);
        }
        System.out.println();
    }

    public static void testList(List<?> list){
        for(var element : list){
            if(element instanceof Integer number){
                System.out.println("Integer " + number.floatValue());
            }
            else if(element instanceof String s){
                System.out.println("String " + s.toUpperCase());
            }
        }
    }
}
