package BinaryTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class N07_BoundaryTraversal {
    /*
    Given a Binary Tree, find its Boundary Traversal. The traversal should be in the following order:


        Left boundary nodes: defined as the path from the root to the left-most node ie- the leaf node you could reach when you always travel preferring the left subtree over the right subtree.
        Leaf nodes: All the leaf nodes except for the ones that are part of left or right boundary.
        Reverse right boundary nodes: defined as the path from the right-most node to the root. The right-most node is the leaf node you could reach when you always travel preferring the right subtree over the left subtree. Exclude the root from this as it was already included in the traversal of left boundary nodes.
        Note: If the root doesn't have a left subtree or right subtree, then the root itself is the left or right boundary.

             Input:
                1
               / \
              2   3
             / \   \
            4   5   6
               / \
              7   8

        Output:
        [1, 2, 4, 7, 8, 6, 3]

    🔹 Traversal Order:
    ✅ Left Boundary → [1, 2, 4]
    ✅ Leaf Nodes → [7, 8, 6]
    ✅ Right Boundary (Reversed) → [3]

     */

    /**
     * One naive way would be:
     * 1️⃣ Store all left boundary nodes.
     * 2️⃣ Collect all leaf nodes separately.
     * 3️⃣ Store all right boundary nodes, then reverse them before adding to the result.
     *
     * 🚨 Why is this bad?
     *
     * Requires multiple extra lists.
     * Unnecessary extra storage.
     * We can do it all in a single traversal!
     * ⏳ Time Complexity: O(n) ✅
     * 📦 Space Complexity: O(n) ❌ (Extra lists used)
     *
     * 💡 Optimal Approach:
     *      We can traverse the tree efficiently in one go:
     *
             * 1️⃣ Left Boundary Traversal:
             *
             * Go left whenever possible.
             * If no left child, go right.
             * Stop when hitting a leaf node.
             * 2️⃣ Leaf Node Collection:
             *
             * Check both left and right subtrees.
             * Add only leaf nodes to the result.
             * 3️⃣ Right Boundary Traversal (Reverse Order):
             *
             * Go right whenever possible.
             * If no right child, go left.
             * Stop when hitting a leaf node.
             * Store nodes in a list and reverse them at the end.
             * ⏳ Time Complexity: O(n) ✅ (Each node visited once)
             * 📦 Space Complexity: O(h) ✅ (Recursive stack, where h = tree height)
             */
    public static List<Integer> boundaryTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // Add root (special case)
        result.add(root.val);

        // Get left boundary (excluding leaf nodes)
        getLeftBoundary(root.left, result);

        // Get leaf nodes
        getLeafNodes(root, result);

        // Get right boundary (excluding root and leaf nodes)
        List<Integer> rightBoundary = new ArrayList<>();
        getRightBoundary(root.right, rightBoundary);
        Collections.reverse(rightBoundary);
        result.addAll(rightBoundary);

        return result;
    }

    private static void getLeftBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.val);
            node = (node.left != null) ? node.left : node.right;
        }
    }

    private static void getLeafNodes(TreeNode node, List<Integer> result) {
        if (node == null) return;
        if (isLeaf(node)) {
            result.add(node.val);
            return;
        }
        getLeafNodes(node.left, result);
        getLeafNodes(node.right, result);
    }

    private static void getRightBoundary(TreeNode node, List<Integer> result) {
        while (node != null) {
            if (!isLeaf(node)) result.add(node.val);
            node = (node.right != null) ? node.right : node.left;
        }
    }

    private static boolean isLeaf(TreeNode node) {
        return (node.left == null && node.right == null);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.right = new TreeNode(6);

        System.out.println(boundaryTraversal(root));
        // Output: [1, 2, 4, 7, 8, 6, 3]
    }



}
