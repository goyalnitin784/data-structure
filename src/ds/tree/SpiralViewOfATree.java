package ds.tree;

import java.util.Stack;

public class SpiralViewOfATree {

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeUtil.createTree();
        SpiralViewOfATree.print(treeNode1);
    }

    public static void print(TreeNode root) {
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();

        stack1.add(root);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                TreeNode treeNode = stack1.pop();
                System.out.println(treeNode.data);
                if (treeNode.left != null) {
                    stack2.push(treeNode.left);
                }
                if (treeNode.right != null) {
                    stack2.push(treeNode.right);
                }
            }

            while (!stack2.isEmpty()) {
                TreeNode treeNode = stack1.pop();
                System.out.println(treeNode.data);
                if (treeNode.right != null) {
                    stack1.push(treeNode.right);
                }
                if (treeNode.left != null) {
                    stack1.push(treeNode.left);
                }
            }
        }
    }
}
