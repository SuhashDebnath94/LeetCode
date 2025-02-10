package arrays;

public class N11_SingleNumber {
    //    Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
//
//      You must implement a solution with a linear runtime complexity and use only constant extra space.

//    Intuition:
//  Xor of any two num gives the difference of bit as 1 and same bit as 0.
//  Thus, using this we get 1 ^ 1 == 0 because the same numbers have same bits.
//  So, we will always get the single element because all the same ones will evaluate to 0 and 0^single_number = single_number.

    public static void main(String[] args) {
        int[] input = {0,1,2,1,2};
        System.out.println(singleNumber(input));
    }

    private static int singleNumber(int[] input) {
        int result=0;
        for(int i=0;i<input.length;i++){
            result=result^input[i];
        }
        return result;
    }
}
