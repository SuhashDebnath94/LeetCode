package BinarySearch;

public class N04_IntegerSqrtOfN {
    /**
     * Given N find the integer square root of n
     * like if n is 26 the integer square root would be 5
     *
     * explanation:
     * The question can be reframed as find the largest i which on multiplcation with itself gives you less than n
     * i can be anything between 0-n
     *
     * so i is somewhere between 0 and 26
     * so if low is 0 and high is 26 mid will be 13
     * 13x13 is higher than x so we bring down the high
     *
     * continue this till you get the last answer
     */

    public static void main(String[] args) {
        int n=26;
        System.out.println(findIntegerSqrt(n));
    }

    private static int findIntegerSqrt(int n) {
        int low=0;
        int high=n;
        int ans=0;

        while(low<=high){

            int mid=(low+high)/2;
            if(n>=mid*mid) {
                low=mid+1;
                ans=mid;
            }
            else high=mid-1;
        }

        return ans;
    }
}
