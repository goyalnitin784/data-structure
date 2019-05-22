package ds.linkedList;

import java.util.Scanner;

public class NthNodeFromEnd {

    public static int getNthFromLast(Node head, int n) {
        int i = 0;

        Node current = head;
        while (i < n) {
            if (current != null) {
                current = current.next;
                i++;
            } else {
                return -1;
            }
        }

        Node initial = head;
        while (current != null) {
            current = current.next;
            initial = initial.next;
        }
        return initial.data;
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
            NthNodeFromEnd.getNthFromLast(head, Integer.parseInt(scanner.nextLine()));
        }
    }
}
