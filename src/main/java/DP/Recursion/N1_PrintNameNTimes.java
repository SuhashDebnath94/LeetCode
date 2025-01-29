package DP.Recursion;

public class N1_PrintNameNTimes {
    public static void main(String[] args) {
        printNameNtimes("Suhash", 5, 0);
    }

    private static void printNameNtimes(String name, int n, int i) {
        if(n==i) return;
        System.out.println(name);
        i++;
        printNameNtimes(name, n, i);
    }
}

// T(C) -> O(n)