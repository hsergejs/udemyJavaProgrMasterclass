package pract_lesson_.BankingChallengeExercise;

import java.util.ArrayList;

public class BankNew {
    private String name;
    private ArrayList<CustomerNew> customers;

    public BankNew(String name) {
        this.name = name;
        this.customers = new ArrayList<>();
    }

    private CustomerNew getCustomer(String name){
        for(CustomerNew customer : customers){
            if(customer.name().equalsIgnoreCase(name)){
                return customer;
            }
        }
        return null;
    }

    public void addCustomer(String name, double initDeposit){
        if(getCustomer(name) == null){
            customers.add(new CustomerNew(name,initDeposit));
            System.out.println("Customer added to the system! \n" + customers);
        }
        else{
            System.out.println("Customer already registered!");
        }
    }

    public void addTransaction(String customerName, double amount){
        CustomerNew customer = getCustomer(customerName);
        if(customer != null){
            customer.transactions().add(amount);
        }
        else{
            System.out.println("Customer not found!");
        }
    }

    public void printCustomerInfo(String name){
        CustomerNew customer = getCustomer(name);
        if(customer != null){
            System.out.println("Customer: " + customer.name()); //not name but customer.name() as it's
            // formatted to UPPER CASE
            System.out.println("Transactions: ");
            for(Double amount : customer.transactions()){
                System.out.printf("%10.2f (%s)%n", amount, amount > 0 ? "credit" : "debit");
            }
        }
        else{
            System.out.println("Customer not found!");
        }
    }

    @Override
    public String toString() {
        return "BankNew{" +
                "name='" + name + '\'' +
                ", customers=" + customers +
                '}';
    }
}
