package ds.linkedList;

public class Node {

    public Node(int data) {
        this.data = data;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public void setBottom(Node bottom) {
        this.bottom = bottom;
    }

    public Node getBottom() {
        return bottom;
    }

    public int getCarry() {
        return carry;
    }

    public void setCarry(int carry) {
        this.carry = carry;
    }

    int data;
    Node next;
    Node bottom;
    int carry;


}
