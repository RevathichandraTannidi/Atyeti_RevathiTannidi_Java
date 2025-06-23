package com.atyeti.collections.list.arrayList;
//. Implement a Playlist Manager
//Use ArrayList<String> to manage songs.
//Support shuffle, repeat, next, previous, and remove duplicates.


import java.util.*;

public class PlaylistManager {
    private List<String> playlist = new ArrayList<>();
    private int ctIndex = 0;
    private boolean repeat = false;

    public void addSong(String song) {
        playlist.add(song);
    }

    public void removeDuplicates() {
        Set<String> listened = new HashSet<>();
        playlist.removeIf(song -> !listened.add(song));
    }

    public void shuffle() {
        Collections.shuffle(playlist);
        ctIndex = 0;
    }

    public void toggleRepeat() {
        repeat = !repeat;
    }

    public String next() {
        if (playlist.isEmpty()) return "Playlist is empty.";
        ctIndex++;
        if (ctIndex >= playlist.size()) {
            if (repeat) ctIndex = 0;
            else return "End of playlist.";
        }
        return playlist.get(ctIndex);
    }

    public String previous() {
        if (playlist.isEmpty()) return "Playlist is empty.";
        ctIndex = Math.max(0, ctIndex - 1);
        return playlist.get(ctIndex);
    }

    public void printPlaylist() {
        System.out.println("Playlist: " + playlist);
    }

    public static void main(String[] args) {
        PlaylistManager manager = new PlaylistManager();
        manager.addSong("Song A");
        manager.addSong("Song B");
        manager.addSong("Song A");
        manager.addSong("Song C");

        manager.printPlaylist();
        manager.removeDuplicates();
        manager.printPlaylist();

        manager.shuffle();
        manager.printPlaylist();

        System.out.println("Now playing: " + manager.next());
        System.out.println("Next: " + manager.next());
        manager.toggleRepeat();
        System.out.println("Next (with repeat): " + manager.next());
    }
}
