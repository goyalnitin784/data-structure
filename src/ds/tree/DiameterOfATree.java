package ds.tree;

public class DiameterOfATree {

    public static int find(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + Math.max(find(node.left), find(node.right));
    }

    public static void main(String[] args) {
        Node root = TreeUtil.createTree();
        System.out.println(find(root));
    }

}
