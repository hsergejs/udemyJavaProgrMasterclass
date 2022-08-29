package pract_lesson_.BankingChallengeExercise;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initAmount) {
        this.transactions = new ArrayList<>();
        this.name = name;
        addTransaction(initAmount);
    }

    public String getName() {
        return name;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }

    //    public void printTransactions(){
//        System.out.println("Transactions");
//        for(int j=0;j<this.transactions.size();j++){
//            System.out.println("[" + (j+1) + "] Amount " + this.transactions.get(j));
//        }
//    }

    public void addTransaction(double amount){
        this.transactions.add(amount);
    }

//    public boolean addTransaction(double amount){
//        if(amount < 0){
//            System.out.println("Amount can't be negative");
//            return false;
//        }
//
//        return this.transactions.add(amount);
//    }

//    public static Customer newCustomer(String name, double initAmount){
//        return new Customer(name,initAmount);
//    }

}
