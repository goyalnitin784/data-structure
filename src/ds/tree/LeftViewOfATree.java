package ds.tree;

import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class LeftViewOfATree {

    static int maxLevel = 0;

    public static void main(String[] args) {
        Node node1 = TreeUtil.createTree();
        LeftViewOfATree.printLeftViewUsingQueue(node1);
        LeftViewOfATree.printLeftViewUsingRecursion(node1,1);
    }

    public static void printLeftViewUsingRecursion(Node root, int level) {
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

    public static void printLeftViewUsingQueue(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        queue.add(null);
        int level = 0;

        System.out.println(root.data);
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (node == null) {
                if (queue.size() != 0) {
                    System.out.println(queue.peek());
                    queue.add(null);
                    level++;
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
