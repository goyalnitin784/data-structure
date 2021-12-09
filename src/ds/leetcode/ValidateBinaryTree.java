package ds.leetcode;

import java.util.Stack;

public class ValidateBinaryTree {

  public boolean isValidBST(TreeNode root) {
    return util(root, Long.MIN_VALUE, Long.MAX_VALUE);
  }

  public boolean util(TreeNode node, long min, long max) {
    if (node == null) {
      return true;
    }
    if (node.val < min || node.val > max) {
      return false;
    }
    return util(node.left, min, node.val - 1) && util(node.right, node.val + 1, max);
  }


  public boolean utilUsingInorderTraversal(TreeNode treeNode) {
    Stack<TreeNode> treeNodes = new Stack<>();
    long value = -Long.MAX_VALUE;
    while (!treeNodes.isEmpty() || treeNode == null) {
      while (treeNode != null) {
        treeNodes.push(treeNode);
        treeNode = treeNode.left;
      }
      TreeNode node = treeNodes.pop();
      if (node.val <= value) {
        return false;
      }
      value = node.val;
      treeNode = node.right;
    }
    return true;
  }
}


class TreeNode {

  int val;
  TreeNode left;
  TreeNode right;

  TreeNode(int x) {
    val = x;
  }
}
