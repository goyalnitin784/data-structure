package ds.tree;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    public void traverse(Node node){

        if(node==null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()){
            node = queue.poll();
            System.out.print(node.data);
            if(node.left!=null){
                queue.add(node.left);
            }
            if(node.right!=null){
                queue.add(node.right);
            }
        }

    }

    public static void main(String[] args) {
        Node node = TreeUtil.createTree();
        new LevelOrder().traverse(node);
    }

}
