package blind75.heap;

import java.util.*;

public class KfrequentElements {
    //    Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 2, 2, 3};
        int[] res= topKfrequent(nums, 2);

        for(int i=0; i<res.length;i++){
            System.out.print(" "+res[i]+" ");
        }
        System.out.println();
    }

    private static int[] topKfrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> Integer.compare(a[1], b[1]));
        for (Map.Entry<Integer, Integer> e : map.entrySet()) {
            pq.add(new int[]{e.getKey(), e.getValue()});
            while (pq.size() > k) {
                pq.poll();
            }
        }

        int[] result = new int[k];
        for (int i = 0; i < k; i++) {
            result[i] = pq.poll()[0];
        }

        return result;

    }
}
