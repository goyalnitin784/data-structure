package ds.tree;

public class IdenticalTree {
    boolean check(Node node1,Node node2){
        return (node1==null && node2==null) || (node1.data==node2.data && check(node1.left,node2.left) && check(node1.right ,node2.right));
    }

    public static void main(String[] args) {
        Node node1 = TreeUtil.createTree();
        Node node2 = TreeUtil.createTree2();
        System.out.println(new IdenticalTree().check(node1,node2));
    }
}
