package bitManipulation;

public class N01_FindNumberAppearingOnce {
    /**
     * Given an array of integers all integers occur twice except one integer, print that one integer
     */

    public static void main(String[] args) {
        int[] input={1,3,4,5,4,3,1};
        System.out.println(findSingleInteger(input));
    }

    private static int findSingleInteger(int[] input) {
        int result=0;
        for(int i =0;i<input.length;i++){
            result=result ^ input[i];
        }
        return result;
    }
}
