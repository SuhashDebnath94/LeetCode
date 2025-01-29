package DP;

public class N2_CLimbingStairs {
//    Problem Statement: Given a number of stairs. Starting from the 0th stair we need to climb to the “Nth” stair.
//    At a time we can climb either one or two steps.
//    We need to return the total number of distinct ways to reach from 0th to Nth stair.

//    How to identify Dynamic programming problem
//When we see a problem, it is very important to identify it as a dynamic programming problem.
// Generally (but not limited to) if the problem statement asks for the following:
//
//    Count the total number of ways
//    Given multiple ways of doing a task, which way will give the minimum or the maximum output.
//    We can try to apply recursion.
//    Once we get the recursive solution, we can go ahead to convert it to a dynamic programming one.

//    Once the problem has been identified, the following three steps comes handy in solving the problem:
//
//      Try to represent the problem in terms of indexes.
//      Try all possible choices/ways at every index according to the problem statement.
//      If the question states
//              Count all the ways – return sum of all choices/ways.
//              Find maximum/minimum- return the choice/way with maximum/minimum output.

//    Now each time a solution is calculated it should be stored in an array and that array should be checked before calculating again


    public static void main(String[] args) {
        System.out.println(countUniqueWaysPrac(3));
    }

    private static int countUniqueWaysPrac(int i) {
        if(i==0) return 1;
        if(i==1) return 1;
        return countUniqueWays(i-1)+countUniqueWays(i-2);
    }

    private static int countUniqueWays(int n) {
        if (n == 0) return 1;
        if (n == 1) return 1;
        return countUniqueWays(n - 1) + countUniqueWays(n - 2);
    }
}
