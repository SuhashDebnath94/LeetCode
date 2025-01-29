package bitManipulation;

public class N13_CountingBits {
//    Given an integer n, return an array ans whose length is n+1 such that
//        for each i (0 <= i <= n) ans[i] is the number of 1’s in binary representation of i.

    public static void main(String args[]) {
        int n = 5;
        int ans[] = countingSetBitsPrac(n);
        for (int val : ans)
            System.out.print(val + " ");
    }

//    T: O(NlogN)
    private static int[] countingSetBitsPrac(int n) {
        int[] arr = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int num = i;
            int sum = 0;
            while (num > 0) {
                if ((num & 1) == 1) sum++;
                num = num >> 1;
            }

            arr[i] = sum;

        }
        return arr;
    }


}
