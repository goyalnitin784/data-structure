package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class MaximuxElementInTree {

    public int findMax(Node node){
        if(node==null){
            return -1;
        }
        int tempMax = node.data;
        int leftMax = findMax(node.left);
        int rightMax  = findMax(node.right);
        if(leftMax>tempMax){
            tempMax = leftMax;
        }
        if(rightMax>tempMax){
            tempMax = rightMax;
        }
        return tempMax;
    }
    public int findMaxWithoutRecursion(Node node){
        if(node==null){
            return -1;
        }
        int max = -1;
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            if(node.data>max){
                max = node.data;
            }
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }
        return max;
    }
    public static void main(String[] args) {
        Node node = TreeUtil.createTree();
        System.out.println(new MaximuxElementInTree().findMax(node));
        System.out.println(new MaximuxElementInTree().findMaxWithoutRecursion(node));

    }
}
