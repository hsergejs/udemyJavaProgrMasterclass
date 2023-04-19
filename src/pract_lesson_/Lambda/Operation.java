package pract_lesson_.Lambda;

//functional interface --> only one abstract method
//custom functional interface for lambda expression for calculations with two parameters
@FunctionalInterface
public interface Operation <T>{ //generic interface <T> with no bounds
    T operate(T value1, T value2); //return T and accept arguments with the same T (type)
}
