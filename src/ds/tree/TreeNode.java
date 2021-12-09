package ds.tree;

public class TreeNode implements Comparable,Cloneable{

    Integer data;
    TreeNode left;
    TreeNode right;
    TreeNode nextRight;

    public TreeNode(){

    }

    public TreeNode(Integer data){
        this.data = data;
    }
    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getNextRight() {
        return nextRight;
    }

    public void setNextRight(TreeNode nextRight) {
        this.nextRight = nextRight;
    }

    @Override
    public String toString() {
        return data.toString();
    }

    @Override
    public int compareTo(Object o) {
        if(this==o){
            return 1;
        }
        return 0;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
