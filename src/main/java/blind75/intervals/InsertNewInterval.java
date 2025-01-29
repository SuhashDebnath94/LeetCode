package blind75.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertNewInterval {
//    You are given an array of non-overlapping intervals where intervals[i] = [start, end] represent the start and the end of the ith interval, and intervals is sorted in ascending order by start.
//    You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
//
//    Insert newInterval into intervals such that intervals are still sorted in ascending order by start and intervals still do not have any overlapping intervals (merge overlapping intervals if necessary).
//    Return intervals after the insertion.

//    Example 1:
//    Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
//    Output: [[1,5],[6,9]]
//    Explanation: Intervals 1,3 and 2,5 can be merged to make 1,5.
//
//    Example 2:
//    Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
//    Output: [[1,2],[3,10],[12,16]]
//    Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].

//    The approach used is to first iterate through the given intervals,
//    and keeping track of the index of the interval where the new interval should be inserted such that the intervals remain sorted.
//    Then it will merge any overlapping intervals with the new interval and update its start and end times.
//    Finally, it will insert the new interval into the correct position in the intervals and return the modified intervals.
//    The key idea behind this approach is to maintain the sorted order of the intervals,
//    and to merge any overlapping intervals with the new interval.
//    By iterating through the intervals and keeping track of the index where the new interval should be inserted,
//    we can ensure that the intervals remain sorted, and by merging any overlapping intervals with the new interval,
//    we can ensure that the final output has no overlapping intervals.

    public static void main(String[] args) {

        int[][] intervals = {{1, 2}, {3, 5}, {6, 7}, {8, 10}, {12, 16}};
        int[] newInterval = {4, 8};
        System.out.println(insert(intervals, newInterval));
    }

    public static List<int[]> insert(int[][] intervals, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0, n = intervals.length;
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i++]);
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval = new int[]{Math.min(intervals[i][0], newInterval[0]), Math.max(intervals[i][1], newInterval[1])};
            i++;
        }

        res.add(newInterval);
        while (i < n) res.add(intervals[i++]);
        return res;
    }
}
