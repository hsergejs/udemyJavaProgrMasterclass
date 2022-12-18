package pract_lesson_.InheritanceChallenge;

public class SalariedEmployee extends Employee{
    private double annualSalary;
    private boolean isRetired; //by java defaults any boolean var is set to false, without initialization

    public SalariedEmployee(String name, String birthDate, String hireDate,
                            double annualSalary) {
        super(name, birthDate, hireDate);
        this.annualSalary = annualSalary;
    }

    public void retire(){
        //as long as method is not override it's parent's method, then method can be called from child-child
        //from Worker parent
        terminate("01/01/2023");
        isRetired = true;
    }

    @Override
    public double collectPay() {
        double payment = annualSalary/26; //weekly payments
        if(isRetired){
            System.out.println(name + " is retired on " + endDate);
        }
        return (isRetired) ? 0.9*payment : payment; //if retired adjust payment to 90%
    }
}
