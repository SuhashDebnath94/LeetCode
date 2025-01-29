package blind75.arrays;

public class ProductSubArrayinArray {
//    Given an array that contains both negative and positive integers, find the maximum product subarray.
//    Input:
//      Nums = [1,2,3,4,5,0]
//    Output:
//       120

    static int maxProductSubArrayBruteForce(int arr[]) {
        int result = Integer.MIN_VALUE;
        for(int i=0;i<arr.length-1;i++)
            for(int j=i+1;j<arr.length;j++) {
                int prod = 1;
                for(int k=i;k<=j;k++)
                    prod *= arr[k];
                result = Math.max(result,prod);
            }
        return result;
    }

    static int maxProductSubArray(int arr[]) {
        int prod1 = arr[0],prod2 = arr[0],result = arr[0];

        for(int i=1;i<arr.length;i++) {
            int temp = Math.max(arr[i],Math.max(prod1*arr[i],prod2*arr[i]));
            prod2 = Math.min(arr[i],Math.min(prod1*arr[i],prod2*arr[i]));
            prod1 = temp;

            result = Math.max(result,prod1);
        }

        return result;
    }

    public static void main(String[] args) {
        int nums[] = {1,2,-3,0,-4,-5};
        int answer = maxProductSubArrayPrac(nums);
        System.out.println("The maximum product subarray is: "+answer);
    }

    private static int maxProductSubArrayPrac(int[] nums) {
        int prod1=nums[0]; int prod2=nums[0]; int result=nums[0];

        for(int i=0;i<nums.length;i++){
            int temp=Math.max(nums[i], Math.max(prod1*nums[i], prod2*nums[i]));
            prod2=Math.min(nums[i], Math.min(prod1*nums[i], prod2*nums[i]));
            prod1 = temp;
            result = Math.max( result, prod1);
        }

        return result;
    }
}
