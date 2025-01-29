package blind75.arrays;

public class ContainerWithMostWater {
//    Given an integer array height of length n.
//    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
//    Find two lines that together with the x-axis form a container, such that the container contains the most water.
//    Return the maximum amount of water a container can store.
//
//    Notice that you may not slant the container.
//
//    Examples:
//
//    Input: nums = [1,4,2,3]
//    Output: 6

    static int maxAreaBruteForce(int nums[]) {
        int mx = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                int water = (j-i)* Math.min(nums[i], nums[j]);
                mx = Math.max(mx, water);
            }
        }
        return mx;
    }
    static int maxArea(int nums[]) {

        int i = 0,j = nums.length - 1, mx = Integer.MIN_VALUE;
        while(i < j)
        {
            int water = (j-i)* Math.min(nums[i],nums[j]);
            mx = Math.max(mx,water);
            if(nums[i] < nums[j])
                i++;
            else
                j--;
        }

        return mx;
    }
    public static void main(String args[])
    {
        int nums[] = {1, 4, 2, 3};

        System.out.println("Maximum amount of water is: " + maxAreaPrac(nums));
    }

    private static int maxAreaPrac(int[] nums) {
        int maxWater=Integer.MIN_VALUE;
        int l=0;
        int h=nums.length-1;
        while (l<h){
                int max=(h-l)*Math.min(nums[l], nums[h]);
                maxWater=Math.max(maxWater, max);
                if(nums[l]>nums[h]){
                    h--;
                }
                else {
                    l++;
                }
        }
        return maxWater;
    }


}
