package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfATree {

    static int maxLevel = 0;

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeUtil.createTree();
        RightViewOfATree.printUsingQueue(treeNode1);
        RightViewOfATree.printUsingRecursion(treeNode1, 1);
    }

    public static void printUsingRecursion(TreeNode root, int level) {

        if (root == null) {
            return;
        }

        if (maxLevel < level) {
            System.out.println(root.data);
            maxLevel = level;
        }

        if (root.right != null) {
            printUsingRecursion(root.right, level + 1);
        }
        if (root.left != null) {
            printUsingRecursion(root.left, level + 1);
        }
    }

    public static void printUsingQueue(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        System.out.println(root.data);

        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (queue.size() > 0 && queue.peek() == null) {
                System.out.println(treeNode.data);
            }
            if (treeNode == null) {
                if (queue.size() > 0) {
                    queue.add(null);
                }
            } else {
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }
            }
        }
    }

}
