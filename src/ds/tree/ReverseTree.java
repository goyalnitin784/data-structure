package ds.tree;

public class ReverseTree {

  public static void main(String[] args) {
    TreeNode treeNode = TreeUtil.createTree();
    new ReverseTree().invertTree(treeNode);
    System.out.println();
  }

  public TreeNode invertTree(TreeNode root) {

    if (root == null || (root.left == null && root.right == null)) {
      return root;
    }
    invertTree(root.left);
    invertTree(root.right);
    TreeNode treeNode = root.left;
    root.left = root.right;
    root.right = treeNode;
    return root;
  }
}
