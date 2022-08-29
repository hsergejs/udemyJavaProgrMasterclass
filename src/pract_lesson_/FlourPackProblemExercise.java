package pract_lesson_;

public class FlourPackProblemExercise {
    public static boolean canPack(int bigCount, int smallCount, int goal){
        //bigCount = 5kg
        //smallCount = 1kg
        //the remainder of goal needs to be filled with sufficient amount of small bags (smallCount)
        if(bigCount>=0 && smallCount>=0 && goal >= 0){
            int sum = (bigCount*5)+smallCount;
            if(sum >= goal && goal % 5 <= smallCount){
                return true;
            }
        }

        return false;
    }
}
