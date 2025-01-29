package BinaryTree;

public class N03_FindDiameterOfBinaryTree {
    /*
    Diameter is the longest path between any 2 nodes in a binary tree, it might or might not pass through the root
    NAive way:
        Find the lh + rh of each node, and the max of this value will be the diameter

     */
    // Class-level variable to store the diameter
    private static int diameter;

    // Helper method to calculate height and update diameter
    private static int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        // Update the diameter (maximum diameter found so far)
        diameter = Math.max(diameter, leftHeight + rightHeight);

        // Return height of the current subtree
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // Method to find the diameter of the binary tree
    public static int findDiameter(TreeNode root) {
        diameter = 0; // Initialize diameter to 0
        height(root); // Calculate height and update diameter
        return diameter;
    }

    public static void main(String[] args) {
        // Example binary tree
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(8);

        System.out.println("The diameter of the binary tree is: " + findDiameter(root));
    }

    }
