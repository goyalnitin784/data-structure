package ds.tree;

public class MirrorImageOrNot {

    public boolean execute(Node node1, Node node2) {

        if (node1 == null && node2 == null) {
            return true;
        }
        if (node1 != null && node2 == null) {
            return false;
        }
        if (node2 != null && node1 == null) {
            return false;
        }
        if (node1.getData() == node2.getData()) {
            return true;
        }
        return execute(node1.left, node2.right) && execute(node1.right, node2.left);
    }

    public static void main(String[] args) {
        Node node = TreeUtil.createTree();
        Node node2 = TreeUtil.createTree();

    }
}
