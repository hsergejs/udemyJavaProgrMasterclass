package pract_lesson_.BankingChallengeExercise;

import java.util.ArrayList;

public class Bank {
    private String name;
    private ArrayList<Branch> branches;

    public Bank(String name){
        this.name = name;
        this.branches = new ArrayList<>();
    }

    public boolean addBranch(String name){
        if(findBranch(name) != null){
            return false;
        }

        return this.branches.add(new Branch(name));

//        if(findBranch(name) > -1){
//            System.out.println("Branch name already exists");
//            return false;
//        }
//
//       return this.branches.add(Branch.createBranch(name));
    }

    public boolean addCustomer(String branch, String customer, double initAmount){
        Branch existingBranch = findBranch(branch);
        if(existingBranch != null){
            return existingBranch.newCustomer(customer, initAmount);
        }

        return false;

//        int index = findBranch(branch);
//        if(index < 0){
//            System.out.println("Branch doesn't exists");
//            return false;
//        }
//
//        return this.branches.get(index).newCustomer(customer, initAmount);
    }

    public boolean addCustomerTransaction(String branch, String customer, double amount){
        Branch existingBranch = findBranch(branch);
        if(existingBranch != null){
            return existingBranch.addCustomerTransaction(customer,amount);
        }

        return false;

//        int index = findBranch(branch);
//        if(index < 0){
//            System.out.println("Branch doesn't exists");
//            return false;
//        }
//
//        return this.branches.get(index).addCustomerTransaction(customer, amount);
    }

    private Branch findBranch(String branch){
        for(int i=0;i<this.branches.size();i++){
            Branch existingBranch = this.branches.get(i);
            if(existingBranch.getName().equals(branch)){
                return existingBranch;
            }

        }

        return null;
    }

//        private int findBranch(String name){
//        for(int i=0; i<this.branches.size(); i++){
//            if(this.branches.get(i).getName().equals(name)){
//                return i;
//            }
//        }
//
//        return -1;
//    }

    public boolean listCustomers(String branch, boolean showTransactions) {
        Branch existingBranch = findBranch(branch);
        if(existingBranch == null){
            return false;
        }

        ArrayList<Customer> customers = existingBranch.getCustomers();
        System.out.println("Customer details for branch " + existingBranch.getName());
        for(int i=0;i<customers.size();i++){
            System.out.println("Customer: " + customers.get(i).getName() + "[" + (i+1) + "]");
            if(showTransactions){
                System.out.println("Transactions");
                ArrayList<Double> transactions = customers.get(i).getTransactions();
                for(int j=0;j<transactions.size();j++){
                    System.out.println("[" + (j+1) + "]  Amount " + transactions.get(j));
                }
            }
        }

        return true;
    }

//    public boolean listCustomers(String branch, boolean showTransactions){
//        int index = findBranch(branch);
//        if(index < 0){
//            System.out.println("Branch doesn't exists");
//            return false;
//        }
//
//        System.out.println("Customer details for branch " + this.branches.get(index).getName());
//        this.branches.get(index).printCustomersTransactions(showTransactions);
//        return true;
//    }
//

}
