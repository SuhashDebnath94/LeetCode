package slidingWindow;

public class N01_MaxSumSubArrayOfSizeK {
    public static void main(String[] args) {
        int[] arr= {2, 5, 1, 8, 2, 9, 1};
        int n=7;
        int windowSize=3;
        System.out.println(getMaximumSumOfSizeK(arr, windowSize));
    }

    private static int getMaximumSumOfSizeK(int[] arr, int windowSize) {
        int i=0;
        int j=0;
        int max=Integer.MIN_VALUE;

        while(j<arr.length){
            if((j-i)+1<windowSize){
                j++;
            }
            else if((j-i)+1==windowSize){
                int sum=0;
                for(int k=i;k<=j;k++){
                    sum+=arr[k];
                }
                max=Math.max(max,sum);
                i++;
                j++;
            }
        }
        return max;
    }

    /*
    logic:
        1) now first we need to find the window start and end
        so we will take 2 pointers i and j
        keep both at 0
        window size is always (j-i)+1
        so if j and i both are at 0 window size is (0-0)+1 = 1
        if i is at 2 and j is at 5 window size is (5-2)+1 = 4

        So first check if (j-i) +1 is less than window size
        If yes:
            then increment j
            till (j-i)+1 ==k

        2) Once we find the window size we need to maintain the window size
            so after this increment both i and j together.

     */

}
