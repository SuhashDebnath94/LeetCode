package DesignPatterns.Creational.Singleton;

public class N05_BillPuggSingleton {
    /*
    Pros: Lazy initialization, thread-safe, efficient.
    Cons: Slightly more complex to understand.
     */
    private N05_BillPuggSingleton(){}

    private static class SingletonHelper {
        private static final N05_BillPuggSingleton INSTANCE = new N05_BillPuggSingleton();
    }
    public static N05_BillPuggSingleton getInstance(){
        return SingletonHelper.INSTANCE;
    }

}
