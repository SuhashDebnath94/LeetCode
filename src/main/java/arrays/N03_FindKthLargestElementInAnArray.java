package arrays;

public class N03_FindKthLargestElementInAnArray {
    /**
     * Given an integer array nums and an integer k, return the kth largest element in the array.
     *
     * Note that it is the kth largest element in the sorted order, not the kth distinct element.
     */
    /*
    Our first intuition is:
        1) Sorting the array
        2) Getting the kth element from the end

        Best case sorting ie quick sort takes O(nlogn) time Which is not bad, but we can do better

        Instead of sorting everything, what if we could only focus on the part of the list that contains the answer?

        Here’s the key idea:

        Input: [6, 5, 4, 3, 2, 1]
        1) Pick a random number from the list as a pivot. Let’s say we pick 3.
        2) Split the list into two parts:
            Bigger numbers than 3 → [5, 6, 4]
            Smaller numbers than 3 → [2, 1]
        3) Now, count how many numbers are in the bigger half.
            There are 3 numbers greater than 3 ([5, 6, 4]).
        4) If we want the 2nd largest number, it must be in the bigger half.
            So, we ignore the smaller numbers and the pivot and just look at [5, 6, 4].
        5) Repeat the process with [5, 6, 4]:

            Pick a pivot (say 5).
            Split into:
            Bigger than 5 → [6]
            Smaller than 5 → [4]
        6) Since the biggest number is 6 and we want the 2nd largest, the answer is 5!

        On average, it takes O(n) time, which is much faster than sorting.
        Worst case it takes O(n^2) time in case pivots are bad, but randomized pivoting mitigates this

        left=0, right=length
        k=length-k

        Idea is to get a pivot index
        is pivot index=k? we got our answer
        no?
            is pi > k then decrease right by 1
            is pi < k increase left by 1

        How to get pivot index?
            Partition:
                take arr[right] as pivot
                i = left
                j=left;j<right
                if arr[j]<=pivot
                    swap i and j in array
                    increment i
               increment j

                swap i and right
                return i


      This is also called as Hoare's Selection Algorithm  because it was invented by Tony Hoare, the same computer scientist who created QuickSort in 1960.
       He developed both algorithms while working on translation software for the Russian language.

       Hoare introduced null references in programming languages but later called it his "billion-dollar mistake" because of how many bugs and crashes it caused.

       In 1980, he won the Turing Award, the "Nobel Prize of Computing," for his work on algorithms and formal methods.
        His contributions to sorting, concurrency, and programming logic shaped modern computer science.

        In 2000, he was knighted for his services to computing, becoming Sir Tony Hoare
     */
    public static void main(String[] args) {
        int[] nums = {3, 2, 3, 1, 2, 4, 5, 5, 6};
        int k = 5;
        System.out.println("The " + k + "th largest element is: " + findKthLargest(nums, k));
    }
    public static int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }
    private static int quickSelect(int[] nums, int left, int right, int k) {
        if (left == right) return nums[left];

        int pivotIndex = partition(nums, left, right);

        if (pivotIndex == k) {
            return nums[k]; // Found the kth largest element
        } else if (pivotIndex < k) {
            return quickSelect(nums, pivotIndex + 1, right, k);
        } else {
            return quickSelect(nums, left, pivotIndex - 1, k);
        }
    }

    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[right];
        int i = left;

        for (int j = left; j < right; j++) {
            if (nums[j] <= pivot) {
                swap(nums, i, j);
                i++;
            }
        }
        swap(nums, i, right);
        return i;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
