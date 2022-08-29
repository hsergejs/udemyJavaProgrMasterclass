package pract_lesson_.PlayListInnerClassChallengeExercise;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private SongList songs;
    private String name;
    private String artist;

    public Album(String name, String artist) {
        this.songs = new SongList();
        this.name = name;
        this.artist = artist;
    }

    public boolean addToPlayList(String name, LinkedList<Song> playlist){
        Song existingSong = this.songs.findSong(name);
        if(existingSong != null){
            return playlist.add(existingSong);
        }

        System.out.println("Song not in the library");
        return false;
    }

    public boolean addToPlayList(int trackNumber, LinkedList<Song> playlist){
        Song existingSong = this.songs.findSong(trackNumber);
        if(existingSong != null){
            return playlist.add(existingSong);
        }
        System.out.println("Song not in the library");
        return false;
    }

    public boolean addSong(String name, double duration){
        return this.songs.add(new Song(name, duration));
    }

    private class SongList{
        private List<Song> songs;

        private SongList(){
            this.songs = new ArrayList<Song>();
        }

        private boolean add(Song song){
            if(this.songs.contains(song)){
                return false;
            }

            return this.songs.add(song);
        }

        private Song findSong(String name){
            for(Song currentSong : this.songs){
                if(currentSong.getTitle().equals(name)){
                    return currentSong;
                }
            }

            return null;
        }

        private Song findSong(int trackNumber){
            int songIndex = trackNumber - 1;
            if(songIndex >= 0 && songIndex <= this.songs.size()){
                return this.songs.get(songIndex);
            }

            return null;
        }
    }
}
