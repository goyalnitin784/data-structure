package ds.tree;

public class TreeUtil {

    public static TreeNode createTree(){

        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(7));
        return root;

    }

    public static TreeNode createTreeForK(){

        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(3));
        root.setRight(new TreeNode(-1));
        root.getLeft().setLeft(new TreeNode(2));
        root.getLeft().setRight(new TreeNode(1));
        root.getRight().setLeft(new TreeNode(4));
        root.getRight().setRight(new TreeNode(5));
        root.left.right.setLeft(new TreeNode(1));
        root.right.left.setLeft(new TreeNode(1));
        root.right.left.setRight(new TreeNode(2));
        root.right.right.setRight(new TreeNode(6));
        return root;

    }
    public static TreeNode createTree2(){

        TreeNode root = new TreeNode(1);
        root.setLeft(new TreeNode(2));
        root.setRight(new TreeNode(3));
        root.getLeft().setLeft(new TreeNode(4));
        root.getLeft().setRight(new TreeNode(5));
        root.getRight().setLeft(new TreeNode(6));
        root.getRight().setRight(new TreeNode(9));
        return root;

    }
}
