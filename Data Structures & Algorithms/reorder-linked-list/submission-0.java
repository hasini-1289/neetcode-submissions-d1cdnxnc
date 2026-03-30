class Solution {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) return;

        // STEP 1: find middle
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // STEP 2: reverse second half
        ListNode prev = null;
        ListNode curr = slow.next;
        slow.next = null; // split list

        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        // STEP 3: merge two halves
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode t1 = first.next;
            ListNode t2 = second.next;

            first.next = second;
            second.next = t1;

            first = t1;
            second = t2;
        }
    }
}
