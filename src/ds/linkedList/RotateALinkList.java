package ds.linkedList;

import java.util.Scanner;

public class RotateALinkList {

    public static void rotate(Node head, int k) {

        if (head == null) {
            return;
        }
        int i = 1;
        Node current = head;
        while (i < k && current != null) {
            current = current.next;
            i++;
        }
        if (current == null) {
            return;
        }

        Node next = current.next;
        Node temp = next;
        while (next.next != null) {
            next = next.next;
        }
        next.next = head;
        head = temp;
        current.next = null;

        //For Printing
        current = head;
        while (current != null) {
            System.out.print(current + " ");
            current = current.next;
        }
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
            RotateALinkList.rotate(head, Integer.parseInt(scanner.nextLine()));
        }
    }
}
