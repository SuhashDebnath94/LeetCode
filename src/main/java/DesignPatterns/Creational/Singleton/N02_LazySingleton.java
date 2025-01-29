package DesignPatterns.Creational.Singleton;

public class N02_LazySingleton {
    /*
    Pros: Instance is created only when needed.
    Cons: Not thread-safe in multithreaded environments.
     */
    private static N02_LazySingleton instance=null;
    private N02_LazySingleton(){}
    public static N02_LazySingleton getInstance(){
        if(instance==null){
            instance = new N02_LazySingleton();
        }
        return instance;
    }

}
