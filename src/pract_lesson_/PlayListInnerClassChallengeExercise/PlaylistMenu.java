package pract_lesson_.PlayListInnerClassChallengeExercise;



import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class PlaylistMenu {
    public static Scanner in;
    private LinkedList<Song> playlist;
    public PlaylistMenu(LinkedList<Song> playlist){
        in = new Scanner(System.in);
        this.playlist = playlist;
        printMenu();
        optionsMenu();
    }

    public void optionsMenu(){
        ListIterator<Song> it = this.playlist.listIterator(); //to switch pointer required loop, simple next() doesn't work

        if(this.playlist.isEmpty()){
            System.out.println("No songs in playlist");
            return;
        }

        System.out.println("=====================");
        System.out.println("Now playing: " + it.next().toString());

        boolean quit = false;
        boolean forwardIterator = true;

        while(!quit){
            int option = in.nextInt();
            in.nextLine();
            switch(option){
                case 0:
                    printMenu();
                    break;
                case 1:
                    //adding a test to switch properly between forward and backwards, as linked list
                    // hold pointer between previous and next pointer, to avoid endless looping in lists
                    if(!forwardIterator){
                        if(it.hasNext()){
                            it.next();
                        }
                        forwardIterator = false;
                    }

                    if(it.hasNext()){
                        System.out.println("Switched to: " + it.next().toString());
                    }
                    else{
                        System.out.println("Reached END of the playlist");
                        forwardIterator = false; //as we can't go further
                    }

                    break;
                case 2:
                    //adding a test to switch properly between forward and backwards, as linked list
                    // hold pointer between previous and next pointer, to avoid endless looping in lists
                    if(forwardIterator){
                        if(it.hasPrevious()){
                            it.previous();
                        }
                        forwardIterator = true;
                    }

                    if(it.hasPrevious()){
                        System.out.println("Switched to: " + it.previous().toString());
                    }
                    else{
                        System.out.println("Reached START of the playlist");
                        forwardIterator = true; //as we can't go back anymore
                    }

                    break;
                case 3:
                    //check the flag at which direction is a pointer at the moment and set it to different direction
                    if(forwardIterator){
                        if(it.hasPrevious()){
                            System.out.println("Replaying: " + it.previous().toString());
                            forwardIterator = false;
                        }
                        else {
                            System.out.println("Reached START of the playlist");
                        }
                    }
                    else{
                        if(it.hasNext()){
                            System.out.println("Replaying: " + it.next().toString());
                            forwardIterator = true;
                        }
                        else{
                            System.out.println("Reached END of the playlist");
                        }
                    }

                    break;
                case 4:
                    listSongs();
                    break;
                case 5:
                    System.out.println("Remove current song?");
                    System.out.println("1 - Yes, 2 - No");
                    int choice = in.nextInt();
                    in.nextLine();
                    if(choice == 1){
                        if(!this.playlist.isEmpty()){
                            it.remove();
                            if(it.hasNext()){
                                System.out.println("Replaying: " + it.next().toString()); //as pointer stay at the current place
                            }
                            else if(it.hasPrevious()){
                                System.out.println("Replaying: " + it.previous().toString()); //as pointer stay at the current place
                            }
                        }
                        else{
                            System.out.println("No songs in the playlist");
                        }
                    }
                    else
                        printMenu();
                    break;
                case 6:
                    quit = true;
                    in.close();
                    break;
            }
        }
    }

    private void printMenu(){
        System.out.println("Choose an option: ");
        System.out.println("0. Show menu");
        System.out.println("1. Play next song");
        System.out.println("2. Play previous song");
        System.out.println("3. Replay song");
        System.out.println("4. List all songs");
        System.out.println("5. Remove song from playlist");
        System.out.println("6. Quit");

    }

    private void listSongs(){
        System.out.println("=====================");
        ListIterator it = this.playlist.listIterator();
        while(it.hasNext()){
            System.out.println((it.nextIndex()+1) + ". " + it.next());
        }
        System.out.println("=====================");
    }
}
