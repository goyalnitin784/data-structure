package ds.tree;

public class MirroImage {

    void createImage(Node node){
        if(node==null){
            return;
        }
        createImage(node.left);
        createImage(node.right);
        Node temp = node.left;
        node.left = node.right;
        node.right = temp;

    }
    public static void main(String[] args) {
            Node node = TreeUtil.createTree();
            new LevelOrder().traverse(node);
            System.out.println();
            new MirroImage().createImage(node);
            new LevelOrder().traverse(node);
    }
}
