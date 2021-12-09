package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindElementInATree {

    public TreeNode find(TreeNode treeNode,int element){
        if(treeNode ==null){
            return null;
        }
        if(treeNode.data==element){
            return treeNode;
        }
        TreeNode treeNodeLeft = find(treeNode.left,element);
        TreeNode treeNodeRight = find(treeNode.right,element);
        if(treeNodeLeft !=null){
            return treeNodeLeft;
        }
        if(treeNodeRight !=null){
            return treeNodeRight;
        }
        return null;
    }
    public TreeNode findWithoutRecursion(TreeNode treeNode,int element){
        if(treeNode ==null){
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            treeNode = queue.poll();
            if(treeNode.data==element){
                return treeNode;
            }
            if(treeNode.left!=null){
                queue.add(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.add(treeNode.right);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.createTree();
        int element = 6;
        System.out.println(new FindElementInATree().find(treeNode,element));
        System.out.println(new FindElementInATree().findWithoutRecursion(treeNode,element));

    }
}
