package ds.linkedList;

import java.util.Scanner;

public class MiddleElementOfALinkedList {

    public static void printMid(Node head) {

        if (head == null) {
            return;
        }
        if (head.next == null) {
            System.out.println(head.data);
        }
        Node slow = head;
        Node fast = head;

        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        System.out.println(slow);
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
            MiddleElementOfALinkedList.printMid(head);
        }
    }
}
