package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class FindElementInATree {

    public Node find(Node node,int element){
        if(node==null){
            return null;
        }
        if(node.data==element){
            return node;
        }
        Node nodeLeft = find(node.left,element);
        Node nodeRight  = find(node.right,element);
        if(nodeLeft!=null){
            return nodeLeft;
        }
        if(nodeRight!=null){
            return nodeRight;
        }
        return null;
    }
    public Node findWithoutRecursion(Node node,int element){
        if(node==null){
            return null;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            if(node.data==element){
                return node;
            }
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return null;
    }
    public static void main(String[] args) {
        Node node = TreeUtil.createTree();
        int element = 6;
        System.out.println(new FindElementInATree().find(node,element));
        System.out.println(new FindElementInATree().findWithoutRecursion(node,element));

    }
}
