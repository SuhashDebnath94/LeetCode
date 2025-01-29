package blind75.arrays;

public class SearchInRotatedSortedArray {

//    There is an integer array nums sorted in ascending order (with distinct values). 
//    Given the array nums after the possible clockwise rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums. 
//    We need to search a given element in a rotated sorted array.

    public static void main(String args[]) {
        int nums[] = {7,8,9,10,11,13,15,1,3,5};
        int index = search(nums, 8);
        if (index >= 0) {
            System.out.println("Value is at index: " + index);
        } else {
            System.out.println("Not found");
        }
    }

    private static int search(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;



//        {7,8,9,10,11,13,15,1,3,5};

        while(low<=high){
            int mid= low+high /2 ;
            if(nums[mid]==target){
                return mid;
            }
//
            if(nums[low]<=nums[mid]){  //this means left side is sorted
                if(target>=nums[low] && target<=nums[mid] ){ //check for target and adjust pointer
                    high = mid-1;
                }else{
                    low = mid+1;
                }
            }
            else{
                if(target>=nums[mid] && target<=nums[high]){  //this means
                    low = mid+1;
                }else{
                    high = mid-1;
                }
            }
        }

        return -1;


    }
}
