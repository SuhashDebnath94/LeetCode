package DP.Recursion;

public class N4_print1ToNBAcktrack {
    public static void main(String[] args) {
        print1toN(  6);
    }

    private static void print1toN( int i) {
        if(i==1) return;
        i--;
        print1toN( i);
        System.out.println(i);
    }
}
