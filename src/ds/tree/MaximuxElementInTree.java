package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximuxElementInTree {

    public int findMax(TreeNode treeNode){
        if(treeNode ==null){
            return -1;
        }
        int tempMax = treeNode.data;
        int leftMax = findMax(treeNode.left);
        int rightMax  = findMax(treeNode.right);
        if(leftMax>tempMax){
            tempMax = leftMax;
        }
        if(rightMax>tempMax){
            tempMax = rightMax;
        }
        return tempMax;
    }
    public int findMaxWithoutRecursion(TreeNode treeNode){
        if(treeNode ==null){
            return -1;
        }
        int max = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            treeNode = queue.poll();
            if(treeNode.data>max){
                max = treeNode.data;
            }
            if(treeNode.left!=null){
                queue.add(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.add(treeNode.right);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.createTree();
        System.out.println(new MaximuxElementInTree().findMax(treeNode));
        System.out.println(new MaximuxElementInTree().findMaxWithoutRecursion(treeNode));

    }
}
