package DesignPatterns.Structural.Flyweight.example1;

public class Driver {
    public static void main(String[] args) {
        CharacterFactory factory = new CharacterFactory();

        String document = "Hello Flyweight!";
        for (int i = 0; i < document.length(); i++) {
            Character character = factory.getCharacter(document.charAt(i));
            character.display(i);
        }
    }
}
