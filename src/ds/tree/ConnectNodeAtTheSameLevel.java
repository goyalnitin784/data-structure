package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectNodeAtTheSameLevel {

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.createTree();



        Queue<TreeNode> queue = new LinkedList<>();

        TreeNode root = treeNode;
        queue.add(treeNode);
        queue.add(null);

        TreeNode prev = null;

        while (!queue.isEmpty()) {
            treeNode = queue.poll();
            if (treeNode == null) {
                if (!queue.isEmpty()) {
                    queue.add(null);
                }
            } else {
                treeNode.setNextRight(queue.peek());
                System.out.println(treeNode.data);
                if (treeNode.left != null) {
                    queue.add(treeNode.left);
                }
                if (treeNode.right != null) {
                    queue.add(treeNode.right);
                }

            }
        }
        System.out.println();
    }

}
