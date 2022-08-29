package pract_lesson_;

//class name should be VipCustomer
public class ConstructorsPart2Challenge {
    private String name;
    private double creditLimit;
    private String email;

    public ConstructorsPart2Challenge() {
        this("1st constructor name",1.00,"1st@constructor.com");
    }

    public ConstructorsPart2Challenge(String name, double creditLimit) {
        this(name,creditLimit,"2nd@constructor.com");
    }

    public ConstructorsPart2Challenge(String name, double creditLimit, String email) {
        this.name = name;
        this.creditLimit = creditLimit;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmail() {
        return email;
    }
}
