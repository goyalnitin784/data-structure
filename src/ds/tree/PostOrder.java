package ds.tree;

public class PostOrder {

    public void traverseWithRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseWithRecursion(root.getLeft());
        traverseWithRecursion(root.getRight());
        System.out.println(root.data);
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree();
        new PostOrder().traverseWithRecursion(root);
        new PostOrder().traverseWithoutRecursion(root);
    }

    public void traverseWithoutRecursion(TreeNode treeNode) {

    }
}
