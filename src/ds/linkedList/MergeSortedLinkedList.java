package ds.linkedList;

import java.util.Scanner;

public class MergeSortedLinkedList {

    public static Node MergeLists(Node headA, Node headB) {
        if (headA == null) {
            return headB;
        }
        if (headB == null) {
            return headA;
        }

        Node result = null;
        if (headA.data < headB.data) {
            result = headA;
            result.next = MergeLists(headA.next, headB);
        } else {
            result = headB;
            result.next = MergeLists(headA, headB.next);
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int testCases = Integer.parseInt(scanner.nextLine());
        for (int m = 0; m < testCases; m++) {
            int size = Integer.parseInt(scanner.nextLine());
            String input = scanner.nextLine();
            Node current = null;
            String[] inputs = input.split(" ");
            Node head = new Node(Integer.parseInt(inputs[0]));
            current = head;
            int i = 1;
            while (true) {
                if (i == size) {
                    break;
                }
                Node node = new Node(Integer.parseInt(inputs[i]));
                current.next = node;
                current = node;
                i++;
            }
        }
    }
}
