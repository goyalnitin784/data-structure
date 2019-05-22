package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class RightViewOfATree {

    static int maxLevel = 0;

    public static void main(String[] args) {
        Node node1 = TreeUtil.createTree();
        RightViewOfATree.printUsingQueue(node1);
        RightViewOfATree.printUsingRecursion(node1, 1);
    }

    public static void printUsingRecursion(Node root, int level) {

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

    public static void printUsingQueue(Node root) {
        if (root == null) {
            return;
        }
        Queue<Node> queue = new LinkedList<>();

        queue.add(root);
        queue.add(null);
        System.out.println(root.data);

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (queue.size() > 0 && queue.peek() == null) {
                System.out.println(node.data);
            }
            if (node == null) {
                if (queue.size() > 0) {
                    queue.add(null);
                }
            } else {
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
    }

}
