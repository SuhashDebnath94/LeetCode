package DesignPatterns.Behavorial.Memento.example2;

// Memento (State)
class GameMemento {
    private int level;
    private int score;

    public GameMemento(int level, int score) {
        this.level = level;
        this.score = score;
    }

    public int getLevel() {
        return level;
    }

    public int getScore() {
        return score;
    }
}