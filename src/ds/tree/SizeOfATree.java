package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class SizeOfATree {
    public int size(Node node){
        if(node==null){
            return 0;
        }

        return 1+size(node.left)+size(node.right);

    }
    public int sizeWithoutRecursion(Node node){
        if(node==null){
            return 0;
        }
        int size = 0;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            size++;
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return size;
    }
    public static void main(String[] args) {
        Node node = TreeUtil.createTree();
        int element = 6;
        System.out.println(new SizeOfATree().size(node));
        System.out.println(new SizeOfATree().sizeWithoutRecursion(node));

    }
}
