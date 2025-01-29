package DesignPatterns.Behavorial.Iterator;

public class Driver {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.addSong("Song 1");
        playlist.addSong("Song 2");
        playlist.addSong("Song 3");

        Iterator<String> iterator = playlist.createIterator();

        while (iterator.hasNext()) {
            System.out.println("Playing: " + iterator.next());
        }
    }
}
