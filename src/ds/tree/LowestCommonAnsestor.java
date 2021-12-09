package ds.tree;

import java.util.ArrayList;
import java.util.List;

public class LowestCommonAnsestor {

    public static boolean getPath(TreeNode treeNode, int value, List<TreeNode> path) {
        if (treeNode == null) {
            return false;
        }

        if (treeNode.data == value) {
            path.add(treeNode);
            return true;
        }

        if (treeNode.left != null && getPath(treeNode.left, value, path)) {
            path.add(treeNode);
            return true;
        }

        if (treeNode.right != null && getPath(treeNode.right, value, path)) {
            path.add(treeNode);
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeUtil.createTree();
        TreeNode treeNode2 = TreeUtil.createTree();
        List<TreeNode> treeNode1List = new ArrayList<>();
        List<TreeNode> treeNode2List = new ArrayList<>();
        boolean path1Bool = getPath(treeNode1, 3, treeNode1List);
        boolean path2Bool = getPath(treeNode2, 3, treeNode2List);

        int i = treeNode1List.size()-1;
        int j = treeNode2List.size()-1;

        if (path1Bool && path2Bool) {
            while (i >= 0 && j >= 0) {
                if (treeNode1List.get(i).getData() == treeNode2List.get(j).getData()) {
                    System.out.println(treeNode1List.get(i).data);
                }
                i--;
                j--;
            }
        }
    }
}
