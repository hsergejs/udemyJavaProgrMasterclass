package pract_lesson_;

public class GreatestCommonDivisorExercise {
    public static int getGreatestCommonDivisor(int first, int second){
        int tmp = 0;
        if(first >= 10 && second >= 10){
            for(int i=1; i<=second; i++){
                if(first%i == 0 && second%i == 0){
                    tmp = i;
                    System.out.println("Tmp value: " + tmp);
                }
            }

            return tmp;
        }

        return -1;
    }
}
