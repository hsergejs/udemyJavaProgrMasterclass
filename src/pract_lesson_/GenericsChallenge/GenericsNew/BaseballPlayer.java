package pract_lesson_.GenericsChallenge.GenericsNew;

public record BaseballPlayer(String name, String position) implements Player {
    //record can't extend class, but can implement interface
}
