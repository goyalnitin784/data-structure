package ds.tree;

public class Node implements Comparable,Cloneable{

    Integer data;
    Node left;
    Node right;
    Node nextRight;

    public Node(){

    }

    public Node(Integer data){
        this.data = data;
    }
    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getNextRight() {
        return nextRight;
    }

    public void setNextRight(Node nextRight) {
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
