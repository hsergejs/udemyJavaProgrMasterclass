package pract_lesson_;

import java.util.Scanner;

public class ScopeChallenge {
    private int x;

    public ScopeChallenge(Scanner x) {
        this.x = x.nextInt();
    }

    public void x (){
        for(int x=1; x<=12; x++){
            System.out.println(this.x * x);
        }
    }
}
