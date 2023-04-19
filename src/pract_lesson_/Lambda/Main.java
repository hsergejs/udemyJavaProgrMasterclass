package pract_lesson_.Lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(List.of("charlie","bravo","alpha","delta"));
        for(String s : list){
            System.out.println(s);
        }

        System.out.println("-".repeat(30));
        //under the hood is the same for loop
        list.forEach((myString) -> System.out.println(myString));

        System.out.println("-".repeat(30));
        //use of multiple statements in lambda expressions
        String prefix = "radio call"; //vars outside the scope must, be either final or effectively final (not changing
        // before or after lambda, same as in local class)
        //to be used in lambda
        list.forEach((var myString) -> {
            char firstChar = myString.charAt(0);
            System.out.println("String in list: " + myString + " " + prefix + " and first char of it: " + firstChar);
        });
        //compiler error
        //prefix = "NATO";

        System.out.println("-".repeat(30));
        int result = calculation((a,b) -> a+b,5,3);
        //use of statement block (e.g. {}) and return
        result = calculation((a,b) -> {int c = a+b;
                return c;} //return can be set only in curly braces and if it's required to return something
                ,5,3);
        var result2 = calculation((var a, var b) -> a/b,10.0,2.5);
        var result3 = calculation((a,b) -> a.toUpperCase() + " " + b.toUpperCase(), "Lora", "Gaffrey");

        //consumer interface
        System.out.println("-".repeat(30));
        var coords = Arrays.asList(
                new double[] {47.123,-95.123},
                new double[] {12.123, -89.123},
                new double[] {35.156,-90.056}
        );
        coords.forEach((s) -> System.out.println(Arrays.toString(s)));
        //biconsumer with declaration to local var
        //declaration not executing lambda expression
        BiConsumer<Double,Double> p1 = (lat,lng) -> System.out.printf("[lat:%.3f, long:%.3f]%n",lat,lng);
        //have to manually call the functional method or pass declared variable
        var firstPoint = coords.get(0);
        processPoint(firstPoint[0], firstPoint[1],p1);
        System.out.println("-----");
        //using declared var with foreach
        coords.forEach(s->processPoint(s[0],s[1],p1));
        //nested lambda exrepssion
        coords.forEach(s->processPoint(s[0],s[1],(lat,lng) -> System.out.printf("[lat:%.3f, long:%.3f]%n",lat,lng)));

        System.out.println("-".repeat(30));
        //predicate lambda expression
        list.removeIf(s -> s.equalsIgnoreCase("bravo"));
        list.forEach(s -> System.out.println(s));
        System.out.println("-----");
        list.addAll(List.of("echo","easy","earnest"));
        list.forEach(s -> System.out.println(s));
        System.out.println("-----");
        list.removeIf(s -> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));

        System.out.println("-".repeat(30));
        //function interface lambda expressions
        list.replaceAll(s -> s.charAt(0) + " - " + s.toUpperCase());
        list.forEach(s -> System.out.println(s));
        System.out.println("-----");
        String[] emptyArrayString = new String[10];
        System.out.println(Arrays.toString(emptyArrayString));
        Arrays.fill(emptyArrayString,"initial value");
        System.out.println(Arrays.toString(emptyArrayString));
        System.out.println("-----");
        //different from fill method, as we can use lambda
        Arrays.setAll(emptyArrayString, i -> (i+1) + ". ");
        System.out.println(Arrays.toString(emptyArrayString));
        System.out.println("-----");
        //we can use switch statement in lambda expressions
        Arrays.setAll(emptyArrayString, i -> (i+1) + ". "
                + switch(i){ //as array index start from 0 and array[i]
                    case 0 -> "one";
                    case 1 -> "two";
                    case 2 -> "three";
                    case 3 -> "four";
                    default -> "";
                }
                );
        System.out.println(Arrays.toString(emptyArrayString));

        System.out.println("-".repeat(30));
        //Supplier interface lambda expressions
        String[] names = {"Ann","David","Kate","Jan","Ian"};
        String[] randomName = randomSelectedValues(15,names, () -> new Random().nextInt(0,names.length));
        System.out.println(Arrays.toString(randomName));
    }

    //custom generic method with custom functional interface as one of the parameter and generic return type (<T> T)
    public static <T> T calculation(Operation<T> function, T value1, T value2 ){
        T result = function.operate(value1, value2);
        System.out.println("Result of calculation: " + result);
        return result;
    }

    //biconsumer interface
    public static <T> void processPoint(T p1, T p2, BiConsumer<T,T> consumer){
        consumer.accept(p1,p2);
    }

    //supplier interface
    public static String[] randomSelectedValues(int index, String[] values, Supplier<Integer> s){
        String[] selectedValues = new String[index];
        for(int i=0; i<index; i++){
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}
