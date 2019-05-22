package ds.tree;

public class HeightOfATree {


    public static int height(Node node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        int heightLeft = -1;
        int heightRight = -1;
        if (node.left != null) {
            heightLeft = 1 + height(node.left);
        }

        if (node.right != null) {
            heightRight = 1 + height(node.right);
        }

        if (heightLeft > heightRight) {
            return heightLeft;
        } else {
            return heightRight;
        }
    }

    public static void main(String[] args) {
        Node node = TreeUtil.createTree();
        int height = height(node);

    }
}
