package ds.linkedList;

import java.util.Scanner;

public class PairwiseSwap {


    public static Node pairwiseSwap(Node head) {
        int k=2;
        if (head == null || head.next == null) {
            return head;
        }

        Node current = head;
        Node prev = null;
        Node next = null;

        int i=0;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            i++;
        }
        head.next = pairwiseSwap(current);
        return prev;
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
            PairwiseSwap.pairwiseSwap(head);
        }
    }


}
