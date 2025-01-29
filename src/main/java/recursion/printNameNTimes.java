package recursion;

public class printNameNTimes {
    public static void main(String[] args) {
        printNameNTimesFunc("Suhash", 5);
    }

//    T: O(n)
//    S: O(n)
    private static void printNameNTimesFunc(String name, int n) {
        if(n==0){
            return;
        }
        System.out.println(name);
        n--;
        printNameNTimesFunc(name, n);
    }

}
