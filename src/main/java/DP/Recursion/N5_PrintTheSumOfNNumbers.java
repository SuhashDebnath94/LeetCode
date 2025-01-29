package DP.Recursion;

public class N5_PrintTheSumOfNNumbers {
    public static void main(String[] args) {
        printTheSumOfNNumbers(4,1,  0);
        System.out.println(printTheSumOfNNumbers2(4));
    }

    private static int printTheSumOfNNumbers2(int n) {
        if(n==0){
            return 0;
        }
        return n+printTheSumOfNNumbers2(n-1);
    }

    private static void printTheSumOfNNumbers(int n, int i,  int sum) {
        if(i>n){
            System.out.println(sum);
            return;
        }
        sum=sum+i;
        i=i+1;
        printTheSumOfNNumbers(n, i, sum);

    }

}
