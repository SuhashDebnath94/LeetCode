package arrays;

public class N12_CountMaximumConsecutive1s {
    /*
    Given a binary array nums, return the maximum number of consecutive 1's in the array.


     */
    public static void main(String[] args) {
        int[] arr={0,1,1,1,2,3,1,1,1,1,2,5,4,2,2,0};
        System.out.println(maxConsequtiveOnes(arr));
    }

    private static int maxConsequtiveOnes(int[] arr) {
        int count=0;
        int max=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]==1){
                count++;
                max=Math.max(max,count);
            }
            else {
                count=0;
            }
        }
        return max;
    }
}
