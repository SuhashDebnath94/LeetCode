package recursion;

public class SumOfNNumbers {
    public static void main(String[] args) {
        System.out.println(printSumofFirstNNumbers(5));
        printSumofFirstNNumbers2(5, 0);
    }

    private static int printSumofFirstNNumbers(int i) {
        if(i==1){
            return 1;
        }
        else {
            return i+printSumofFirstNNumbers(i-1);
        }
    }

    private static void printSumofFirstNNumbers2(int i, int sum){
        if(i<1){
            System.out.println(sum);
            return;
        }
        printSumofFirstNNumbers2(i-1, sum+i);
    }
}
