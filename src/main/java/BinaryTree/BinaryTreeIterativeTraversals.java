package BinaryTree;

import java.util.Stack;

// Define the Binary Tree Node class

public class BinaryTreeIterativeTraversals {

    // Root of the tree
    TreeNode root;

    // Iterative preorder traversal method
    void iterativePreorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // Create a stack to store nodes
        Stack<TreeNode> stack = new Stack<>();

        // Push the root node onto the stack
        stack.push(root);

        // Loop until the stack is empty
        while (!stack.isEmpty()) {
            // Pop the node from the stack
            TreeNode currentNode = stack.pop();

            // Print the value of the node (root)
            System.out.print(currentNode.val + " ");

            // Push the right child first (if it exists) onto the stack
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }

            // Push the left child (if it exists) onto the stack
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }
    void iterativeInorderTraversal(TreeNode root) {
        // Create a stack to simulate the recursive call stack
        Stack<TreeNode> stack = new Stack<>();
        TreeNode currentNode = root;

        // Traverse the tree
        while (currentNode != null || !stack.isEmpty()) {
            // Reach the leftmost node of the current node
            while (currentNode != null) {
                stack.push(currentNode);
                currentNode = currentNode.left;
            }

            // Current node must be null, so pop the top of the stack
            currentNode = stack.pop();

            // Print the value of the node (root)
            System.out.print(currentNode.val + " ");

            // Move to the right subtree
            currentNode = currentNode.right;
        }
    }

    // Iterative postorder traversal method
    void iterativePostorderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // Create two stacks to simulate the postorder traversal
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        // Push the root to stack1
        stack1.push(root);

        // Process all nodes in stack1
        while (!stack1.isEmpty()) {
            // Pop from stack1 and push to stack2
            TreeNode currentNode = stack1.pop();
            stack2.push(currentNode);

            // Push the left and right children of the popped node to stack1
            if (currentNode.left != null) {
                stack1.push(currentNode.left);
            }
            if (currentNode.right != null) {
                stack1.push(currentNode.right);
            }
        }

        // Now, pop all nodes from stack2 and print their values
        while (!stack2.isEmpty()) {
            TreeNode node = stack2.pop();
            System.out.print(node.val + " ");
        }
    }

    // Driver method to test the iterative preorder traversal
    public static void main(String[] args) {
        BinaryTreeIterativeTraversals tree = new BinaryTreeIterativeTraversals();

        // Creating a sample tree
        tree.root = new TreeNode(1);
        tree.root.left = new TreeNode(2);
        tree.root.right = new TreeNode(3);
        tree.root.left.left = new TreeNode(4);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.left = new TreeNode(6);
        tree.root.right.right = new TreeNode(7);

        // Perform iterative preorder traversal
        System.out.println("Iterative Preorder Traversal:");
        tree.iterativePreorderTraversal(tree.root);
        System.out.println();
        System.out.println("Iterative Inorder Traversal:");
        tree.iterativeInorderTraversal(tree.root);
        System.out.println();
        System.out.println("Iterative postorder Traversal:");
        tree.iterativePostorderTraversal(tree.root);
    }
}
