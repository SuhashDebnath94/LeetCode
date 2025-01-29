package DesignPatterns.Creational.Singleton;

public class N07_ReflectionSingleton {
    /*
    Pros: Instance is created only when needed.
    Cons: Not thread-safe in multithreaded environments.
     */
    private static N07_ReflectionSingleton instance=null;
    private N07_ReflectionSingleton(){
        if(instance==null) throw new IllegalStateException("Instance already created");
    }
    public static N07_ReflectionSingleton getInstance(){
        if(instance==null){
            instance = new N07_ReflectionSingleton();
        }
        return instance;
    }

}
