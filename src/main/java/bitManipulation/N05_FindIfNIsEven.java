package bitManipulation;

public class N05_FindIfNIsEven {
    /**
     * Given a number n Find if The number is even or Odd
     */
    public static void main(String[] args) {
        System.out.println(findEvenOrOdd(4));
    }

    private static String findEvenOrOdd(int n) {
        return (n & 1) == 0 ? "even": "odd";
    }

    /**
     * Remember the last bit or the rightmost bit of an odd number is always 1 and for even number it is 0
     */
}
