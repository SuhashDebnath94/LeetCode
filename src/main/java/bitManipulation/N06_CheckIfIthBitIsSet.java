package bitManipulation;

public class N06_CheckIfIthBitIsSet {
    /**
     * Given a number n and an integer i check if the ith bit of n is set
     *
     * So if n=13 (1101) and i = 2  -> 3210
     * Answer will be true
     *
     * soln:
     *  If i put a set bit at ith position and rest as 0 and and with the n then if ith bit is 1 then answer will be non zero and if answer is 0 then i th bit is 0
     *  example:
     *          1101 &
     *          0100
     *
     *       -> will be 0100 which is non zero since ith bit is set
     *
     *       how to get 0100 to and with?
     *               if i is given as 3 the the number which we need would be 2^i
     *               or
     *               1 << i
     */

    public static void main(String[] args) {
        System.out.println(isIthBitSet(13, 1));
    }

    private static boolean isIthBitSet(int n, int i) {
//        int numberToAndWith = (int) Math.pow(2,i);
        int numberToAndWith = 1 << i;
        return (numberToAndWith & n) !=0;
    }
}

