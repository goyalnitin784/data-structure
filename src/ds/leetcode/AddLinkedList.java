package ds.leetcode;

public class AddLinkedList {

  public static void main(String[] args) {
    ListNode first = new ListNode(9);
    first.next = new ListNode(9);
    first.next.next = new ListNode(9);
    first.next.next.next = new ListNode(9);
    first.next.next.next.next = new ListNode(9);
    first.next.next.next.next.next = new ListNode(9);
    first.next.next.next.next.next.next = new ListNode(9);

    ListNode sec = new ListNode(9);
    sec.next = new ListNode(9);
    sec.next.next = new ListNode(9);
    sec.next.next.next = new ListNode(9);

    ListNode listNode = new Solution().addTwoNumbers(first, sec);

    System.out.println(listNode);
  }
}


class ListNode {

  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }
}

class Solution {

  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    if (l1 == null) {
      return l2;
    }
    if (l2 == null) {
      return l1;
    }
    ListNode output = null;
    ListNode head  = null;
    int carry = 0;
    while (l1 != null || l2 != null) {
      ListNode temp = null;
      if (l1 != null && l2 != null) {
        temp = new ListNode((l1.val + l2.val + carry) % 10);
        carry = (l1.val + l2.val + carry) / 10;
        l1 = l1.next;
        l2 = l2.next;
      } else if (l1 != null && l2 == null) {
        temp = new ListNode((l1.val + carry) % 10);
        carry = (l1.val + carry) / 10;
        l1 = l1.next;
      } else if (l1 == null && l2 != null) {
        temp = new ListNode((l2.val + carry) % 10);
        carry = (l2.val + carry) / 10;
        l2 = l2.next;
      }
      if (output == null) {
        output = temp;
        head  = temp;
      } else {
        output.next = temp;
        output = temp;
      }
    }
    if(carry!=0){
      output.next = new ListNode(carry);
    }
    return head;
  }
}
