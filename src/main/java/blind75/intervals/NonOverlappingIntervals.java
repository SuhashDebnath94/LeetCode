package blind75.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class NonOverlappingIntervals {
//    Given an array of intervals where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
//    Example 1:
//    Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
//    Output: 1
//    Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.

    public static void main(String args[]) {
        ArrayList<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(new Integer[]{1, 100}));
        arr.add(Arrays.asList(new Integer[]{11, 22}));
        arr.add(Arrays.asList(new Integer[]{1, 11}));
        arr.add(Arrays.asList(new Integer[]{2, 12}));
//        arr.add(Arrays.asList(new Integer[]{8, 10}));
//        arr.add(Arrays.asList(new Integer[]{9, 11}));
//        arr.add(Arrays.asList(new Integer[]{15, 18}));
//        arr.add(Arrays.asList(new Integer[]{16, 17}));
        System.out.println("Number of intervals To be removed are "+ removeIntervals(arr));
    }

    private static int removeIntervals(ArrayList<List<Integer>> intervals) {

        Collections.sort(intervals, (a, b)->a.get(0)-b.get(0));  //first we sort the intervals

        int ans=0;
        int i=1;
        int j=0;
        while(i<intervals.size()){

            if(intervals.get(i).get(0)<intervals.get(j).get(1)){
                ans++;
                i++;
            }
            else {
                i++;
                j++;
            }
        }

        return ans;
    }

}
