package blind75.tree;

public class BTreeMaximumPathSum {
    public static int maxPathSum(Node root) {
        int maxValue[] = new int[1];
        maxValue[0] = Integer.MIN_VALUE;
        maxPathDown(root, maxValue);
        return maxValue[0];
    }

    public static int maxPathDown(Node node, int maxValue[]) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left, maxValue)); //get max of left path
        int right = Math.max(0, maxPathDown(node.right, maxValue)); //get max of right path
        maxValue[0] = Math.max(maxValue[0], left + right + node.data); //get max of current max and path
        return Math.max(left, right) + node.data; //return the max of left or right and current node data
    }

    public static void main(String args[]) {

        Node root = new Node(-10);
        root.left = new Node(9);
        root.right = new Node(20);
        root.right.left = new Node(15);
        root.right.right = new Node(7);

        int answer = maxPathSum(root);
        System.out.println("The Max Path Sum for this tree is " + answer);

    }
}
