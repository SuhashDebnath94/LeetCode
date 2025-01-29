package DP.Recursion;

public class N2_print1ToN {
    public static void main(String[] args) {
        print1toN( 5, 1);
    }

    private static void print1toN( int n, int i) {
        if(n<i) return;
        System.out.println(i);
        i++;
        print1toN(n, i);
    }
}
