package DesignPatterns.Structural.Flyweight.example1;

import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
class CharacterFactory {
    private final Map<java.lang.Character, CharacterFlyweight> characterMap = new HashMap<>();

    public Character getCharacter(char character) {
        // Reuse existing flyweight or create a new one if it doesn't exist
        characterMap.putIfAbsent(character, new CharacterFlyweight(character));
        return characterMap.get(character);
    }
}