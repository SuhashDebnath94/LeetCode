package blind75.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

//    Given an array of N integers, your task is to find unique triplets that add up to give a sum of zero.
//    In short, you need to return an array of all the unique triplets [arr[a], arr[b], arr[c]] such that i!=j, j!=k, k!=i, and their sum is equal to zero.

//    Example 1:
//
//    Input: nums = [-1,0,1,2,-1,-4]
//
//    Output: [[-1,-1,2],[-1,0,1]]
//
//    Explanation: Out of all possible unique triplets possible, [-1,-1,2] and [-1,0,1] satisfy the condition of summing up to zero with i!=j!=k


    static ArrayList < ArrayList < Integer >> threeSum(int nums[]) {
        ArrayList < ArrayList < Integer >> ans = new ArrayList < > ();

        int i, j, k;
        for (i = 0; i < nums.length - 2; i++) {
            for (j = i + 1; j < nums.length - 1; j++) {
                for (k = j + 1; k < nums.length; k++) {
                    ArrayList < Integer > temp = new ArrayList < > ();
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        temp.add(nums[i]);
                        temp.add(nums[j]);
                        temp.add(nums[k]);
                    }
                    if (temp.size() != 0)
                        ans.add(temp);
                }
            }
        }

        return ans;
    }

//    first we sort the array
//    keep the index i constant
//    now we do a 2 pointer approach
//    for a triplet lowP+highP should be equals -arr[i]
//    so lets say the array after sorting is -2, -2, -1, -1, -1, 0, 0, 0, 2, 2, 2
//      our i will be fixed at -2 now we will be looking for a sum which results to 2
//    low is at -2, high is at 2 -2+2=0, which doesnt satisfy the equation
//    so we need to increase the value so we increase the low pointer
//    if the low + high is equals the target then we add the triplet to result and increase low and decrease hi

    static ArrayList < ArrayList < Integer >> threeSum2(int[] num) {

        Arrays.sort(num);

        ArrayList < ArrayList < Integer >> res = new ArrayList < > ();

        for (int i = 0; i < num.length - 2; i++) {

            if (i == 0 || (i > 0 && num[i] != num[i - 1])) {

                int lo = i + 1, hi = num.length - 1, sum = 0 - num[i];

                while (lo < hi) {
                    if (num[lo] + num[hi] == sum) {
                        ArrayList < Integer > temp = new ArrayList < > ();
                        temp.add(num[i]);
                        temp.add(num[lo]);
                        temp.add(num[hi]);
                        res.add(temp);

                        while (lo < hi && num[lo] == num[lo + 1]) lo++;
                        while (lo < hi && num[hi] == num[hi - 1]) hi--;

                        lo++;
                        hi--;
                    } else if (num[lo] + num[hi] < sum) lo++;

                    else hi--;
                }
            }
        }
        return res;
    }

    public static void main(String args[]) {
        int arr[]={-1,0,1,2,-1,-4};
        ArrayList <ArrayList< Integer >> ans;
        ans = threeSum2(arr);
        ans.stream().forEach(x -> System.out.println(x));
        System.out.println("The triplets are as follows: ");
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static ArrayList<ArrayList<Integer>> threeSumPrac(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();




        return result;
    }
}
