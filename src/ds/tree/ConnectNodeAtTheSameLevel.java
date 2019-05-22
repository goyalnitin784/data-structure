package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodeAtTheSameLevel {

    public static void main(String[] args) {
        Node node = TreeUtil.createTree();



        Queue<Node> queue = new LinkedList<>();

        Node root = node;
        queue.add(node);
        queue.add(null);

        Node prev = null;

        while (!queue.isEmpty()) {
            node = queue.poll();
            if (node == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                node.setNextRight(queue.peek());
                System.out.println(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
        }
        System.out.println();
    }

}
