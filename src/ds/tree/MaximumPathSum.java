package ds.tree;

public class MaximumPathSum {

    int maxSum = 0;

    public static int getMaxSum(Node node) {

        if (node == null) {
            return 0;
        }

        int maxLeft = -1;
        int maxRight = -1;

        maxLeft = node.data + getMaxSum(node.left);
        maxRight = node.data + getMaxSum(node.right);

        if (maxLeft > maxRight) {
            return maxLeft;
        } else {
            return maxRight;
        }
    }

    public static void main(String[] args) {
        Node root = TreeUtil.createTree();
        System.out.println(getMaxSum(root));
    }
}
