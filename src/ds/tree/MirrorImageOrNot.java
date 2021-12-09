package ds.tree;

public class MirrorImageOrNot {

    public boolean execute(TreeNode treeNode1, TreeNode treeNode2) {

        if (treeNode1 == null && treeNode2 == null) {
            return true;
        }
        if (treeNode1 != null && treeNode2 == null) {
            return false;
        }
        if (treeNode2 != null && treeNode1 == null) {
            return false;
        }
        if (treeNode1.getData() == treeNode2.getData()) {
            return true;
        }
        return execute(treeNode1.left, treeNode2.right) && execute(treeNode1.right, treeNode2.left);
    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.createTree();
        TreeNode treeNode2 = TreeUtil.createTree();

    }
}
