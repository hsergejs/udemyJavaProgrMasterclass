package pract_lesson_.BankingChallengeExercise;

import java.util.ArrayList;

record CustomerNew(String name, ArrayList<Double> transactions) {

    public CustomerNew (String name, double initAmount) {
        this(name.toUpperCase(), new ArrayList<Double>());
        transactions.add(initAmount);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", Initial deposit=" + transactions +
                '}';
    }
}
