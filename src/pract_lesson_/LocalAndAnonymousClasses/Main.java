package pract_lesson_.LocalAndAnonymousClasses;

import pract_lesson_.LocalAndAnonymousClasses.domain.Employee;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        var e1 = new Employee("Jan","Pastars","19/08/2003");
        var e2 = new Employee("Kate","Holostova","11/06/2022");
        var e3 = new Employee("John","Wayne","19/07/2021");
        var e4 = new Employee("Ian","Fitzpatrick","21/012/2022");
        var e5 = new Employee("Warren","Buffet","19/09/2001");

        List<Employee> employeeList = new ArrayList<>(Arrays.asList(e1, e2, e3, e4, e5));
        printSortedList(employeeList,"year");
    }

    public static void printSortedList(List<Employee> list, String field){
        int currentYear = LocalDate.now().getYear();
        class SortEmployee { //Employee is a record and can't be extended
            private Employee currentEmployee;
            private int yearsWorked;
            private String fullName;

            public SortEmployee(Employee currentEmployee) {
                this.currentEmployee = currentEmployee;
                yearsWorked = currentYear - Integer.parseInt(currentEmployee.date().split("/")[2]);
                fullName = String.join(" ", currentEmployee.name(),currentEmployee.surname());
            }

            @Override
            public String toString() {
                return "%s has been %d years in a company.".formatted(fullName,yearsWorked);
            }
        }

        List<SortEmployee> myEmoloyees = new ArrayList<>();
        for(Employee employee : list){
            myEmoloyees.add(new SortEmployee(employee));
        }

        var comparator = new Comparator<SortEmployee>(){
            @Override
            public int compare(SortEmployee o1, SortEmployee o2) {
                return switch(field){
                    case "name" -> o1.fullName.compareTo(o2.fullName);
                  default -> o1.yearsWorked - o2.yearsWorked;
                };
            }
        };

        myEmoloyees.sort(comparator);
        for(SortEmployee employee : myEmoloyees){
            System.out.println(employee);
        }

    }
}
