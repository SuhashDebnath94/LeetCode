package BinaryTree;

public class N01_FindMaximumDepthOfBinaryTree {
    public static void main(String[] args) {
        BinaryTreeRecursiveTraversals tree = new BinaryTreeRecursiveTraversals();

        // Creating a sample tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        // Perform preorder traversal
        System.out.println("Maximum depth:");
        System.out.println(maximumDepth(tree.root));
        
    }

    private static int maximumDepth(TreeNode root) {
        /*
        We will use 1+ max(left, right)
        T(C) -> O(n)
        SC -> O(n)
         */
        if(root==null) return 0;
        int leftHeight=maximumDepth(root.left);
        int rightHeight=maximumDepth(root.right);
        return 1+Math.max(leftHeight, rightHeight);
    }
}
