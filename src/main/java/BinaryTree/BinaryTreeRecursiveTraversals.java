package BinaryTree;


import java.util.LinkedList;
import java.util.Queue;

// Define the Binary Tree Node class
public class BinaryTreeRecursiveTraversals {

    // Root of the tree
    TreeNode root;

    // Preorder traversal method
    void preorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // First print the node value (root)
        System.out.print(node.val + " ");

        // Then recurse on the left subtree
        preorderTraversal(node.left);

        // Then recurse on the right subtree
        preorderTraversal(node.right);
    }
    void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // First recurse on the left subtree
        inorderTraversal(node.left);

        // Then print the node value (root)
        System.out.print(node.val + " ");

        // Then recurse on the right subtree
        inorderTraversal(node.right);
    }
    void postorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        // First recurse on the left subtree
        postorderTraversal(node.left);


        // Then recurse on the right subtree
        postorderTraversal(node.right);
        // Then print the node value (root)
        System.out.print(node.val + " ");
    }

    void levelOrderTraversal(TreeNode root) {
        if (root == null) {
            return;
        }

        // Create a queue for level order traversal
        Queue<TreeNode> queue = new LinkedList<>();

        // Add the root to the queue
        queue.add(root);

        while (!queue.isEmpty()) {
            // Get the front node from the queue
            TreeNode currentNode = queue.poll();

            // Print the value of the node
            System.out.print(currentNode.val + " ");

            // If the left child exists, add it to the queue
            if (currentNode.left != null) {
                queue.add(currentNode.left);
            }

            // If the right child exists, add it to the queue
            if (currentNode.right != null) {
                queue.add(currentNode.right);
            }
        }
    }

    // Driver method to test the preorder traversal
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
        System.out.println("Preorder Traversal:");
        tree.preorderTraversal(tree.root);
        System.out.println();
        System.out.println("Inorder Traversal:");
        tree.inorderTraversal(tree.root);
        System.out.println();
        System.out.println("Postorder Traversal:");
        tree.postorderTraversal(tree.root);
        System.out.println();
        System.out.println("Level order Traversal:");
        tree.levelOrderTraversal(tree.root);
    }
}

