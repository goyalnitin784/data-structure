package ds.tree;

public class HeightOfATree {


    public static int height(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        if (treeNode.left == null && treeNode.right == null) {
            return 1;
        }
        int heightLeft = -1;
        int heightRight = -1;
        if (treeNode.left != null) {
            heightLeft = 1 + height(treeNode.left);
        }

        if (treeNode.right != null) {
            heightRight = 1 + height(treeNode.right);
        }

        if (heightLeft > heightRight) {
            return heightLeft;
        } else {
            return heightRight;
        }
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.createTree();
        int height = height(treeNode);

    }
}
