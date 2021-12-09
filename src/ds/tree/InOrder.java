package ds.tree;

import java.util.Stack;

public class InOrder {

    public void traverseWithRecursion(TreeNode root) {
        if (root == null) {
            return;
        }
        traverseWithRecursion(root.getLeft());
        System.out.println(root.data);
        traverseWithRecursion(root.getRight());
    }

    public void traverseWithoutRecursion(TreeNode treeNode) {
        Stack<TreeNode> treeNodes = new Stack<>();
        while (true) {
            while (treeNode != null) {
                treeNodes.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = treeNodes.pop();
            System.out.println(treeNode.data);

            if (treeNodes.isEmpty()) {
                break;
            }
            if (treeNode.right != null) {
                treeNode = treeNode.right;
            }
        }

    }

    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTree();
        new InOrder().traverseWithRecursion(root);
        new InOrder().traverseWithoutRecursion(root);
    }
}
