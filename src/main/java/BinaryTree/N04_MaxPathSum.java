package BinaryTree;

public class N04_MaxPathSum {
    // Variable to store the maximum path sum
    private static int maxSum;

    // Helper function to calculate the maximum gain at each node
    private static int maxGain(TreeNode node) {
        if (node == null) {
            return 0; // Base case: no contribution from a null node
        }

        // Recursively calculate the maximum gain from left and right subtrees
        int leftGain = Math.max(maxGain(node.left), 0); // Ignore negative contributions
        int rightGain = Math.max(maxGain(node.right), 0); // Ignore negative contributions

        // Calculate the path sum that includes the current node as the highest node
        int currentPathSum = node.val + leftGain + rightGain;

        // Update the global maximum path sum if the current path sum is greater
        maxSum = Math.max(maxSum, currentPathSum);

        // Return the maximum gain to continue the path
        return node.val + Math.max(leftGain, rightGain);
    }

    // Method to find the maximum path sum in the binary tree
    public static int findMaxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE; // Initialize to the smallest possible value
        maxGain(root); // Start the recursive calculation
        return maxSum;
    }

    public static void main(String[] args) {
        // Example binary tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(1);
        root.right.right = new TreeNode(-25);
        root.right.right.left = new TreeNode(3);
        root.right.right.right = new TreeNode(4);

        System.out.println("The maximum path sum is: " + findMaxPathSum(root));
    }

}
