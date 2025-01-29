package DesignPatterns.Behavorial.Iterator;

interface IterableCollection<T> {
    Iterator<T> createIterator();
}