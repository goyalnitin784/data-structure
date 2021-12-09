package ds.linkedList;

public class AddTwoNumberInALinkedList {


    public static Node addTwoLists(Node first, Node second) {


        if (second == null) {
            return first;
        }

        if (first == null) {
            return second;
        }
        int size1 = getSize(first);

        int size2 = getSize(second);

        int carry = 0;
        if (size1 == size2) {
            carry = addListOfSameSize(first, second);
            if (carry > 0) {
                Node node = new Node(carry);
                node.next = first;
                return node;
            } else {
                return first;
            }
        } else {
            int diff = -1;
            if (size1 > size2) {
                diff = size1 - size2;
                Node node = seek(first, diff);
                carry = addListOfSameSize(node, second);
                if (carry > 0) {
                    carry = addCarry(first, carry, node);
                    if (carry > 0) {
                        Node carryNode = new Node(carry);
                        carryNode.setNext(first);
                        return carryNode;
                    } else {
                        return first;
                    }
                }
            } else {
                diff = size2 - size1;
                Node node = seek(second, diff);
                carry = addListOfSameSize(first, node);
                if (carry > 0) {
                    carry = addCarry(first, carry, node);
                }
                if (carry > 0) {
                    Node carryNode = new Node(carry);
                    carryNode.setNext(first);
                    return carryNode;
                } else {
                    return first;
                }
            }
        }
        return first;
    }

    private static int addCarry(Node node, int carry, Node tillNode) {
        if (node == tillNode) {
            return carry;
        }
        carry = addCarry(node.next, carry, tillNode);
        int data = (node.data + carry) % 10;
        carry = (node.data + carry) / 10;
        node.data = data;
        return carry;
    }

    private static Node seek(Node node, int count) {

        int i = 0;
        while (i < count) {
            node = node.next;
            i++;
        }
        return node;
    }

    private static int addListOfSameSize(Node node1, Node node2) {

        if (node1 == null) {
            return 0;
        }
        int carry = addListOfSameSize(node1.next, node2.next);
        int data = (node1.data + node2.data + carry) % 10;
        int c = (node1.data + node2.data + carry) / 10;
        node1.data = data;
        return c;
    }


    private static int getSize(Node node) {

        int size = 0;
        while (node != null) {
            node = node.next;
            size++;
        }
        return size;
    }

    public static void main(String[] args) {
        Node n1 = ListUtil.generateList();
        Node n2 = ListUtil.generateList2();
        addTwoLists(n1, n2);

    }

}
