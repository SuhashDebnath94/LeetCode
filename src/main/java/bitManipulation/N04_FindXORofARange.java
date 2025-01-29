package bitManipulation;

public class N04_FindXORofARange {
    /**
     * Given a Range L to R print the xor of the range
     * L ^ L+1 ^ L+2 ..... R-1 ^ R
     *
     * Soln:
     *  We will find the XOR of 1 to L and the Xor of 1 to R
     *  then Xor of the 2 results to cancel out the numbers not in the range
     */
    public static void main(String[] args) {
        System.out.println(findXOROfRange( 5,  7));
    }

    private static int findXOROfRange(int L, int R) {
        return findXORfrom1ToN(L-1)^findXORfrom1ToN(R);
    }

    private static int findXORfrom1ToN(int n) {
        switch(n%4){
            case 0: return n;
            case 1: return 1;
            case 2: return n+1;
            case 3: return 0;
            default: return Integer.MAX_VALUE;
        }
    }

}
