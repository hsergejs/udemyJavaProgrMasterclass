package pract_lesson_;

public class EncapsulationChallengeExercise {
    private int tonerLevel;
    private int pagesPrinted;
    private boolean duplex;

    public EncapsulationChallengeExercise(int tonerLevel, boolean duplex) {
        if(tonerLevel >= 0 && tonerLevel <= 100){
            this.tonerLevel = tonerLevel;
        }
        else
            this.tonerLevel = -1;

        this.pagesPrinted = 0;
        this.duplex = duplex;
    }

    public int addToner(int level){
        if(level > 0 && level < 100){
            if(this.tonerLevel + level > 100){
                return -1;
            }
            else
                return tonerLevel += level;
        }
        else
            return -1;
    }

    public int printPages(int pages){
        if(pages > 0){
            int pagesToPrint = pages;
            if(duplex){
                System.out.println("Printing in duplex mode");
                //as 5 will give remainder
                pagesToPrint = (pagesToPrint / 2) + (pagesToPrint % 2);
            }

            this.pagesPrinted += pagesToPrint;
            return pagesToPrint;
        }
        else
            return -1;
    }


    public int getPagesPrinted() {
        return pagesPrinted;
    }
}
