package bitManipulation;

public class N08_ClearTheIthBit {
    /**
     * Given a number and i set the ith bit
     *  * So if n=13 (1101) and i = 2  -> 3210
     *      * Answer will be 9
     */
    public static void main(String[] args) {
        System.out.println(clearIthBit(13, 2));
    }

    private static int clearIthBit(int n, int i) {
        int mask = ~(1 << i); //we negate the 0010 to 1101
        return (mask & n);
    }
}
