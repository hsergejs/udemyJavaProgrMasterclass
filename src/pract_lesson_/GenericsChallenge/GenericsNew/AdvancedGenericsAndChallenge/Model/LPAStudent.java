package pract_lesson_.GenericsChallenge.GenericsNew.AdvancedGenericsAndChallenge.Model;

public class LPAStudent extends Student{
    private double complete;

    public LPAStudent() {
        this.complete = randomNumber.nextDouble(0.00,100.001);
    }

    public double getComplete() {
        return complete;
    }

    @Override
    public String toString() {
        return "%s %8.1f%%".formatted(super.toString(),complete);
    }

    @Override
    public boolean matchFieldValues(String fieldName, String value) {
        if(fieldName.equalsIgnoreCase("complete")){
            return complete <= Integer.parseInt(value);
        }

        return super.matchFieldValues(fieldName, value);
    }
}
