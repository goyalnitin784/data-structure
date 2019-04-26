package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {

    public void generate(Node node, List<Node> path) {
        if (node != null) {
            List<Node> nodes = null;
            if (node.left != null) {
                nodes = new ArrayList<>(path);
                nodes.add(node.left);
                generate(node.left, nodes);
            }

            if (node.right != null) {
                nodes = new ArrayList<>(path);
                nodes.add(node.right);
                generate(node.right, nodes);
            }
        }
        if (node.left == null && node.right == null) {
            for (Object way : path) {
                System.out.print(way);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        Node node = TreeUtil.createTree();
        List<Node> path = new ArrayList<>();
        path.add(node);
        new RootToLeafPath().generate(node, path);
    }
}
