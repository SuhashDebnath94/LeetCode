package DesignPatterns.Structural.Flyweight.example1;

// Concrete Flyweight
class CharacterFlyweight implements Character {
    private final char character; // Intrinsic state (shared)

    public CharacterFlyweight(char character) {
        this.character = character;
    }

    @Override
    public void display(int position) {
        System.out.println("Character: " + character + " at position: " + position);
    }
}