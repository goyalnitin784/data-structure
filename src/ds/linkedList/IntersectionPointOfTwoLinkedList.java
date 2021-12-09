package ds.linkedList;

public class IntersectionPointOfTwoLinkedList {

    public static int intersectPoint(Node headA, Node headB) {

        int lengthA = 0;
        int lengthB = 0;

        Node currentNodeA = headA;
        Node currentNodeB = headB;

        while (currentNodeA != null) {
            lengthA++;
            currentNodeA = currentNodeA.next;
        }

        while (currentNodeB != null) {
            lengthB++;
            currentNodeB = currentNodeB.next;
        }

        int diff = 0;
        int i = 0;
        if (lengthA > lengthB) {
            diff = lengthA - lengthB;
            while (i < diff) {
                if(headA==null){
                    return -1;
                }
                headA = headA.next;
                i++;
            }
        } else {
            diff = lengthB - lengthA;
            while (i < diff) {
                if(headB==null){
                    return -1;
                }
                headB = headB.next;
                i++;
            }
        }

        while (headA != null && headB != null) {
            if (headA == headB) {
                return 1;
            }
            headA = headA.next;
            headB = headB.next;
        }

        return -1;

    }
}
