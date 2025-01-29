package bitManipulation;

public class N03_FindXOROfNNumbers {
    /**
     * Given N, find the Xor of 1 to n, dont use for loop
     *
     * Soln:
     *  when n= 1 -> result = 1
     *  when n= 2 -> result = 3
     *  when n= 3 -> result = 0
     *  when n= 4 -> result = 4
     *  when n= 5 -> result = 1
     *  when n= 6 -> result = 7
     *  when n= 7 -> result = 0
     *  when n= 8 -> result = 8
     *
     *  so
     *  if n% 4 = 0 then answer is n
     *  if n% 4 = 1 then answer is 1
     *  if n% 4 = 2 then answer is n+1
     *  if n% 4 = 3  then answer is 0
     */

    public static void main(String[] args) {
        System.out.println(findXORfrom1ToN(8));
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
