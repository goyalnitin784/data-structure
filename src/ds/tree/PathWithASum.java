package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class PathWithASum {

    static int finalSum = 5;

    public static void drawPath(Node node, List<Node> path) {


        if (node == null) {
            return;
        }
        path.add(node);
        drawPath(node.left, path);
        drawPath(node.right, path);
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i).data;
            if (sum == finalSum) {
                System.out.println(path.subList(i,path.size()).toString());
            }
        }
        path.remove(node);
    }


    public static void main(String[] args) {
        Node root = TreeUtil.createTreeForK();
        PathWithASum.drawPath(root, new ArrayList<>());

    }
}
