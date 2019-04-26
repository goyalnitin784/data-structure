package ds.tree;

public class TreeUtil {

    public static Node createTree(){

        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(7));
        return root;

    }

    public static Node createTreeForK(){

        Node root = new Node(1);
        root.setLeft(new Node(3));
        root.setRight(new Node(-1));
        root.getLeft().setLeft(new Node(2));
        root.getLeft().setRight(new Node(1));
        root.getRight().setLeft(new Node(4));
        root.getRight().setRight(new Node(5));
        root.left.right.setLeft(new Node(1));
        root.right.left.setLeft(new Node(1));
        root.right.left.setRight(new Node(2));
        root.right.right.setRight(new Node(6));
        return root;

    }
    public static Node createTree2(){

        Node root = new Node(1);
        root.setLeft(new Node(2));
        root.setRight(new Node(3));
        root.getLeft().setLeft(new Node(4));
        root.getLeft().setRight(new Node(5));
        root.getRight().setLeft(new Node(6));
        root.getRight().setRight(new Node(9));
        return root;

    }
}
