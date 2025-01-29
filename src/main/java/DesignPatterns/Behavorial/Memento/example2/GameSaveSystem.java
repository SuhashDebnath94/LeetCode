package DesignPatterns.Behavorial.Memento.example2;

import java.util.ArrayList;
import java.util.List;

// Caretaker
class GameSaveSystem {
    private List<GameMemento> mementoList = new ArrayList<>();

    public void addMemento(GameMemento memento) {
        mementoList.add(memento);
    }

    public GameMemento getMemento(int index) {
        return mementoList.get(index);
    }
}