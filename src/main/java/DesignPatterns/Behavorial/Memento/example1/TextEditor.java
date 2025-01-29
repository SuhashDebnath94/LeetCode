package DesignPatterns.Behavorial.Memento.example1;

// Originator
class TextEditor {
    private String text;

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public TextMemento saveStateToMemento() {
        return new TextMemento(text);
    }

    public void restoreStateFromMemento(TextMemento memento) {
        this.text = memento.getText();
    }
}