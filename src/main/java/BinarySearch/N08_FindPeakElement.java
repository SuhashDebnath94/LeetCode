package BinarySearch;

public class N08_FindPeakElement {
    /**
     * A peak element is an element which is larger than its neighbours.
     *
     * Given an integer array nums, find the peak. If there are multiple peaks you may return the index of any of the peaks
     *
     * You can assume the element after end is -infinity, and before start is -1
     * So there will always be a peak.
     *
     * eg:
     *  1, 2, 1, 3, 5, 6, 4
     *  Ans: 5
     *  Because 6 is higher than 5 and 4
     *
     *
     *  Soln:
     *      If mid-1 < mid
     *          It can be said that the left half will always contain a peak
     *
     *          So after elemination
     *          low=mid+1
     *          high=mid
     */




}
