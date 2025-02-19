package arrays;

public class N25_ContainerWithMostWater {
    /*
    You are given an integer array height of length n.
    There are n vertical lines drawn such that the two endpoints of the ith line are (i, 0) and (i, height[i]).
    Find two lines that together with the x-axis form a container, such that the container contains the most water.
    Return the maximum amount of water a container can store.
    Notice that you may not slant the container.

    Input: height = [1,8,6,2,5,4,8,3,7]
    Output: 49

     */

    /*
    🤔 Brute Force Approach: "Let’s Check Every Pair"
    A beginner might think:

    Try every possible pair of lines to see which holds the most water.
    For every pair (i, j), calculate:
    width = j - i
    height = min(height[i], height[j])
    area = width * height
    Keep track of the maximum area found.
    ⏳ Time Complexity: O(N²) | 📦 Space Complexity: O(1)
    Bad idea for large inputs! Too slow. ⏳
     */

    /*
     Optimal Approach (Two-Pointer Method)
    Instead of checking every pair, start with the widest container possible and shrink intelligently.

    Use two pointers, one at the start (left = 0) and one at the end (right = n-1).
    Calculate the area between height[left] and height[right].
    Move the pointer pointing to the shorter height (because increasing height gives more potential area).
    Keep updating the maximum area found.

    Why does this work?
     The widest container is the first one, so we start with that.
      Moving the shorter wall gives us a chance at a taller wall (because width is shrinking).
    Eventually, all pairs are considered without redundant calculations.
     ⏳ Time Complexity: O(N) | 📦 Space Complexity: O(1)
    Much better! 🚀
     */

    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxWater = 0;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            int area = width * minHeight;
            maxWater = Math.max(maxWater, area);

            // Move the shorter line inward to try for a taller one
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        return maxWater;
    }

    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(height)); // Output: 49
    }
}
