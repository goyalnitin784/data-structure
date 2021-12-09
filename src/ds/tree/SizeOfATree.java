package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfATree {
    public int size(TreeNode treeNode){
        if(treeNode ==null){
            return 0;
        }

        return 1+size(treeNode.left)+size(treeNode.right);

    }
    public int sizeWithoutRecursion(TreeNode treeNode){
        if(treeNode ==null){
            return 0;
        }
        int size = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(treeNode);
        while (!queue.isEmpty()){
            treeNode = queue.poll();
            size++;
            if(treeNode.left!=null){
                queue.add(treeNode.left);
            }
            if(treeNode.right!=null){
                queue.add(treeNode.right);
            }
        }
        return size;
    }
    public static void main(String[] args) {
        TreeNode treeNode = TreeUtil.createTree();
        int element = 6;
        System.out.println(new SizeOfATree().size(treeNode));
        System.out.println(new SizeOfATree().sizeWithoutRecursion(treeNode));

    }
}
