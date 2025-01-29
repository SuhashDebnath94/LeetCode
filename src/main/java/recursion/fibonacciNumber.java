package recursion;

public class fibonacciNumber {
    public static void main(String[] args) {
//        0 1 1 2 3 5 8 13 21
        System.out.println(fibonacciItem(6));
    }

    private static int fibonacciItem(int i) {

        if(i<=1){
            return i ;
        }
        else {
            return fibonacciItem(i-1)+ fibonacciItem(i-2);
        }

    }

}
