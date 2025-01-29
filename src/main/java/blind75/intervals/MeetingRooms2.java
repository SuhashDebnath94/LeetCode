package blind75.intervals;

import java.util.Arrays;

public class MeetingRooms2 {
    /**
     * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
     * find the minimum number of conference rooms required.)
     *
     * Input: intervals = [(0,30),(5,10),(15,20)]
     * Output: 2
     * Explanation:
     * We need two meeting rooms
     * room1: (0,30)
     * room2: (5,10),(15,20)
     */

    public static void main(String[] args) {
        int[][] intervals = {{0, 30}, {5, 10}, {15, 20}};
//        int[][] intervals = {{5, 8}, {9, 15}};

        System.out.println(maxNumberOfRoomsNeeded(intervals));
    }

    private static int maxNumberOfRoomsNeeded(int[][] intervals) {

        int result=Integer.MIN_VALUE;

        int[] startTimes=new int[intervals.length];
        int[] endTimes=new int[intervals.length];

        int s=0;
        int e=0;

        for(int i=0;i<intervals.length;i++){
            startTimes[i]=intervals[i][0];
        }
        for(int i=0;i<intervals.length;i++){
            endTimes[i]=intervals[i][1];
        }
        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int numberOFMeetings=0;
        {
            while(s<intervals.length){
                if(startTimes[s]< endTimes[e]){
                    numberOFMeetings++;
                    s++;
                }
                else{
                    numberOFMeetings--;
                    e++;
                }
                result=Math.max(result,numberOFMeetings);
            }
        }
        return result;
    }
}
