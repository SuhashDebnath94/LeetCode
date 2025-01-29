package DesignPatterns.Structural.Flyweight.example2;

import java.util.HashMap;
import java.util.Map;

// Flyweight Factory
class TreeFactory {
    private final Map<String, TreeFlyweight> treeMap = new HashMap<>();

    public Tree getTree(String type, String color, String texture) {
        String key = type + "-" + color + "-" + texture;
        treeMap.putIfAbsent(key, new TreeFlyweight(type, color, texture));
        return treeMap.get(key);
    }
}
