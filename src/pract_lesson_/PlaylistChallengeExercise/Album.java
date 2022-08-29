package pract_lesson_.PlaylistChallengeExercise;

import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    private ArrayList<Song> songs;
    private String name;
    private String artist;

    public Album(String name, String artist) {
        this.songs = new ArrayList<Song>();
        this.name = name;
        this.artist = artist;
    }

    public boolean addSong(String name, double duration){
        if(findSong(name) != null){
            System.out.println("Song already in the list");
            return false;
        }

        return this.songs.add(new Song(name, duration));
    }

    private Song findSong(String name){
//        ListIterator<Song> it = this.songs.listIterator();
//        while(it.hasNext()){
//            Song currentSong = it.next();
//            if(currentSong.getTitle().equals(name)){
//                return currentSong;
//            }
//        }

//        for(int i=0;i<this.songs.size();i++){
//            Song currentSong = this.songs.get(i);
//            if(currentSong.getTitle().equals(name)){
//                return currentSong;
//            }
//        }

        for(Song currentSong : this.songs){
            if(currentSong.getTitle().equals(name)){
                return currentSong;
            }
        }

        return null;
    }

    public boolean addToPlayList(String name, LinkedList<Song> playlist){
        Song existingSong = findSong(name);
        if(existingSong == null){
            System.out.println("Song not in the library");
            return false;
        }

        return playlist.add(existingSong);
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
//        ListIterator<Song> it = this.songs.listIterator();
//        while(it.hasNext()){
//            Song currentSong = it.next();
//            if(it.nextIndex() == trackNumber){
//                return playlist.add(currentSong);
//            }
//        }
//
//        System.out.println("Song not in the list");
//        return false;

        trackNumber = trackNumber - 1;
        if(trackNumber >= 0 && trackNumber <= this.songs.size()){
            playlist.add(this.songs.get(trackNumber));
            return true;
        }

        System.out.println("Song not in the library");
        return false;
    }
}
