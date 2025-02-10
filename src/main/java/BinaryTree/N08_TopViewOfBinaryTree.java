package BinaryTree;

import java.util.*;

public class N08_TopViewOfBinaryTree {
    /*

        Given the root of a binary tree, return the top view of its nodes' values. Assume the left and right child of a node makes a 45–degree angle with the parent.

        Input:
                   1
                 /	 \
                /	  \
               2	   3
                     /   \
                    /	  \
                   5	   6
                 /   \
                /	  \
               7	   8

        Output: [2, 1, 3, 6]

        Input:

              1
            /   \
           /	 \
          2		  3
           \
            \
             4
              \
               \
                5

        Output: [2, 1, 3]

        How did we get this?
        Column -1 → 2 (First node in this column)
        Column 0 → 1 (First node in this column)
        Column 1 → 3 (First node in this column)
        Column 2 → 6 (First node in this column)

        💡 Optimal Approach: "BFS with a Map"
        We use Breadth-First Search (BFS) but store only the first encountered node in each column!

        1️⃣ Use a TreeMap (Sorted Map) to store only the first node for each column index.
        2️⃣ Use a Queue to perform level-order traversal (BFS).
        3️⃣ Store each node’s column index and track the first node encountered in that column.

        ⏳ Time Complexity: O(n) ✅ (Single traversal)
        📦 Space Complexity: O(n) ✅ (Only necessary storage used)


*/
    static class NodeInfo {
        TreeNode node;
        int col;

        NodeInfo(TreeNode node, int col) {
            this.node = node;
            this.col = col;
        }
    }

    public static List<Integer> topView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap stores only first seen node in each column
        TreeMap<Integer, Integer> columnMap = new TreeMap<>();

        // BFS Queue (Node, column index)
        Queue<NodeInfo> queue = new LinkedList<>();
        queue.add(new NodeInfo(root, 0));

        while (!queue.isEmpty()) {
            NodeInfo curr = queue.poll();

            // If column is seen for the first time, add it
            columnMap.putIfAbsent(curr.col, curr.node.val);

            if (curr.node.left != null)
                queue.add(new NodeInfo(curr.node.left, curr.col - 1));

            if (curr.node.right != null)
                queue.add(new NodeInfo(curr.node.right, curr.col + 1));
        }

        // Extract top view nodes from TreeMap
        for (int val : columnMap.values()) {
            result.add(val);
        }

        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);

        System.out.println(topView(root));
        // Output: [2, 1, 3, 6]
    }


}
