package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public void traverse(TreeNode treeNode){

        if(treeNode ==null){
            return;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            treeNode = queue.poll();
            System.out.print(treeNode.data);
            if(treeNode.left!=null){
                queue.add(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.add(treeNode.right);
            }
        }

    }

    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.createTree();
        new LevelOrder().traverse(treeNode);
    }

}
