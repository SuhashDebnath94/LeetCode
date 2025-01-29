package DesignPatterns.Creational.Singleton;

public class N04_LazySingletonDoubleLocking {
    /*
    Pros: Efficient, thread-safe.
    Cons: Slightly complex; requires volatile to ensure proper handling in modern JVMs.
     */
    private static N04_LazySingletonDoubleLocking instance=null;
    private N04_LazySingletonDoubleLocking(){}
    public static N04_LazySingletonDoubleLocking getInstance(){
        if(instance==null){
            synchronized (N04_LazySingletonDoubleLocking.class){
                if(instance==null){
                    instance = new N04_LazySingletonDoubleLocking();
                }
            }
        }
        return instance;
    }

}
