package pract_lesson_.InheritanceChallenge;

public class HourlyEmployee extends Employee{
    private double hourlyPayRate;

    public HourlyEmployee(String name, String birthDate, String hireDate,
                          double hourlyPayRate) {
        super(name, birthDate, hireDate);
        this.hourlyPayRate = hourlyPayRate;
    }

    @Override
    public double collectPay() {
        return hourlyPayRate * 40d;
    }

    public double getDoublePay(){
        return collectPay()*2;
    }
}
