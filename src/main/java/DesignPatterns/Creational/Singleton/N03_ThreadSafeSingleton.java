package DesignPatterns.Creational.Singleton;

public class N03_ThreadSafeSingleton {
    /*
    Pros: Thread-safe.
    Cons: Synchronization can slow down performance due to locking overhead.
     */
    private static N03_ThreadSafeSingleton instance=null;
    private N03_ThreadSafeSingleton(){}
    public static synchronized N03_ThreadSafeSingleton getInstance(){
        if(instance==null){
            instance = new N03_ThreadSafeSingleton();
        }
        return instance;
    }
}
