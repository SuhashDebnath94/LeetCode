package DesignPatterns.Creational.Singleton;

public class N01_EagerSingleton {
    /*
    Pros: Simple, thread-safe.
    Cons: Instance is created even if it might not be used, wasting resources.
     */
    private static final N01_EagerSingleton INSTANCE = new N01_EagerSingleton();
    private N01_EagerSingleton(){}

    public static N01_EagerSingleton getInstance(){
        return INSTANCE;
    }
}
