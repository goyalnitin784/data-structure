package ds.tree;

public class DiameterOfATree {

    public static int find(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return 1 + Math.max(find(treeNode.left), find(treeNode.right));
    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree();
        System.out.println(find(root));
    }

}
