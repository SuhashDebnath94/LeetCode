package arrays;

public class N07_MoveAllZerosToTheEnd {
    /*
    Given an integer array nums, move all 0's to the end of it while maintaining the relative order of the non-zero elements.

    Note that you must do this in-place without making a copy of the array.
     */

    /**
     The first thing I thought was:

     Scoop up all non-zero numbers into a new array.
     Dump all zeros at the end.

     Why this won’t work?
     We’re not allowed to use extra space! This violates the problem’s rules.

     Alright, so we gotta work with what we have—just like in real life.

     ⏳ Time Complexity: O(n)
     📦 Space Complexity: O(n) ❌ (Not allowed)


     Instead of thinking about removing zeros, let’s think about shifting non-zero numbers forward.

     Here’s the trick:

     1) Use a pointer (j) to track where the next non-zero should go.
     2) Loop through the array:
            If the number is non-zero, swap it with nums[j] and move j forward.
            If it’s a zero, just skip it.
     3) Once all non-zeros are placed correctly, all remaining spaces will automatically be zeros.
     📌 Example Walkthrough
     Given nums = [0,1,0,3,12]

     🔄 Step-by-step execution:
     1️⃣ nums[1] = 1 → Swap with nums[0] → [1,0,0,3,12] (j = 1)
     2️⃣ nums[3] = 3 → Swap with nums[1] → [1,3,0,0,12] (j = 2)
     3️⃣ nums[4] = 12 → Swap with nums[2] → [1,3,12,0,0] (j = 3)

     🎉 Boom! Zeros are pushed to the end, in-place.

     ⏳ Time Complexity: O(n)
     📦 Space Complexity: O(1)
     */


    public static void main(String[] args) {
        Integer[] arr={0,1,2,4,2,0,1,2,3,7,0,1,4,0,0,0,4,5};
        ArrayUtil.printAllElements(moveZerosToTheEndOptimal(arr));
    }

    private static int[] moveZerosToTheEnd(int[] arr) {
        int low=0;
        int high=arr.length-1;

        while(arr[high]==0){
            high--;
        }

        while(low<high){
            if(arr[high]==0){
                high--;
                continue;
            }
            if(arr[low]==0) {
                arr[low] = arr[high];
                arr[high] = 0;
                high--;
            }
            low++;
        }

        return arr;
    }

    //OR
    private static Integer[] moveZerosToTheEnd2(Integer[] arr){
        int j=-1;
        for (int i=0;i<arr.length;i++){
            if(arr[i]==0){
                j=i;
                break;
            }
        }
        for (int i=j+1;i<arr.length;i++){
            if(arr[i]!=0){
                int temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                j++;
            }
        }
        return arr;
    }

//    OR
    public static Integer[] moveZerosToTheEndOptimal(Integer[] nums) {
        int j = 0; // Pointer for the next non-zero position
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                swap(nums, i, j);
                j++;
            }
        }
        return nums;
    }

    private static void swap(Integer[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
