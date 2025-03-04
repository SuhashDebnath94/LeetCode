package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class N06_ZigZagTraversal {
    /*
    Given the root of a binary tree, return the zigzag level order traversal of its nodes' values. (i.e., from left to right,
    then right to left for the next level and alternate between).
     */

    /**
     Instead of reversing levels after traversal, we modify our queue processing to handle it while traversing.

     1️⃣ Use a Queue (like BFS).
     2️⃣ Use a boolean flag (leftToRight) to track direction.
     3️⃣ At each level, process nodes normally, but add them in reverse order if needed.
     4️⃣ Toggle leftToRight after processing each level.

     🚀 Why is this better?

     No extra reversals needed.
     Single pass per level.
     ⏳ Time Complexity: O(n) ✅ (Each node visited once)
     📦 Space Complexity: O(n) ✅ (Storing results)
     */
    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) return result;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean leftToRight = true; // Track zigzag direction

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            LinkedList<Integer> levelList = new LinkedList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();

                // Add elements in zigzag order
                if (leftToRight) {
                    levelList.addLast(current.val);
                } else {
                    levelList.addFirst(current.val);
                }

                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }

            result.add(levelList);
            leftToRight = !leftToRight; // Toggle direction
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(zigzagLevelOrder(root));
        // Output: [[1], [3, 2], [4, 5, 6]]
    }
}
