package bitManipulation;

public class N07_SetTheIthBit {
    /**
     * Given a number and i set the ith bit
     *  * So if n=13 (1101) and i = 1  -> 3210
     *      * Answer will be 15
     */
    public static void main(String[] args) {
        System.out.println(SetIthBit(13, 1));
    }

    private static int SetIthBit(int n, int i) {
        int mask = 1 << i;
        return (mask | n);
    }
}
