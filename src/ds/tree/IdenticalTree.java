package ds.tree;

public class IdenticalTree {
    boolean check(TreeNode treeNode1, TreeNode treeNode2){
        return (treeNode1 ==null && treeNode2 ==null) || (treeNode1.data== treeNode2.data && check(
            treeNode1.left, treeNode2.left) && check(treeNode1.right , treeNode2.right));
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = TreeUtil.createTree();
        TreeNode treeNode2 = TreeUtil.createTree2();
        System.out.println(new IdenticalTree().check(treeNode1, treeNode2));
    }
}
