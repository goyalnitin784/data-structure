package ds.linkedList;

public class ReverseLinkList {

    public Node reverse(Node head){

        return null;

    }
    public static void main(String[] args) {

        Node head = ListUtil.generateList();
        ListUtil.printNodes(head);
        head = new ReverseLinkList().reverse(head);
        System.out.println(head);
    }
}
