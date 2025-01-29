package DesignPatterns.Creational.Prototype;

interface Shape extends Cloneable {
    Shape clone();
    void draw();
}