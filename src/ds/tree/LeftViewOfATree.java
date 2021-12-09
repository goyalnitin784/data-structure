package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LeftViewOfATree {

    static int maxLevel = 0;

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeUtil.createTree();
        LeftViewOfATree.printLeftViewUsingQueue(treeNode1);
        LeftViewOfATree.printLeftViewUsingRecursion(treeNode1,1);
    }

    public static void printLeftViewUsingRecursion(TreeNode root, int level) {
        if (root == null) {
            return;
        }
        if (maxLevel < level) {
            System.out.println(root.data);
            maxLevel = level;
        }
        printLeftViewUsingRecursion(root.left, level + 1);
        printLeftViewUsingRecursion(root.right, level + 1);
    }

    public static void printLeftViewUsingQueue(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 0;

        System.out.println(root.data);
        while (!queue.isEmpty()) {
            TreeNode treeNode = queue.poll();
            if (treeNode == null) {
                if (queue.size() != 0) {
                    System.out.println(queue.peek());
                    queue.add(null);
                    level++;
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
