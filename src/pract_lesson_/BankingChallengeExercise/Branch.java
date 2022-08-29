package pract_lesson_.BankingChallengeExercise;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customerList;

    public Branch(String name){
        this.name = name;
        this.customerList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public ArrayList<Customer> getCustomers() {
        return customerList;
    }

    //    public void printCustomersTransactions(boolean showTransactions){
//        for(int i=0; i<this.customerList.size(); i++){
//            System.out.println("Customer: " + this.customerList.get(i).getName() + "[" + (i+1) + "]");
//            if(showTransactions){
//                this.customerList.get(i).printTransactions();
//            }
//        }
//    }

    public boolean newCustomer(String customerName, double initAmount){
        if(findCustomer(customerName) != null){
            return false;
        }

        this.customerList.add(new Customer(customerName, initAmount));
        return true;

//        if(findCustomer(customerName) > -1){
//            System.out.println("Customer exists");
//            return false;
//        }
//
//        if(initAmount < 0){
//            System.out.println("Initial amount can't be negative");
//            return false;
//        }
//
//        this.customerList.add(Customer.newCustomer(customerName, initAmount));
//        return true;
    }

    public boolean addCustomerTransaction(String name, double amount){
        Customer existingCustomer = findCustomer(name);
        if(existingCustomer == null){
            return false;
        }

        existingCustomer.addTransaction(amount);
        return true;

//        int index = findCustomer(name);
//        if(index < 0){
//            System.out.println("Customer doesn't exists");
//            return false;
//        }
//
//        this.customerList.get(index).addTransaction(amount);
//        return true;
    }

    private Customer findCustomer(String name){
        for(int i = 0; i < this.customerList.size(); i++){
            Customer existingCustomer = this.customerList.get(i);
            if(existingCustomer.getName().equals(name)){
                return existingCustomer;
            }
        }

        return null;
    }

//    private int findCustomer(String customerName){
//        for(int i=0;i<this.customerList.size();i++){
//            if(this.customerList.get(i).getName().equals(customerName)){
//                return i;
//            }
//        }
//        return -1;
//    }

//    public static Branch createBranch(String name){
//        return new Branch(name);
//    }
}
