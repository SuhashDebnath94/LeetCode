package bitManipulation;

public class N10_CheckIfANumberIsPowerOf2 {
    /**
     * Check if a number is a power of 2
     *
     * so if n is 16 10000
     * if you subtract 1 15 is 1111
     * if you and 16 and 15 the answer should be 0
     */

    public static void main(String[] args) {
        System.out.println(checkIfNumberIsPowerOf2(15));
    }

    private static boolean checkIfNumberIsPowerOf2(int n) {
        return (n&(n-1))==0;
    }
}
