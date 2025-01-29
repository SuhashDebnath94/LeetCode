package DesignPatterns.Behavorial.Memento.example1;

import java.util.ArrayList;
import java.util.List;

// Caretaker
class TextEditorHistory {
    private List<TextMemento> mementoList = new ArrayList<>();

    public void addMemento(TextMemento memento) {
        mementoList.add(memento);
    }

    public TextMemento getMemento(int index) {
        return mementoList.get(index);
    }
}