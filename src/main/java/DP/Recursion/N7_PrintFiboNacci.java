package DP.Recursion;

public class N7_PrintFiboNacci {
    public static void main(String[] args) {
        System.out.println(getFibo(7));
    }

    private static int getFibo(int n) {
        if(n<=1) return n;
        return getFibo(n-1)+getFibo(n-2);
    }
}

// T(C) -> O(2^n) Exponential