package DP;

public class N7_NinjasTraining {
//    A Ninja has an ‘N’ Day training schedule.
//    He has to perform one of these three activities (Running, Fighting Practice, or Learning New Moves) each day.
//    There are merit points associated with performing an activity each day.
//    The same activity can’t be performed on two consecutive days.
//    We need to find the maximum merit points the ninja can attain in N Days.
//
//    We are given a 2D Array POINTS of size ‘N*3’ which tells us the merit point of specific activity on that particular day.
//    Our task is to calculate the maximum number of merit points that the ninja can earn.

//    days: 3
//    points: 10, 40, 70
//            20, 50, 80
//            30, 60, 90

//    Answer: 210 (70+50+90)

//    Soln:
//    While running recursion we need to know what we did on previous day so we need that as parameter in function
//    so if 0 is passed we have done task 0, if 1 then task 1, ans if 2 then task 2, but if 3 is passed then we havnt done any task

//    To know what all i can do on an index i need to know what i did on the previous index
//    so to know what you can do on one day you need to know what you did on the last day
//    f(day,last){
//        if(ind==0){       //base case
//            max=0;
//            for(i=0 -> 2){
//                if(i!=last){
//                    max=max(max, task[0][i]); //we take the maximum of the other 2 tasks from the one that was done on the last day
//                    return max;
//                }
//            }
//        }
//    max=0
//    for(i=0->2){
//        if(i!=last){
//            points=task[day][i]+f(day-1, i)  //task of this day + task of previous days
//                    max=max(max, points)
//        }
//    }
//   }

//    Now identify the overlapping subproblems
//    apply memoization

//    day can have n different values n being the number of days
//    last can be 0, 1, 2, 3 so 4 different values
//    so you will require a nx4 DP size array

    public static void main(String[] args) {

        int[][] arr= new int[5][2];
        ninjaTraining(arr, 5 );
    }

    private static int ninjaTraining(int[][] arr, int day) {
        return ninjaTraining(arr, day, 3, 0);
    }

    private static int ninjaTraining(int[][] tasks,int day,  int last, int points) {
        if(day==0){
            int maxi=0;
            for(int i=0;i<=2;i++){
                if(i!=last){
                    maxi=Math.max(maxi, tasks[0][i]);
                }
                return maxi;
            }
        }
        int max=0;
        for(int i=0;i<=2;i++){
            if(i!=last){
                points=tasks[day][i]+ninjaTraining(tasks, day-1, i, points);
                max=Math.max(max, points);
            }
        }
        return points;
    }

}
