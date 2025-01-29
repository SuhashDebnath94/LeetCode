package blind75.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeIntervals {
//    Given an array of intervals, merge all the overlapping intervals and return an array of non-overlapping intervals.

//    Input: intervals=[[1,3],[2,6],[8,10],[15,18]]
//
//    Output: [[1,6],[8,10],[15,18]]
//
//    Explanation: Since intervals [1,3] and [2,6] are overlapping we can merge them to form [1,6]
//    intervals.

//    Linearly iterate over the array if the data structure is empty insert the interval in the data structure.
//    If the last element in the data structure overlaps with the current interval we merge the intervals by updating the last element in the data structure, and if the current interval does not overlap with the last element in the data structure simply insert it into the data structure.
//
//    Intuition: Since we have sorted the intervals, the intervals which will be merging are bound to be adjacent.
//    We kept on merging simultaneously as we were traversing through the array and when the element was non-overlapping we simply inserted the element in our data structure.

    public static void main(String args[]) {
        ArrayList<List<Integer>> arr = new ArrayList<>();
        arr.add(Arrays.asList(new Integer[]{1, 3}));
        arr.add(Arrays.asList(new Integer[]{2, 4}));
        arr.add(Arrays.asList(new Integer[]{2, 6}));
        arr.add(Arrays.asList(new Integer[]{8, 9}));
        arr.add(Arrays.asList(new Integer[]{8, 10}));
        arr.add(Arrays.asList(new Integer[]{9, 11}));
        arr.add(Arrays.asList(new Integer[]{15, 18}));
        arr.add(Arrays.asList(new Integer[]{16, 17}));
        ArrayList<List<Integer>> ans = merge(arr);
        System.out.println("Merged Overlapping Intervals are ");
        for (List<Integer> it : ans) {
            System.out.println(it.get(0) + " " + it.get(1));
        }
    }

    static ArrayList < List < Integer >> merge(ArrayList < List < Integer >> intervals) {

        Collections.sort(intervals, (a, b)->a.get(0)-b.get(0));  //first we sort the intervals
        ArrayList<List<Integer>> merged = new ArrayList<>(); //create a list result

        for (int i = 0; i < intervals.size(); i++) {    //iterate through the sorted intervals
            if (merged.isEmpty() || merged.get(merged.size() - 1).get(1) < intervals.get(i).get(0)) { //if maximum index of previous index of merged is greater than minimum of current index of intervals then add to merged so for [1,3] and [4, 5] an new interval will be added to result
                ArrayList<Integer> v = new ArrayList<>();
                v.add(intervals.get(i).get(0));
                v.add(intervals.get(i).get(1));

                merged.add(v);
            } else {
                merged.get(merged.size() - 1).set(1, Math.max(merged.get(merged.size() - 1).get(1), intervals.get(i).get(1))); //else the maximum of last result interval will be updated to the maximum of the current interval
            }
        }

        return merged;
    }
}
