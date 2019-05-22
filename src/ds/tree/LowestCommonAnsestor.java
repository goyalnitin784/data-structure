package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAnsestor {

    public static boolean getPath(Node node, int value, List<Node> path) {
        if (node == null) {
            return false;
        }

        if (node.data == value) {
            path.add(node);
            return true;
        }

        if (node.left != null && getPath(node.left, value, path)) {
            path.add(node);
            return true;
        }

        if (node.right != null && getPath(node.right, value, path)) {
            path.add(node);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node node1 = TreeUtil.createTree();
        Node node2 = TreeUtil.createTree();
        List<Node> node1List = new ArrayList<>();
        List<Node> node2List = new ArrayList<>();
        boolean path1Bool = getPath(node1, 3, node1List);
        boolean path2Bool = getPath(node2, 3, node2List);

        int i = node1List.size()-1;
        int j = node2List.size()-1;

        if (path1Bool && path2Bool) {
            while (i >= 0 && j >= 0) {
                if (node1List.get(i).getData() == node2List.get(j).getData()) {
                    System.out.println(node1List.get(i).data);
                }
                i--;
                j--;
            }
        }
    }
}
