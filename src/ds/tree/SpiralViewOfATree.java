package ds.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class SpiralViewOfATree {

    public static void main(String[] args) {
        Node node1 = TreeUtil.createTree();
        SpiralViewOfATree.print(node1);
    }

    public static void print(Node root) {
        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();

        stack1.add(root);

        while (!stack1.isEmpty() && !stack2.isEmpty()) {

            while (!stack1.isEmpty()) {
                Node node = stack1.pop();
                System.out.println(node.data);
                if (node.left != null) {
                    stack2.push(node.left);
                }
                if (node.right != null) {
                    stack2.push(node.right);
                }
            }

            while (!stack2.isEmpty()) {
                Node node = stack1.pop();
                System.out.println(node.data);
                if (node.right != null) {
                    stack1.push(node.right);
                }
                if (node.left != null) {
                    stack1.push(node.left);
                }
            }
        }
    }
}
