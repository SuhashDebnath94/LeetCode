package DesignPatterns.Behavorial.Memento.example2;

public class Driver {
    public static void main(String[] args) {
        Game game = new Game();
        GameSaveSystem saveSystem = new GameSaveSystem();

        // Save game state
        game.setLevel(5);
        game.setScore(1500);
        saveSystem.addMemento(game.saveStateToMemento());

        game.setLevel(6);
        game.setScore(1800);
        saveSystem.addMemento(game.saveStateToMemento());

        // Load the game from the first save
        game.restoreStateFromMemento(saveSystem.getMemento(0));
        System.out.println("Restored Game - Level: " + game.getLevel() + ", Score: " + game.getScore());
    }
}
