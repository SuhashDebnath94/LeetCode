package bitManipulation;

public class N09_RemoveLastSetBit {

    /**
     * Given a number remove the last set bit
     *  * So if n=13 (1101)  -> 3210
     *      * Answer will be 1100 that is 12
     *
     *      we can and with n-1 that is 12 which 1100
     *                                          1101
     *                                          1100
     */
    public static void main(String[] args) {
        System.out.println(removeLastSetBit(13));
    }

    private static int removeLastSetBit(int n) {
        return n&n-1;
    }

}
