package ds.tree;

import java.util.Stack;

public class PreOrder {

    public void traverseWithRecursion(TreeNode root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        traverseWithRecursion(root.getLeft());
        traverseWithRecursion(root.getRight());
    }

    public void traverseWithoutRecursion(TreeNode treeNode) {
        Stack<TreeNode> treeNodes = new Stack<>();
        while(true){
            if(treeNode !=null){
                System.out.println(treeNode.data);
                treeNodes.push(treeNode);
            }
            if(treeNodes.isEmpty()){
                break;
            }
            treeNode = treeNodes.pop();
            treeNode = treeNode.right;
        }
    }


    public static void main(String[] args) {
        TreeNode root =  TreeUtil.createTree();
        new PreOrder().traverseWithRecursion(root);
        new PreOrder().traverseWithoutRecursion(root);
    }
}
