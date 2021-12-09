package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPath {

    public void generate(TreeNode treeNode, List<TreeNode> path) {
        if (treeNode != null) {
            List<TreeNode> treeNodes = null;
            if (treeNode.left != null) {
                treeNodes = new ArrayList<>(path);
                treeNodes.add(treeNode.left);
                generate(treeNode.left, treeNodes);
            }

            if (treeNode.right != null) {
                treeNodes = new ArrayList<>(path);
                treeNodes.add(treeNode.right);
                generate(treeNode.right, treeNodes);
            }
        }
        if (treeNode.left == null && treeNode.right == null) {
            for (Object way : path) {
                System.out.print(way);
            }
            System.out.println();
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.createTree();
        List<TreeNode> path = new ArrayList<>();
        path.add(treeNode);
        new RootToLeafPath().generate(treeNode, path);
    }
}
