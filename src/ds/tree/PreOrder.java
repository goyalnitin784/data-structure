package ds.tree;

import java.util.Stack;

public class PreOrder {

    public void traverseWithRecursion(Node root){
        if(root==null){
            return;
        }
        System.out.println(root.data);
        traverseWithRecursion(root.getLeft());
        traverseWithRecursion(root.getRight());
    }

    public void traverseWithoutRecursion(Node node) {
        Stack<Node> nodes = new Stack<>();
        while(true){
            if(node!=null){
                System.out.println(node.data);
                nodes.push(node);
            }
            if(nodes.isEmpty()){
                break;
            }
            node=nodes.pop();
            node = node.right;
        }
    }


    public static void main(String[] args) {
        Node root =  TreeUtil.createTree();
        new PreOrder().traverseWithRecursion(root);
        new PreOrder().traverseWithoutRecursion(root);
    }
}
