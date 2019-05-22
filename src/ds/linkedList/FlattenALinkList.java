package ds.linkedList;

import java.util.Scanner;

public class FlattenALinkList {

    public static Node flatten(Node root) {
        if (root == null || root.next==null) {
            return root;
        }
        Node output = null;
        output = flatten(root.next);
        return merge(root, output);
    }

    public static Node merge(Node n1, Node n2) {
        if (n1 == null) {
            return n2;
        }
        if (n2 == null) {
            return n1;
        }

        Node result = null;

        if (n1.data < n2.data) {
            result = n1;
            result.next = merge(n1.bottom, n2);
        } else {
            result = n2;
            result.next = merge(n1, n2.bottom);
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
            DetectALoopInALinkList.detectLoop(head);
        }
    }

}
