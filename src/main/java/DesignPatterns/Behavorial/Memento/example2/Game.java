package DesignPatterns.Behavorial.Memento.example2;

// Originator
class Game {
    private int level;
    private int score;

    public void setLevel(int level) {
        this.level = level;
    }

    public void setScore(int score) {
        this.score = score;
    }
    public int getLevel(){
        return this.level;
    }
    public int getScore(){
        return this.score;
    }

    public GameMemento saveStateToMemento() {
        return new GameMemento(level, score);
    }

    public void restoreStateFromMemento(GameMemento memento) {
        this.level = memento.getLevel();
        this.score = memento.getScore();
    }
}