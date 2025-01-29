package blind75.intervals;

import java.util.Arrays;

public class MeetingRooms {
    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * determine if a person could attend all meetings.
     *
     * Input: intervals = [(0,30),(5,10),(15,20)]
     * Output: false
     * Explanation:
     * (0,30), (5,10) and (0,30),(15,20) will conflict
     */
    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
//        int[][] intervals = {{5, 8}, {9, 15}};

        System.out.println(canAttendAllMeetings(intervals));

    }

    private static boolean canAttendAllMeetings(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        for (int i = 0; i < intervals.length-1; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }


    public class Interval {
        int start, end;

        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
