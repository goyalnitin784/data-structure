package ds.linkedList;

public class ListUtil {

    public static Node generateList(){
        Node head = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        head.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        return head;
    }

    public static Node generateList2(){
        Node head = new Node(9);
        Node node2 = new Node(8);
        Node node3 = new Node(7);
        head.setNext(node2);
        node2.setNext(node3);
        return head;
    }

    public  static void printNodes(Node head){
        if(head==null){
            return;
        }
        while (head!=null){
            System.out.print(head.data+"  ");
            head = head.getNext();
        }
    }

    public static int calculateLength(Node head){
                return 0;
    }

}
