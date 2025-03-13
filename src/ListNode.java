/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order, and each of their nodes contains a single digit.
 * Add the two numbers and return the sum as a linked list.
 */

public class ListNode {

     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }

     public static ListNode addTwo(ListNode l1, ListNode l2) {
          return sumTwoNodes(l1, l2, 0);
     }

     public static ListNode sumTwoNodes(ListNode l1, ListNode l2, int rest) {

          if (l1.next != null && l2.next != null) {
               int sum = l1.val + l2.val + rest;
               return new ListNode(valueWithoutRest(sum), sumTwoNodes(l1.next, l2.next, isRest(sum)));
          }

          if (l1.next == null && l2.next != null) {
               int sum = l1.val + l2.val + rest;
               return new ListNode(valueWithoutRest(sum), sumOneNode(l2.next, isRest(sum)));
          } else if (l1.next != null && l2.next == null) {
               int sum = l1.val + l2.val + rest;
               return new ListNode(valueWithoutRest(sum), sumOneNode(l1.next, isRest(sum)));

          }

          int sum = l1.val + l2.val + rest;
          if (sum < 10) {
               return new ListNode(sum);
          } else {
               return new ListNode(valueWithoutRest(sum), new ListNode(sum/10));
          }

     }

     public static ListNode sumOneNode(ListNode listNode, int rest) {
          int sum = listNode.val + rest;
          if (listNode.next != null) {
               sum = listNode.val + rest;
               return new ListNode(valueWithoutRest(sum), sumOneNode(listNode.next, isRest(sum)));
          } else {
               if (sum < 10) {
                    return new ListNode(sum);
               } else {
                    return new ListNode(valueWithoutRest(sum), new ListNode(sum/10));
               }
          }
     }

     public static int isRest(int sum) {
          if (sum >= 10) {
               return 1;
          }
          return 0;
     }

     public static int valueWithoutRest(int sum) {
          if (sum >= 10) {
               return sum - 10;
          }
          return sum;
     }

     public static void main(String[]  args) {
          ListNode soloListNode = new ListNode(1);

          ListNode listNode1 = new ListNode(1);
          ListNode listNode2 = new ListNode(9, listNode1);
          ListNode listNode3 = new ListNode(9, listNode2);

          ListNode test = addTwo(soloListNode, listNode3);

          System.out.println(test);
     }


}
