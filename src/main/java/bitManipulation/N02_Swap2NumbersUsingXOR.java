package bitManipulation;

public class N02_Swap2NumbersUsingXOR {
    /**
     * Swap 2 numbers using XOR
     */

    public static void main(String[] args) {
        int a= 5;
        int b=7;

        System.out.println("A is "+a);
        System.out.println("B is "+b);

        a=a^b;
        b=a^b;
        a=a^b;

        System.out.println("A is "+a);
        System.out.println("B is "+b);
    }
}
