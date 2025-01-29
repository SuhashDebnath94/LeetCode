package DesignPatterns.Behavorial.Iterator;

import java.util.ArrayList;
import java.util.List;

class Playlist implements IterableCollection<String> {
    private List<String> songs = new ArrayList<>();

    public void addSong(String song) {
        songs.add(song);
    }

    @Override
    public Iterator<String> createIterator() {
        return new SongIterator();
    }

    // Concrete Iterator
    private class SongIterator implements Iterator<String> {
        private int currentIndex = 0;

        @Override
        public boolean hasNext() {
            return currentIndex < songs.size();
        }

        @Override
        public String next() {
            if (!hasNext()) {
                throw new IllegalStateException("No more songs in the playlist.");
            }
            return songs.get(currentIndex++);
        }
    }
}