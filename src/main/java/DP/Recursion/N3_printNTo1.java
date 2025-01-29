package DP.Recursion;

public class N3_printNTo1 {
    public static void main(String[] args) {
    printNto1( 5);
}

    private static void printNto1( int i) {
        if(i<1) return;
        System.out.println(i);
        i--;
        printNto1( i);
    }
}
