package pract_lesson_.GenericsChallenge.GenericsNew.AdvancedGenericsAndChallenge.Model;

import java.util.Comparator;

public class LPAStudentComparator implements Comparator<LPAStudent> {
    @Override
    public int compare(LPAStudent o1, LPAStudent o2) {
        return (int) (o1.getComplete() - o2.getComplete());
    }
}
