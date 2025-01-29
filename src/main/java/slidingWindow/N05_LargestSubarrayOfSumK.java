package slidingWindow;

public class N05_LargestSubarrayOfSumK {
    public static void main(String[] args) {
        int[] arr={4,1,1,1,1,1,5};
        int sum=10;
        System.out.println(largestSubarrayOfSumK(arr,sum));
    }

    private static int largestSubarrayOfSumK(int[] arr, int target) {
        int i=0;
        int j=0;
        int result=0;

        while(j<arr.length){
            int sum=0;
            for(int k=i;k<=j;k++){
                sum+=arr[k];
            }
            if(sum==target){
                result=Math.max((j-i)+1,result);
            }
            if(sum>target){
                i++;
            }
            sum=0;
            for(int k=i;k<=j;k++){
                sum+=arr[k];
            }
            if(sum==target){
                result=Math.max((j-i)+1,result);
            }
            j++;

        }
        return result;
    }
}
