package ds.tree;

import java.util.Stack;

public class InOrder {

    public void traverseWithRecursion(Node root) {
        if (root == null) {
            return;
        }
        traverseWithRecursion(root.getLeft());
        System.out.println(root.data);
        traverseWithRecursion(root.getRight());
    }

    public void traverseWithoutRecursion(Node node) {
        Stack<Node> nodes = new Stack<>();
        while (true) {
            while (node != null) {
                nodes.push(node);
                node = node.left;
            }
            node = nodes.pop();
            System.out.println(node.data);

            if (nodes.isEmpty()) {
                break;
            }
            if (node.right != null) {
                node = node.right;
            }
        }

    }

    public static void main(String[] args) {
        Node root = TreeUtil.createTree();
        new InOrder().traverseWithRecursion(root);
        new InOrder().traverseWithoutRecursion(root);
    }
}
