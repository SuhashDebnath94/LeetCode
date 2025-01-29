package DesignPatterns.Behavorial.Memento.example1;

public class Driver {
    public static void main(String[] args) {
        TextEditor editor = new TextEditor();
        TextEditorHistory history = new TextEditorHistory();
        // User types in the editor
        editor.setText("Hello, world!");
        history.addMemento(editor.saveStateToMemento());

        editor.setText("Hello, Memento pattern!");
        history.addMemento(editor.saveStateToMemento());
        // Undo the last change
        editor.restoreStateFromMemento(history.getMemento(0));
        System.out.println("Restored Text: " + editor.getText());
    }
}
