package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class PathWithASum {

    static int finalSum = 5;

    public static void drawPath(TreeNode treeNode, List<TreeNode> path) {


        if (treeNode == null) {
            return;
        }
        path.add(treeNode);
        drawPath(treeNode.left, path);
        drawPath(treeNode.right, path);
        int sum = 0;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum += path.get(i).data;
            if (sum == finalSum) {
                System.out.println(path.subList(i,path.size()).toString());
            }
        }
        path.remove(treeNode);
    }


    public static void main(String[] args) {
        TreeNode root = TreeUtil.createTreeForK();
        PathWithASum.drawPath(root, new ArrayList<>());

    }
}
