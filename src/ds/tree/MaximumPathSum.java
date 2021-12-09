package ds.tree;

public class MaximumPathSum {

    int maxSum = 0;

    public static int getMaxSum(TreeNode treeNode) {

        if (treeNode == null) {
            return 0;
        }

        int maxLeft = -1;
        int maxRight = -1;

        maxLeft = treeNode.data + getMaxSum(treeNode.left);
        maxRight = treeNode.data + getMaxSum(treeNode.right);

        if (maxLeft > maxRight) {
            return maxLeft;
        } else {
            return maxRight;
        }
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree();
        System.out.println(getMaxSum(root));
    }
}
