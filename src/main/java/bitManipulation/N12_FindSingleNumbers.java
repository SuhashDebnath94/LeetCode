package bitManipulation;

public class N12_FindSingleNumbers {
    /**
     * Given an array { 2, 1, 2 , 5, 1, 4, 4, 7, 3, 3} all elements appear twice only 2 elements appear once
     * Find those 2 elements
     *
     * In this case 5 and 7
     *
     * soln:
     *     step 1) XOr all the numbers the result will be the XOR or 5 and 7 which are the 2 single numbers
     *     Step 2) 5 ^ 7 is 101 ^ 111 = 010 that is the first bit in the result is set because all other bits are same and cancels out only the 1st bit is different
     *     Step 3) Now we will divide the array into two parts the ones whose first bit is set and the ones whose 1st bit is not set
     *     Step 4) Now in the two sets xor all the numbers to find each number
     */
    public static void main(String[] args) {
        int[] arr = { 2, 1, 2 , 5, 1, 4, 4, 7, 3, 3};
        findSingleElements(arr);
    }

    private static void findSingleElements(int[] arr) {

        int XorOfSingleNums = 0;
        for(int i =0;i<arr.length;i++){
            XorOfSingleNums=arr[i]^XorOfSingleNums;
        }

        int count=0;

        while (XorOfSingleNums!=0){
            if((XorOfSingleNums&1) !=0) break;
            count++;
            XorOfSingleNums=XorOfSingleNums>>1;
        }

        int xor1=0;
        int xor2=0;

        for(int i=0;i<arr.length;i++){
            if((arr[i] & (1<<count)) !=0 ){
                xor1=xor1^arr[i];
            }
            else xor2=xor2^arr[i];
        }

        System.out.println(xor1);
        System.out.println(xor2);

    }
}
