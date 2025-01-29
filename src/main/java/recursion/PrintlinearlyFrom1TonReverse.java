package recursion;

public class PrintlinearlyFrom1TonReverse {
    public static void main(String[] args) {
        printLineralyFrom1ToNFunc( 5);
    }

    private static void printLineralyFrom1ToNFunc( int n) {
        if(n==0){
            return;
        }

        System.out.println(n);
        n--;
        printLineralyFrom1ToNFunc(n);


    }
}
