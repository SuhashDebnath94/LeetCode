package DesignPatterns.Creational.Singleton;

import java.io.Serializable;

public class N08_SErializableSingleton implements Serializable {
    /*
    Pros: Instance is created only when needed.
    Cons: Not thread-safe in multithreaded environments.
     */
    private static N08_SErializableSingleton instance=null;
    private N08_SErializableSingleton(){}
    public static N08_SErializableSingleton getInstance(){
        if(instance==null){
            instance = new N08_SErializableSingleton();
        }
        return instance;
    }

    protected Object readResolve(){
        return instance;
    }

}
