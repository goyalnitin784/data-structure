package ds.tree;

import java.util.Map;
import java.util.TreeMap;

public class TopViewOfATree {
    static Map<Integer, Node> map = new TreeMap<>();

    public static void main(String[] args) {
        Node node1 = TreeUtil.createTree();
        TopViewOfATree.printUsingRecursion(node1, 0);
    }

    public static void printUsingRecursion(Node root, int level) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(level)) {
            map.put(level, root);
        }

        if (root.left != null) {
            printUsingRecursion(root.left, level - 1);
        }
        if (root.right != null) {
            printUsingRecursion(root.right, level + 1);
        }


    }
}
