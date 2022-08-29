package pract_lesson_.InterfaceChallengeExercise;

import java.util.List;

public interface ISaveable {
    List<String> write();
    void read(List<String> list);
}
