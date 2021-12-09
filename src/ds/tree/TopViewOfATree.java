package ds.tree;

import java.util.Map;
import java.util.TreeMap;

public class TopViewOfATree {
    static Map<Integer, TreeNode> map = new TreeMap<>();

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeUtil.createTree();
        TopViewOfATree.printUsingRecursion(treeNode1, 0);
    }

    public static void printUsingRecursion(TreeNode root, int level) {
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
