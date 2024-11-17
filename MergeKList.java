/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

//pq of size k -> store all the heads of the list
//move the minimum pointer inside the list accordingly
// the code is challenging to implement
// practice code again, write on paper if needed

// TC: O(n log k)
// SC: O(k)

class Solution {

  public ListNode mergeKLists(ListNode[] lists) {
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

    for (ListNode head : lists) {
      if (head != null) {
        pq.add(head);
      }
    }

    ListNode dummy = new ListNode(-1);
    ListNode curr = dummy;

    while (!pq.isEmpty()) {
      ListNode min = pq.poll();
      curr.next = min;
      curr = curr.next;

      if (min.next != null) {
        pq.add(min.next);
      }
    }

    return dummy.next;
  }
}
